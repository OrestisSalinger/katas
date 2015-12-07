package eu.salingers.tooling.servers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.JavaScriptPage;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

import eu.salingers.tooling.servers.model.pages.Page;
import eu.salingers.tooling.servers.model.servers.Server;

public class HttpUrlServerConnection {

  private static final int NUMBER_OF_TRIALS = 10;
  private static final int MS_WAIT_FOR_BACKGROUND_SCRIPT = 60_000;

  public Map<String, String> getHttpResponseCodesWithLogin(List<Server> servers) {
    Map<String, String> responseCodes = new HashMap<>();
    // TODO: ref to stream
    for (Server s : servers) {
      responseCodes.put(s.getUrl(), getResponseCode(s.getUrl(), s.getUsername(), s.getPassword()));
    }
    return responseCodes;
  }

  public String getResponseCode(String address, String username, String password) {
    String responseCode = null;
    URLConnection conn = null;
    try {
      URL url = new URL(address);
      conn = url.openConnection();
      conn.setConnectTimeout(30000);
      if (!username.equals("--") && !password.equals("--")) {
        prepareLoginSession(username, password, conn);
      }
      responseCode = conn.getHeaderField(null);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      conn = null;
    }

    return responseCode;
  }

  public Server setResponseInServer(Server server) {
    if (server.isJavascriptEnabled() && !server.getPassword().equals("--")) {
      getPageByHtmlUnitLogin(server);
    } else {
      // TODO sal: Ref conn to Optional<URLConnection>
      URLConnection conn = null;
      try {
        URL url = new URL(server.getUrl());
        conn = url.openConnection();
        conn.setConnectTimeout(30000);
        if (!server.getPassword().equals("--")) {
          prepareLoginSession(server.getUsername(), server.getPassword(), conn);
        }
        setResponseValuesInServer(server, conn);
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        conn = null;
      }
    }
    return server;
  }

  private void setResponseValuesInServer(final Server server, final URLConnection conn) throws IOException {
    // TODO in server handler: get the call method as a parameter(IF Predicate).
    // Should not know the model here.
    server.setResponseCode(conn.getHeaderField(null));
    List<NameValuePair> nvps = new ArrayList<>();
    final Map<String, List<String>> headerFields = conn.getHeaderFields();
    headerFields.keySet().stream().forEach(e -> nvps.add(new NameValuePair(e, Arrays.toString(headerFields.get(e).toArray()))));
    server.setResponseHeaders(nvps);
    server.setResponseHtml(getHtmlFromLoginSession(conn));
  }

  private static void prepareLoginSession(String username, String password, URLConnection conn) {
    String user_pass = username + ":" + password;
    String encoded = Base64.getEncoder().encodeToString(user_pass.getBytes());
    conn.setRequestProperty("Authorization", "Basic " + encoded);
  }

  private static String getHtmlFromLoginSession(URLConnection conn) throws IOException {
    StringBuffer sb = new StringBuffer();
    try (BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));) {
      String line = "";
      while ((line = input.readLine()) != null) {
        sb.append(line + "\n");
      }
      input.close();
    }
    return sb.toString();
  }

  private static void getPageByHtmlUnitLogin(Server server) {
    try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);) {
      setupWebClient(webClient, server);
      setResponseData(server, webClient);

      webClient.close();
    } catch (FailingHttpStatusCodeException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (MalformedURLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    // AjaxController a = new AjaxController();
    // a.processSynchron(page,new WebRequest(new URL(server.getUrl())), true);
  }

  private static void setResponseData(Server server, final WebClient webClient) throws IOException, MalformedURLException {
    HtmlPage page = webClient.getPage(server.getUrl());
    HtmlDivision htmlDivision = null;  
     System.out.println("Setting Response Data");
    
    for (int i = 0; i < NUMBER_OF_TRIALS; i++) {
      List<?> containerResult = page.getByXPath(server.getRequestPages().get(0).getContainer());
      htmlDivision = (HtmlDivision) containerResult.get(0);
//      server.setResponseHtml(htmlDivision.get().asXml());
      final String asXml = htmlDivision.asXml();
      System.out.println(i + " asXml " + asXml);
      if (asXml.isEmpty() || asXml.contains("loading")) {
        System.out.println("Waiting " + i + " " + asXml);
        synchronized (page) {
          try {
            page.wait(500);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      } else {
        break;

      }
//      System.out.println(i + " div: " + htmlDivision.asText());
    }
    Page responsePage = new Page();
    responsePage.setDiv(htmlDivision);
    server.addResponsePage(responsePage);
    server.setResponseCode(page.getWebResponse().getStatusMessage());
    server.setResponseHeaders(page.getWebResponse().getResponseHeaders());
    setJSExceptionsInServer(server, (CancellingJavaScriptErrorListener) webClient.getJavaScriptErrorListener());
  }

  private static void setJSExceptionsInServer(Server server, CancellingJavaScriptErrorListener js) {
    int errorCount = 0;
    errorCount = js.errorCount;
    if (errorCount > 2) {
      server.setException("A Backgrund Script Is Reloading Infinitely");
    }
  }

  private static void setAuthorizationRequestHeader(Server server, final WebClient webClient) {
    final String username = server.getUsername();
    final String password = server.getPassword();
    String user_pass = username + ":" + password;
    String encoded = Base64.getEncoder().encodeToString(user_pass.getBytes());
    webClient.addRequestHeader("Authorization", "Basic " + encoded);
  }

  private static void setupWebClient(final WebClient webClient, Server server) {
    webClient.getOptions().setJavaScriptEnabled(true);
    webClient.getOptions().setCssEnabled(false);
    webClient.getOptions().setUseInsecureSSL(true);
    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.setAjaxController(new NicelyResynchronizingAjaxController());
    webClient.getCookieManager().setCookiesEnabled(true);
    webClient.waitForBackgroundJavaScript(MS_WAIT_FOR_BACKGROUND_SCRIPT);
    setLoggingOffAddListener(webClient);
    setAuthorizationRequestHeader(server, webClient);

  }

  private static void setLoggingOffAddListener(WebClient webClient) {
    LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
    java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
    webClient.setJavaScriptErrorListener(new CancellingJavaScriptErrorListener());
    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
  }

}
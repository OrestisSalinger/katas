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
import java.util.logging.Level;

import org.apache.commons.logging.LogFactory;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

import eu.salingers.tooling.servers.model.pages.Page;
import eu.salingers.tooling.servers.model.servers.Server;

public class HttpUrlServerConnection {

  private static final int NUMBER_OF_TRIALS = 10;
  private static final int MS_WAIT_FOR_BACKGROUND_SCRIPT = 60_000;

  public Map<String, String> getHttpResponseCodesWithLogin(List<Server> servers) {
    Map<String, String> responseCodes = new HashMap<>();
    // TODO: refactor to stream
    for (Server s : servers) {
      responseCodes.put(s.getUrl(), getResponseCode(s.getUrl(), s.getUsername(), s.getPassword()));
    }
    return responseCodes;
  }

  private String getResponseCode(String address, String username, String password) {
    String responseCode = null;
    URLConnection urlConnection = null;
    try {
      URL url = new URL(address);
      urlConnection = url.openConnection();
      urlConnection.setConnectTimeout(30000);
      if (!username.equals("--") && !password.equals("--")) {
        prepareLoginSession(username, password, urlConnection);
      }
      responseCode = urlConnection.getHeaderField(null);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      urlConnection = null;
    }

    return responseCode;
  }

  public Server setResponseInServer(Server server) {
    if (server.isJavascriptEnabled() && !server.getPassword().equals("--")) {
      getPageByHtmlUnitLogin(server);
    } else {
//    TODO sal: Refactor conn to Optional<URLConnection>
      System.err.println("JS is NOT enabled!!!");
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
//    System.out.println("Entering getHtmlFromLoginSession");
    StringBuffer sb = new StringBuffer();
    try (BufferedReader input = new BufferedReader(new InputStreamReader(conn.getInputStream()));) {
      String line = "";
      while ((line = input.readLine()) != null) {
        sb.append(line + "\n");
      }
      input.close();// TODO check if needed
    }
    return sb.toString();
  }

  private static void getPageByHtmlUnitLogin(Server server) {
    try (final WebClient webClient = new WebClient(BrowserVersion.FIREFOX_38);) {
      setupWebClient(webClient, server);
      setResponseData(server, webClient);
    } catch (FailingHttpStatusCodeException e) {
      e.printStackTrace();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }

  private static void setResponseData(Server server, final WebClient webClient) throws IOException, MalformedURLException {
    final long startMS = System.currentTimeMillis();
    HtmlPage page = webClient.getPage(server.getUrl());
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    executeJavaScriptCommands(server,page, startMS);
    Page responsePage = new Page();
//    final InteractivePage iPage = responsePage.getiPage();
    server.addResponsePage(responsePage);
    server.setResponseCode(page.getWebResponse().getStatusMessage());
    server.setResponseHeaders(page.getWebResponse().getResponseHeaders());
    setJSExceptionsInServer(server, (CancellingJavaScriptErrorListener) webClient.getJavaScriptErrorListener());
  }

  private static void executeJavaScriptCommands(Server server, HtmlPage page, long startMs) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
    
    for (String command : server.getJsCommands()) {
      System.out.println("Executing: " + command);
      page.executeJavaScript(command);
    }
    System.out.println("page after click on logout \n" + page.asText());
    HtmlPage newPage = page.getWebClient().getPage(server.getUrl());
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("page after click on logout \n" + newPage.asText());
    System.out.println(getElapsedSeconds(startMs));
  }

  private static String getElapsedSeconds(final long startMS) {
    return "Time: " + (System.currentTimeMillis() - startMS) / 1000 + " Sek";
  }

  @SuppressWarnings("unused")
  private static void waitForElement(HtmlPage page, DomElement domElement) {
    System.out.println("Waiting for " + domElement.getId());
    for (int i = 0; i < NUMBER_OF_TRIALS; i++) {
      if(domElement.getId().equals("loading")){
        synchronized (HttpUrlServerConnection.class) {
          try {
            page.wait(500);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }    // TODO Auto-generated method stub

      }else{
        break;
        //      return domElement;
      }
    }      
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
    System.out.println("Entering setupWebClient");
    webClient.getOptions().setJavaScriptEnabled(true);
    webClient.getOptions().setCssEnabled(true);
    webClient.getOptions().setUseInsecureSSL(true);
    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
    webClient.setAjaxController(new NicelyResynchronizingAjaxController());
    webClient.getCookieManager().setCookiesEnabled(true);
    webClient.waitForBackgroundJavaScript(MS_WAIT_FOR_BACKGROUND_SCRIPT);
//    setLoggingOffAndAddListener(webClient);
    setAuthorizationRequestHeader(server, webClient);
    System.out.println("Exiting setupWebClient");
  }

  @SuppressWarnings("unused")
  private static void setLoggingOffAndAddListener(WebClient webClient) {
    LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(Level.OFF);
    java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);
    webClient.setJavaScriptErrorListener(new CancellingJavaScriptErrorListener());
    webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    webClient.getOptions().setThrowExceptionOnScriptError(false);
  }

}
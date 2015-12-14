package eu.salingers.tooling.servers.model.servers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.gargoylesoftware.htmlunit.util.NameValuePair;

import eu.salingers.tooling.servers.model.pages.Page;
import eu.salingers.tooling.servers.notify.EmailNotifier;
import eu.salingers.tooling.servers.notify.Notifier;
public class Server {

  private String exception = "";
  private boolean isJavascriptEnabled;
  private Notifier notifier = new EmailNotifier();
  private String password;
  private List<String> jsCommands = new ArrayList<>();
  private List<Page> requestPages = new ArrayList<>();
  private String[] responseCodeTime = new String[2];
  private List<NameValuePair> responseHeaders;
  private String responseHtml;
  private List<Page> responsePages = new ArrayList<>();
  private String url;
  private String username;
  private boolean doLogin;

  /**
   * @param url
   * @param username
   * @param password
   */
  public Server(String url, Notifier notifier, boolean isJavascriptEnabled,String username, String password) {
    this.url = url;
    this.isJavascriptEnabled = isJavascriptEnabled;
    this.username = username;
    this.password = password;
    this.notifier = notifier;
  }

  /**
   * @param url
   * @param username
   * @param password
   */
  public Server(String url, boolean isJavascriptEnabled, Notifier notifier) {
    this.url = url;
    this.isJavascriptEnabled = isJavascriptEnabled;
    this.notifier = notifier;
  }

  public void addRequestPage(Page requestPage) {
    requestPages.add(requestPage);
  }

  public void addResponsePage(Page responsePage) {
    responsePages.add(responsePage);
  }

  public String getException() {
    return exception;

  }

  public String getPassword() {
    return password;
  }

  public List<Page> getRequestPages() {
    return requestPages;
  }

  public String getResponseCode() {
    return responseCodeTime[0];
  }

  public List<NameValuePair> getResponseHeaders() {
    return responseHeaders;
  }

  public String getResponseHtml() {
    return responseHtml;
  }

  public List<Page> getResponsePages() {
    return responsePages;
  }

  public String getResponseTime() {
    return responseCodeTime[1];
  }

  public String getUrl() {
    return url;
  }

  public String getUsername() {
    return username;
  }

  public boolean isJavascriptEnabled() {
    return isJavascriptEnabled;
  }

  public void setException(String message) {
    exception = message;
  }

  public void setJavascriptEnabled(boolean isJavascriptEnabled) {
    this.isJavascriptEnabled = isJavascriptEnabled;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setRequestPages(List<Page> pages) {
    this.requestPages = pages;
  }

  public void setResponseCode(String responseCode) {
    System.out.println("Set Response Code(" + responseCode + ") in " + url);
    this.responseCodeTime[0] = responseCode;
    if (!responseCode.contains("OK")) {
      notifier.notifyUser();
    }
  }

  public void setResponseHeaders(List<NameValuePair> headers) {
    responseHeaders = headers;
  }

  public void setResponseHtml(String string) {
    responseHtml = string;
  }

  public void setResponsePages(List<Page> responsePages) {
    this.responsePages = responsePages;
  }

  public void setResponseTime(String responseTime) {
    this.responseCodeTime[1] = responseTime;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  
  public void setDoLogin(boolean doLogin) {
    this.doLogin = doLogin;
  }

  public boolean getDoLogin() {
    return doLogin;
  }

  public List<String> getJsCommands() {
    return Collections.unmodifiableList(jsCommands);
  }

  public void setJsCommands(List<String> jsCommands) {
    this.jsCommands = jsCommands;
  }
  
  public void addJsCommands(List<String> jsCommands) {
    jsCommands.addAll(jsCommands);
  }
  
  public void addJsCommand(String jsCommand) {
    jsCommands.add(jsCommand);
  }
  
  @Override
  public String toString() {
    return "Server [" + (exception != null ? "exception=" + exception + ", " : "") + "isJavascriptEnabled=" + isJavascriptEnabled
        + ", " + (notifier != null ? "notifier=" + notifier + ", " : "") + (password != null ? "password=" + password + ", " : "")
        + (requestPages != null ? "requestPages=" + requestPages + ", " : "")
        + (responseCodeTime != null ? "responseCodeTime=" + Arrays.toString(responseCodeTime) + ", " : "")
        + (responseHeaders != null ? "responseHeaders=" + responseHeaders + ", " : "")
        + (responseHtml != null ? "responseHtml=" + responseHtml + ", " : "")
        + (responsePages != null ? "responsePages=" + responsePages + ", " : "") + (url != null ? "url=" + url + ", " : "")
        + (username != null ? "username=" + username + ", " : "") + "doLogin=" + doLogin + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (doLogin ? 1231 : 1237);
    result = prime * result + ((exception == null) ? 0 : exception.hashCode());
    result = prime * result + (isJavascriptEnabled ? 1231 : 1237);
    result = prime * result + ((notifier == null) ? 0 : notifier.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result + ((requestPages == null) ? 0 : requestPages.hashCode());
    result = prime * result + Arrays.hashCode(responseCodeTime);
    result = prime * result + ((responseHeaders == null) ? 0 : responseHeaders.hashCode());
    result = prime * result + ((responseHtml == null) ? 0 : responseHtml.hashCode());
    result = prime * result + ((responsePages == null) ? 0 : responsePages.hashCode());
    result = prime * result + ((url == null) ? 0 : url.hashCode());
    result = prime * result + ((username == null) ? 0 : username.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Server other = (Server) obj;
    if (doLogin != other.doLogin)
      return false;
    if (exception == null) {
      if (other.exception != null)
        return false;
    } else if (!exception.equals(other.exception))
      return false;
    if (isJavascriptEnabled != other.isJavascriptEnabled)
      return false;
    if (notifier == null) {
      if (other.notifier != null)
        return false;
    } else if (!notifier.equals(other.notifier))
      return false;
    if (password == null) {
      if (other.password != null)
        return false;
    } else if (!password.equals(other.password))
      return false;
    if (requestPages == null) {
      if (other.requestPages != null)
        return false;
    } else if (!requestPages.equals(other.requestPages))
      return false;
    if (!Arrays.equals(responseCodeTime, other.responseCodeTime))
      return false;
    if (responseHeaders == null) {
      if (other.responseHeaders != null)
        return false;
    } else if (!responseHeaders.equals(other.responseHeaders))
      return false;
    if (responseHtml == null) {
      if (other.responseHtml != null)
        return false;
    } else if (!responseHtml.equals(other.responseHtml))
      return false;
    if (responsePages == null) {
      if (other.responsePages != null)
        return false;
    } else if (!responsePages.equals(other.responsePages))
      return false;
    if (url == null) {
      if (other.url != null)
        return false;
    } else if (!url.equals(other.url))
      return false;
    if (username == null) {
      if (other.username != null)
        return false;
    } else if (!username.equals(other.username))
      return false;
    return true;
  }
}

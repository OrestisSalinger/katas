package eu.salingers.tooling.servers.model;

import java.util.Arrays;
import java.util.List;

import com.gargoylesoftware.htmlunit.util.NameValuePair;

import eu.salingers.tooling.servers.notify.IOSNotifier;
import eu.salingers.tooling.servers.notify.Notifier;

public class Server {
 
  private String url;
  private String username;
  private String password;
  private String[] responseCodeTime = new String[2]; 
  private Notifier notifier;
  private List<NameValuePair> responseHeaders;
  private String responseHtml;
  private String exception = "";
  private boolean isJavascriptEnabled;
  public List<NameValuePair> getResponseHeaders() {
    return responseHeaders;
  }



  public void setResponseHeaders(List<NameValuePair> headers) {
    responseHeaders = headers;
  }



  public String getResponseHtml() {
    return responseHtml;
  }



  public void setResponseHtml(String string) {
    responseHtml = string;
  }

  public void setPassword(String password) {
    this.password = password;
  }

   


  /**
   * @param url
   * @param username
   * @param password
   */
  public Server(String url, String username, String password, boolean isJsEnabled) {
    this.url = url;
    this.username = username;
    this.password = password;
    this.isJavascriptEnabled = isJsEnabled;
    notifier = new IOSNotifier();
  }

  
  
  public String getUrl() {
    return url;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getPassword() {
    return password;
  }

  public String getResponseCode() {
    return responseCodeTime[0];
  }
  public void setResponseCode(String responseCode) {
    System.out.println("Set Response Code("+ responseCode +") in " + url);
    this.responseCodeTime[0] = responseCode;
    if(!responseCode.contains("OK")) {
      notifier.notifyUser();
    }
  }
  
  public String getResponseTime() {
    return responseCodeTime[1];
  }
  public void setResponseTime(String responseTime) {
    this.responseCodeTime[1] = responseTime;
  }



  public void setException(String message) {
    exception = message;    
  }
  public String getException() {
     return exception;
    
  }



  public boolean isJavascriptEnabled() {
    return isJavascriptEnabled;
  }



  @Override
  public String toString() {
    return "Server [" + (url != null ? "url=" + url + ", " : "") + (username != null ? "username=" + username + ", " : "")
        + (password != null ? "password=" + password + ", " : "")
        + (responseCodeTime != null ? "responseCodeTime=" + Arrays.toString(responseCodeTime) + ", " : "")
        + (notifier != null ? "notifier=" + notifier + ", " : "") + (responseHeaders != null ? "responseHeaders=" + responseHeaders + ", " : "")
        + (responseHtml != null ? "responseHtml=" + responseHtml + ", " : "") + (exception != null ? "exception=" + exception + ", " : "")
        + "javascript_enabled=" + isJavascriptEnabled + "]";
  }

  
  
  }

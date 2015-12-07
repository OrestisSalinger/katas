package eu.salingers.tooling.servers.model.servers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.gargoylesoftware.htmlunit.util.NameValuePair;

import eu.salingers.tooling.servers.model.pages.Page;
import eu.salingers.tooling.servers.notify.EmailNotifier;
import eu.salingers.tooling.servers.notify.IOSNotifier;
import eu.salingers.tooling.servers.notify.Notifier;
public class Server {

  private String exception = "";
  private boolean isJavascriptEnabled;
  private Notifier notifier;
  private String password;
  private List<Page> requestPages = new ArrayList<>();
  private String[] responseCodeTime = new String[2];
  private List<NameValuePair> responseHeaders;
  private String responseHtml;
  private List<Page> responsePages = new ArrayList<>();
  private String url;
  private String username;

  /**
   * @param url
   * @param username
   * @param password
   */
  public Server(String url, String username, String password) {
    this.url = url;
    this.username = username;
    this.password = password;
    notifier = new IOSNotifier();
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

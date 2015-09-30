package eu.salingers.tooling.servers;

import java.net.MalformedURLException;
import java.net.URL;

import com.gargoylesoftware.htmlunit.InteractivePage;
import com.gargoylesoftware.htmlunit.ScriptException;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class CancellingJavaScriptErrorListener implements com.gargoylesoftware.htmlunit.javascript.JavaScriptErrorListener {

  int errorCount = 0;
  String lastErrorException = "";

  @Override
  public void loadScriptError(InteractivePage arg0, URL arg1, Exception arg2) {
    System.out.println("loadScriptError " + arg2.getMessage());
  }

  @Override
  public void malformedScriptURL(InteractivePage arg0, String arg1, MalformedURLException arg2) {
    System.out.println("malformedScriptURL ");
  }

  @Override
  public void scriptException(InteractivePage arg0, ScriptException arg1) {
    errorCount++;
    // System.out.println(errorCount + " scriptException " + arg1.getMessage());
    if (errorCount > 2) {
      arg0.cleanUp();
      ((HtmlPage) arg0).executeJavaScript("window.close();");
      lastErrorException = arg1.getMessage();
    }
  }

  @Override
  public void timeoutError(InteractivePage arg0, long arg1, long arg2) {
    System.out.println("timeoutError ");
  }

}

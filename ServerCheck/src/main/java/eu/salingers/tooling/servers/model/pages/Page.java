package eu.salingers.tooling.servers.model.pages;

import com.gargoylesoftware.htmlunit.InteractivePage;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;



public class Page {

  // TODO Need to pass function proceeding the action on the actual page from
  // server
  private InteractivePage iPage;
  private HtmlButton button;
  private String actionButtonXPath;
  private String container;  
  public HtmlDivision div;

  public HtmlDivision getDiv() {
    return div;
  }

  public void setDiv(HtmlDivision div) {
    this.div = div;
  }


  public String getActionButtonXPath() {
    return actionButtonXPath;
  }

  /**
   * @param iPage
   */
  public Page() {
  }

  public void setActionButtonXPath(String actionButtonXPath) {
    this.actionButtonXPath = actionButtonXPath;
  }

  public InteractivePage getiPage() {
    return iPage;
  }

  public HtmlButton getButton() {
    return button;
  }

  public void setButton(HtmlButton button) {
    this.button = button;
  }

  public String getContainer() {
    return container;
  }

  public void setContainer(String container) {
    this.container = container;
  }

}

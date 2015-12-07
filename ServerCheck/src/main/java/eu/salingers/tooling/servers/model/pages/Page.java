package eu.salingers.tooling.servers.model.pages;

import com.gargoylesoftware.htmlunit.InteractivePage;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;



public class Page {

  // TODO Need to pass function proceeding the action on the actual page from
  // server
  private InteractivePage iPage;
  private HtmlButton button;
  private String actionButton;
  private String container;  
  public HtmlDivision div;

  public HtmlDivision getDiv() {
    return div;
  }

  public void setDiv(HtmlDivision div) {
    this.div = div;
  }


  public String getActionButton() {
    return actionButton;
  }

  /**
   * @param iPage
   */
  public Page() {
  }

  public void setActionButton(String actionButton) {
    this.actionButton = actionButton;
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

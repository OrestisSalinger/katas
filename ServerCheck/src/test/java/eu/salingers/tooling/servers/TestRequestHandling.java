package eu.salingers.tooling.servers;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;

import eu.salingers.tooling.servers.HttpUrlServerConnection;
import eu.salingers.tooling.servers.model.pages.Page;
import eu.salingers.tooling.servers.model.servers.Server;
import eu.salingers.tooling.servers.notify.EmailNotifier;

public class TestRequestHandling extends TestServers {
  public Server server;
  public Page page;
  
  @Before
  public void getJSServerObject() {
    
    server = new Server("https://staging.identitycloud.ch/iddirect",new EmailNotifier(), true, "osaTestUserJule", "Test_123456");
    server.setJavascriptEnabled(Boolean.TRUE);
    page = new Page();
    page.setContainer("/html/body/div/div/div/div[2]/div/div[4]/div[2]");
    page.setActionButton("/html/body/div/div/div/div[2]/div/div[4]/div[2]/div[1]/div[2]");
  }

  @Test
  public void getPageByHtmlUnitLogin_jsPage_loadingCompleted() {
    HttpUrlServerConnection conni = new HttpUrlServerConnection();
    // TODO Page Object for Server telling me what JS rendered element the
    // HttpUrlServerConnection should wait for
    server.setRequestPages(Arrays.asList(page));
    conni.setResponseInServer(server);
    final String responseHtml = server.getResponsePages().get(0).getDiv().asXml();
    System.out.println("Response " + responseHtml);
    assertThat(responseHtml, not(containsString("loading")));

  }

  @Test
  public void getPageByHtmlUnitLogin_jsPage_divElementInResponseIsAccessible() throws IOException {
    HttpUrlServerConnection conni = new HttpUrlServerConnection();
    // TODO Page Object for Server telling me what JS rendered element the
    // HttpUrlServerConnection should wait for
    server.setRequestPages(Arrays.asList(page));
    conni.setResponseInServer(server);
    final String responseHtml = server.getResponsePages().get(0).getDiv().asXml();
//    System.out.println("Response " + responseHtml);
    HtmlDivision div = server.getResponsePages().get(0).getDiv();
      List<?> list = div.getByXPath("div[1]/div[2]");
      final HtmlDivision buttonDiv = ((HtmlDivision)list.get(0));
      buttonDiv.mouseOver();
      buttonDiv.click();
      
      
      conni.setResponseInServer(server);
      HtmlDivision divAfter = server.getResponsePages().get(1).getDiv();
      System.out.println("The div returned after clicking " + divAfter.asXml());      
      
      //remove_p30049814
      ///html/body/div/div/div/div[2]/div/div[4]/div[2]/div[1]/div[2]
//      html body div#main_frame div#main div#all_panels_container div#private_container.panel-container div#private.panel.panel-default.list-view div.panel-body-wrapper div.panel-body.app-panel-body.ui-droppable div#p30049814.app.ui-draggable.ui-draggable-handle div#remove_p30049814.app-buttons.appdelete
    
    
    
    
//    assertThat(responseHtml, not(containsString("loading")));

  }

  
  
  
//Proves that appdesigner loads infinitely when user has only login right  "AD"
//Must run alone. Will be removed when AD has been fixed.
//@Ignore 
//@Test
//public void handleRequests_fileDataOneFileInfinitelyLoading_exceptionInServer() throws Exception {
//  List<Server> servers = createServerListFromFile();
//
//  handleRequestsForServers(servers);
//
//  exception.expect(java.lang.AssertionError.class);
//  exception.expectMessage("A Backgrund Script Is Reloading Infinitely");
//  servers.stream().forEach(e -> assertThat(e.getException(), equalTo("")));
//}
//
//@Test
//public void handleRequests_fileDataOneFileInfinitelyLoading_responseIsOK() throws Exception {
//  List<Server> servers = createServerListFromFile();
//  
//  handleRequestsForServers(servers);
//  
//  servers.stream().forEach(e -> assertThat(e.getResponseCode(), containsString("OK")));
//}


  
  
  
  
  @Test
  public void getPageByHtmlUnitLogin_jsPage_buttonIsClickable() {
    HttpUrlServerConnection conni = new HttpUrlServerConnection();
    // TODO Page Object for Server telling me what JS rendered element the
    // HttpUrlServerConnection should wait for
    
    
    conni.setResponseInServer(server);

    final String responseHtml = server.getResponseHtml();
    System.out.println("Response " + responseHtml);
    assertThat(responseHtml, not(containsString("loading")));

  }

}

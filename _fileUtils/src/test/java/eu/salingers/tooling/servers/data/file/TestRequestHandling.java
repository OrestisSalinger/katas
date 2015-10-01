package eu.salingers.tooling.servers.data.file;

import org.junit.Before;
import org.junit.Test;

import eu.salingers.tooling.servers.HttpUrlServerConnection;
import eu.salingers.tooling.servers.model.Server;

public class TestRequestHandling {
  public Server server;
  @Before
  public void getJSServerObject(){
     server = new Server("https://staging.identitycloud.ch/iddirect", "osaTestUserJule", "Test_123456", true);
  }

  
  
 @Test
 public void getPageByHtmlUnitLogin_jsPage_responseHasElements(){
   HttpUrlServerConnection conni = new HttpUrlServerConnection();
   //TODO Page Object for Server telling me what JS rendered element the HttpUrlServerConnection should wait for 
   
   
   conni.setResponseInServer(server);
   System.out.println("Response " + server.getResponseHtml());   
   
   
 }
}


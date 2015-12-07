package eu.salingers.tooling.servers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import eu.salingers.tooling.servers.model.pages.WorkView;
import eu.salingers.tooling.servers.model.servers.Server;

public class TestPageHandling {
  
  
  
  private Server server;
  private PageHandler ph = new PageHandler(); 
  
  @Before
  public void getJSServerObject(){
     server = new Server("https://staging.identitycloud.ch/iddirect", "osaTestUserJule", "Test_123456");
     server.setJavascriptEnabled(Boolean.TRUE);
     
  }

  
  
 @Test
 public void createWorkViews_jsPage_workViewsNotEmpty(){
     List<WorkView> views = ph.createWorkViews(server.getRequestPages());
     
     System.out.println("Server " + server.getRequestPages().size());
     assertThat(views, not(equalTo(null)));
     assertThat(views, not(equalTo(Collections.emptyList())));
   
 }
}

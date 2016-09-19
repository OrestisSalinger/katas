package eu.salingers.tooling.servers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

//import org.junit.experimental.theories.Theories;
//import org.junit.runner.RunWith;
//import static org.junit.Assert.*;
import org.junit.Test;

import eu.salingers.tooling.servers.model.servers.Server;

//@RunWith(Theories.class)
public class TestAllEnvironmentsResponseCode extends TestServers {

  @Test
  public void handleRequests_allEnvironmentsNoLogin_responseIs200OK() throws Exception {
   System.out.println("Using Test File: " + FILENAME_NO_CREDENTIALS);
    List<Server> servers = createServerListFromFile(FILENAME_NO_CREDENTIALS);

    handleRequestsForServers(servers);

    servers.stream().forEach(e -> assertThat(e.getResponseCode(), containsString("200 OK")));
  }

  @Test
  public void handleRequests_correctCredentialsForAllEnvironments_logInGrantedOnAllEnvironments() throws Exception {
    List<Server> servers = createServerListFromFile(FILENAME_CREDENTIALS);

    handleRequestsForServers(servers);

    //See that it I get a Login here
    servers.stream().forEach(e -> {
      final String responseHtml = e.getResponseHtml();
      //    System.out.println("Correct Login " + e.getPassword());
      System.out.println(e.getResponseHtml());
      System.out.println(e.getDoLogin());
      assertThat(responseHtml, containsString(PROOF_LOGGED_IN));
    });
  }
  
}
  
  
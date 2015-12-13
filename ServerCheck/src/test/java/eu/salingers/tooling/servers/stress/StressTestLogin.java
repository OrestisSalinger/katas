package eu.salingers.tooling.servers.stress;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import eu.salingers.tooling.servers.TestServers;
import eu.salingers.tooling.servers.model.servers.Server;

public class StressTestLogin extends TestServers {

  @Ignore
  @Test
  public void handleRequests_loginStress4Staging_logInGrantedOnAllLoginAttempts() throws Exception {
    List<Server> servers = createServerListFromFile(FILENAME_CREDENTIALS_STRESS_STAGING);

    handleRequestsForServers(servers);

    servers.stream().forEach(e -> {
      final String responseHtml = e.getResponseHtml();
//      System.out.println("Correct Login"+e.getUrl()+" \n" + e.getUsername() +":"+ e.getPassword());
      assertThat(responseHtml, containsString(PROOF_LOGGED_IN));
    });
  }


}

package eu.salingers.tooling.servers.brute;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

import eu.salingers.tooling.servers.TestServers;
import eu.salingers.tooling.servers.model.servers.Server;

public class TestBruteServers extends TestServers{

  @Test
  public void handleRequests_wrongCredentials_loginIsBlocked() throws Exception {
    final List<Server> servers = createServerListFromFile(FILENAME_CREDENTIALS_CAN_BE_BLOCKED);
    addWrongCharactersToPassword(servers);
    
    for (int i = 0; i <= NUMBER_OF_WRONG_CREDENTIAL_ATTEMPTS; i++) {
      tryLoginToServers(servers, i);
//        servers.stream().forEach(e -> assertThat(e.getResponseHtml(), containsString(PROOF_NOT_LOGGED_IN)));
    }
    List<String> errors = extractServerUrlsWithLoginSession(servers);    
    errors.stream().map(e -> "No brute force-protection(log-in emmidiately granted after " 
        + NUMBER_OF_WRONG_CREDENTIAL_ATTEMPTS 
        + " failed log-ins):\t" 
        + e).forEach(System.out::println);
    assertThat("Server vulnerability detected(No brute-force protection): ", errors, equalTo(Collections.emptyList()));

  }

}
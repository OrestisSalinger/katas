package eu.salingers.tooling.servers.data.file;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Rule;
//import org.junit.experimental.theories.Theories;
//import org.junit.runner.RunWith;
//import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.gargoylesoftware.htmlunit.util.NameValuePair;

import eu.salingers.tooling.servers.ServerListMapper;
import eu.salingers.tooling.servers.ServerRequestHandler;
import eu.salingers.tooling.servers.model.Server;

//@RunWith(Theories.class)
public class TestAllEnvironmentsResponseCode {
  private static final String PROOF_NOT_LOGGED_IN = "login.js";
  private static final int NUMBER_OF_WRONG_CREDENTIAL_ATTEMPTS = 3;
  private static final String WRONG_CHARACTER = "_";
  private static String WRONG_CHARACTERS = "";

  static {
    for (int i = 0; i < NUMBER_OF_WRONG_CREDENTIAL_ATTEMPTS; i++) {
      WRONG_CHARACTERS = new StringBuilder(WRONG_CHARACTERS).append(WRONG_CHARACTER).toString();
    }
  }

  @Rule
  public ExpectedException exception = ExpectedException.none();

  private static final String PATH = "src/test/resources/";
  private static final String FILENAME_TEST = "ConnectServers.csv";
  private static final String FILENAME_WC = "ConnectServersWrongCredentials.csv";

  @Test
  public void handleRequests_allEnvironments_responseIsOK() throws Exception {
    List<Server> servers = createServerListFromFile(FILENAME_WC);

    handleRequestsForServers(servers);

    servers.stream().forEach(e -> assertThat(e.getResponseCode(), containsString("OK")));
  }

  @Test
  public void handleRequests_wrongCredentials_loginIsBlocked() throws Exception {
    final List<Server> servers = createServerListFromFile(FILENAME_WC);
    addWrongCharactersToPassword(servers);
    
    for (int i = 0; i <= NUMBER_OF_WRONG_CREDENTIAL_ATTEMPTS; i++) {
      tryLoginToServers(servers, i);
      if (isNotLastIteration(i)) {
        // Except the last iteration no log-in must be granted because of wrong
        // credentials.
        servers.stream().forEach(e -> assertThat(e.getResponseHtml(), containsString(PROOF_NOT_LOGGED_IN)));
      }
    }
    // We're now collecting all servers that were logged-in from the last
    // round. This list must be empty.
    List<String> errors = extractServerUrlsWithLoginSession(servers);    
    errors.stream().map(e -> "No brute force-protection(log-in emmidiately granted after " 
        + NUMBER_OF_WRONG_CREDENTIAL_ATTEMPTS 
        + " failed log-ins):\t" 
        + e).forEach(System.out::println);
    // In the last iteration all usernames are correct but now the anti brute
    // force block should prevent from login
    assertThat("Server vulnerability detected(No brute-force protection): ", errors, equalTo(Collections.emptyList()));

  }

  private void tryLoginToServers(final List<Server> servers, int i) throws Exception {
    final int j = i;
    servers.stream().map(e -> {
      final List<NameValuePair> responseHeaders = e.getResponseHeaders();
      return j + " " + " " + e.getUrl() + e.getUsername() + " -> " + e.getPassword() +"\n" + responseHeaders + "\n" + e.getResponseHtml();
    }).forEach(System.out::println);
    handleRequestsForServers(servers);
    removeOneWrongCharacterFromPasswords(servers);
  }

  private List<String> extractServerUrlsWithLoginSession(final List<Server> servers) {
    final Stream<Server> serverWithErrors = servers.stream().filter(e -> !e.getResponseHtml().contains(PROOF_NOT_LOGGED_IN));
    return serverWithErrors.map(e -> e.getUrl()).collect(Collectors.toList());

  }

  private boolean isNotLastIteration(int i) {
    return i < WRONG_CHARACTERS.length();
  }

  private void removeOneWrongCharacterFromUserNames(final List<Server> servers) {
    servers.stream().forEach(e -> e.setUsername(e.getUsername().replaceFirst(WRONG_CHARACTER, "")));
  }
  
  private void removeOneWrongCharacterFromPasswords(final List<Server> servers) {
    servers.stream().forEach(e -> e.setPassword(e.getPassword().replaceFirst(WRONG_CHARACTER, "")));
  }
  private void addWrongCharactersToPassword(List<Server> servers) {
    servers.stream().forEach(e -> e.setPassword(e.getPassword() + WRONG_CHARACTERS));
  }

  private void addWrongCharactersToUsername(List<Server> servers) {
    servers.stream().forEach(e -> e.setUsername(e.getUsername() + WRONG_CHARACTERS));
  }
  
  private void handleRequestsForServers(List<Server> servers) throws Exception {
    ServerRequestHandler handler = new ServerRequestHandler(servers);
    handler.handleRequests();
  }

  @SuppressWarnings("unused")
  private List<Server> createServerListFromFile() {
    final List<String[]> readRecords = createCSVReader().readRecords();
    // readRecords.stream().map(e ->
    // Arrays.toString(e)).forEach(System.out::println);
    List<Server> servers = ServerListMapper.createList(readRecords);
    return servers;
  }

  private List<Server> createServerListFromFile(String file) {
    final List<String[]> readRecords = createCSVReader(file).readRecords();
    // readRecords.stream().map(e ->
    // Arrays.toString(e)).forEach(System.out::println);
    List<Server> servers = ServerListMapper.createList(readRecords);
    return servers;
  }

  private CSVReader createCSVReader() {
    try {
      return new CSVReader(createReader(PATH, FILENAME_TEST));
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  private CSVReader createCSVReader(String file) {
    try {
      return new CSVReader(createReader(PATH, file));
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  private Reader createReader(final String pathTo, final String filenameTest) throws IOException {
    return Files.newBufferedReader(Paths.get(pathTo, filenameTest), Charset.forName("UTF-8"));
  }

}

package eu.salingers.tooling.servers.data.file;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Rule;
import org.junit.rules.ExpectedException;

import com.gargoylesoftware.htmlunit.util.NameValuePair;

import eu.salingers.tooling.servers.ServerListMapper;
import eu.salingers.tooling.servers.ServerRequestHandler;
import eu.salingers.tooling.servers.model.servers.Server;
import eu.salingers.tooling.servers.model.servers.Servers;

public class TestServers {

  protected static final String PROOF_NOT_LOGGED_IN = "login.js";
  protected static final String WRONG_CHARACTER = "_";
  protected static final int NUMBER_OF_WRONG_CREDENTIAL_ATTEMPTS = 10;
  protected static final String PATH = "src/test/resources/";
  protected static final String FILENAME_NO_CREDENTIALS = "test_sample.csv";
  protected static final String FILENAME_CREDENTIALS = "ConnectServersCredentials.csv";
  protected static final String FILENAME_CREDENTIALS_STRESS_STAGING = "ConnectServersCredentialsStressStaging.csv";
  protected static final String FILENAME_CREDENTIALS_CAN_BE_BLOCKED = "ConnectServersCredentialsCanBeBlocked.csv";
  
  protected static final String PROOF_LOGGED_IN = "Logout";
  protected static String WRONG_CHARACTERS = "";
  @Rule
  public ExpectedException exception = ExpectedException.none();
  static {
    for (int i = 0; i < NUMBER_OF_WRONG_CREDENTIAL_ATTEMPTS; i++) {
      WRONG_CHARACTERS = new StringBuilder(WRONG_CHARACTERS).append(WRONG_CHARACTER).toString();
    }
  }

  public TestServers() {
    super();
  }

  protected void tryLoginToServers(final List<Server> servers, int i) throws Exception {
    final int j = i;
    servers.stream().map(e -> {
      final List<NameValuePair> responseHeaders = e.getResponseHeaders();
      return j + " " + " " + e.getUrl() + e.getUsername() + " -> " + e.getPassword() +"\n" + responseHeaders + "\n" + e.getResponseHtml();
    }).forEach(System.out::println);
    handleRequestsForServers(servers);
    removeOneWrongCharacterFromPasswords(servers);
  }

  protected List<String> extractServerUrlsWithLoginSession(final List<Server> servers) {
    final Stream<Server> serverWithErrors = servers.stream().filter(e -> !e.getResponseHtml().contains(PROOF_NOT_LOGGED_IN));
    return serverWithErrors.map(e -> e.getUrl()).collect(Collectors.toList());
  
  }

  private void removeOneWrongCharacterFromPasswords(final List<Server> servers) {
    servers.stream().forEach(e -> {
      final String replaceFirst = e.getPassword().replaceFirst(WRONG_CHARACTER, "");
      System.out.println("Replacing: " + e.getPassword() + " with " + replaceFirst);
      e.setPassword(replaceFirst);
    });
  }

  protected void addWrongCharactersToPassword(List<Server> servers) {
    servers.stream().forEach(e -> e.setPassword(e.getPassword() + WRONG_CHARACTERS));
  }

  protected void handleRequestsForServers(List<Server> servers) throws Exception {
    new ServerRequestHandler(servers).handleRequests();
  }

  protected List<Server> createServerListFromFile(String file) {
    final CSVReader csvReader = createCSVReader(file);
    final List<String> header = csvReader.readHeader();
    final List<String[]> readRecords = csvReader.readRecords();
    readRecords.stream().map(e -> Arrays.toString(e)).forEach(System.out::println);
    return ServerListMapper.createList(new Servers(header, readRecords));
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
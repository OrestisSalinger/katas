package eu.salingers.tooling.servers.data.file;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
//import org.junit.experimental.theories.Theories;
//import org.junit.runner.RunWith;
//import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import eu.salingers.tooling.servers.ServerListMapper;
import eu.salingers.tooling.servers.ServerRequestHandler;
import eu.salingers.tooling.servers.model.servers.Server;

//@RunWith(Theories.class)
public class TestCSVHandling {
  @Rule 
  public ExpectedException exception = ExpectedException.none();

  private static final String FILENAME_SRC = "sample3.csv";
  private static final String FILENAME_TEST = "test_sample.csv";

  private static final String PATH = "src/test/resources/";

  private static final String HEADER = "url;username;password;js_enabled";
  private static final String ENTRY_RIGHT_AD_ONLY = "https://staging.identitycloud.ch/appdesigner/,automatedTestUser1443181506566,@ut0mAT22$,true;";
  private static final String ENTRY_RIGHTS_ALL = "https://staging.identitycloud.ch/appdesigner/,osaTestUserJule,Test_123456,false;";

  @Before
  public void prepareCSVFile() throws IOException {
    CSVWriter writer = new CSVWriter();
    writer.copyOverride(PATH + FILENAME_SRC, PATH + FILENAME_TEST);
  }

  @Test
  public void readsHeader() {
    CSVReader csvReader = createCSVReader();
    List<String> header = csvReader.readHeader();
    assertThat(header.toArray(), equalTo(HEADER.split(";")));
  }

  @Test
  public void readsRecords() {
    CSVReader csvReader = createCSVReader();
    List<String[]> records = csvReader.readRecords();
//    assertThat(records.size(), equalTo(2));
    assertThat(records.get(0)[0], equalTo(ENTRY_RIGHT_AD_ONLY.replace(";", "")));
    assertThat(records.get(1)[0], equalTo(ENTRY_RIGHTS_ALL.replace(";", "")));
  }

  @Test
  public void appendLineToFile() throws IOException {
    final long sizeBefore = createCSVReader().readRecords().size();
    
    new CSVWriter().appendLineToFile(ENTRY_RIGHTS_ALL, Paths.get(PATH, FILENAME_TEST).toString());
    
    assertThat((long) createCSVReader().readRecords().size(), equalTo(sizeBefore + 1l));
  }
//  Proves that appdesigner loads infinitely when user has only login right  "AD"
//  Must run alone. Will be removed when AD has been fixed.
  @Ignore 
  @Test
  public void handleRequests_fileDataOneFileInfinitelyLoading_exceptionInServer() throws Exception {
    List<Server> servers = createServerListFromFile();

    handleRequestsForServers(servers);

    exception.expect(java.lang.AssertionError.class);
    exception.expectMessage("A Backgrund Script Is Reloading Infinitely");
    servers.stream().forEach(e -> assertThat(e.getException(), equalTo("")));
  }

  @Test
  public void handleRequests_fileDataOneFileInfinitelyLoading_responseIsOK() throws Exception {
    List<Server> servers = createServerListFromFile();
    
    handleRequestsForServers(servers);
    
    servers.stream().forEach(e -> assertThat(e.getResponseCode(), containsString("OK")));
  }

  
  private void handleRequestsForServers(List<Server> servers) throws Exception {
    new ServerRequestHandler(servers).handleRequests();
  }

  private List<Server> createServerListFromFile() {
    final List<String[]> readRecords = createCSVReader().readRecords();
//    readRecords.stream().map(e -> Arrays.toString(e)).forEach(System.out::println);
    List<Server> servers = ServerListMapper.createList(readRecords);
    return servers;
  }

  private CSVReader createCSVReader() {
    try {
      Path path = Paths.get(PATH, FILENAME_TEST);
      Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
      return new CSVReader(reader);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

}

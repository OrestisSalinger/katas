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
//import org.junit.experimental.theories.Theories;
//import org.junit.runner.RunWith;
//import static org.junit.Assert.*;
import org.junit.Test;

import eu.salingers.tooling.servers.ServerListMapper;
import eu.salingers.tooling.servers.ServerRequestHandler;
import eu.salingers.tooling.servers.TestServers;
import eu.salingers.tooling.servers.model.servers.Server;
import eu.salingers.tooling.servers.model.servers.Servers;

//@RunWith(Theories.class)
public class TestCSVHandling extends TestServers {
  private static final String FILENAME_SRC = "ConnectServersCredentialsDoNotPush.csv";
  private static final String FILENAME_TEST = "test_sample.csv";

  private static final String HEADER = "url;notifier;javascriptEnabled;username;password";
  private static final String ENTRY_RIGHT_AD_ONLY = "https://staging.identitycloud.ch/appdesigner/,email,false,osaTestUserJule,Test_123456;";
  private static final String ENTRY_RIGHTS_ALL = "https://staging.identitycloud.ch/controlcenter/,email,false,osaTestUserJule,Test_123456;";

  private CSVReader csvReader;

    

  @Before
  public void prepareCSVFile() throws IOException {
    CSVWriter writer = new CSVWriter();
    writer.copyOverride(PATH + FILENAME_SRC, PATH + FILENAME_TEST);
    csvReader = createCSVReader();
  }

  @Test
  public void readsHeader() {
    List<String> header = csvReader.readHeader();
    assertThat(header.toArray(), equalTo(HEADER.split(";")));
  }

  @Test
  public void readsRecords() {
    List<String[]> records = csvReader.readRecords();
    assertThat(records.get(0)[0], equalTo(ENTRY_RIGHT_AD_ONLY.replace(";", "")));
    assertThat(records.get(1)[0], equalTo(ENTRY_RIGHTS_ALL.replace(";", "")));
  }

  @Test
  public void readsHeaderAndsRecords() {
    List<String> header = csvReader.readHeader();
    List<String[]> records = csvReader.readRecords();
    assertThat(header.toArray(), equalTo(HEADER.split(";")));
    assertThat(records.get(0)[0], equalTo(ENTRY_RIGHT_AD_ONLY.replace(";", "")));
    assertThat(records.get(1)[0], equalTo(ENTRY_RIGHTS_ALL.replace(";", "")));
  }

  @Test
  public void appendLineToFile() throws IOException {
    final long sizeBefore = createCSVReader().readRecords().size();
    
    new CSVWriter().appendLineToFile(ENTRY_RIGHTS_ALL, Paths.get(PATH, FILENAME_TEST).toString());
    
    assertThat((long) createCSVReader().readRecords().size(), equalTo(sizeBefore + 1l));
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

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
public class TestReadHtmlPageData {
  @Rule 
  public ExpectedException exception = ExpectedException.none();

  private static final String FILENAME_CUSTOMER_PAGE_ELEMENTS = "customer01_page_elements.html";
  private static final String FILENAME_CUSTOMER_PAGE_ELEMENTS_COPY = "customer01_page_elements_temp.html";

  private static final String PATH = "src/test/resources/";
  
  private static final String ENTRY_RIGHT_AD_ONLY = "";
  private static final String ENTRY_RIGHTS_ALL = "https://staging.identitycloud.ch/appdesigner/,osaTestUserJule,Test_123456,false;";

 

  @Test
  public void parseHTML() {
//    HtmlReader htmlReader = createHtmlReader();

  }

  @Test
  public void readHtmlPages() {
    HtmlReader htmlReader = createHtmlReader();
    
    List<String[]> pages = htmlReader.readPages();

    
    assertThat(pages.get(0)[0], equalTo(ENTRY_RIGHT_AD_ONLY.replace(";", "")));
    assertThat(pages.get(1)[0], equalTo(ENTRY_RIGHTS_ALL.replace(";", "")));
  }

//  @Test
//  public void appendLineToFile() throws IOException {
//    final long sizeBefore = createCSVReader().readRecords().size();
//    
//    new CSVWriter().appendLineToFile(ENTRY_RIGHTS_ALL, Paths.get(PATH, FILENAME_TEST).toString());
//    
//    assertThat((long) createCSVReader().readRecords().size(), equalTo(sizeBefore + 1l));
//  }
////  Proves that appdesigner loads infinitely when user has only login right  "AD"
////  Must run alone. Will be removed when AD has been fixed.
//  @Ignore 
//  @Test
//  public void handleRequests_fileDataOneFileInfinitelyLoading_exceptionInServer() throws Exception {
//    List<Server> servers = createServerListFromFile();
//
//    handleRequestsForServers(servers);
//
//    exception.expect(java.lang.AssertionError.class);
//    exception.expectMessage("A Backgrund Script Is Reloading Infinitely");
//    servers.stream().forEach(e -> assertThat(e.getException(), equalTo("")));
//  }

//  @Test
//  public void handleRequests_fileDataOneFileInfinitelyLoading_responseIsOK() throws Exception {
//    List<Server> servers = createServerListFromFile();
//    
//    handleRequestsForServers(servers);
//    
//    servers.stream().forEach(e -> assertThat(e.getResponseCode(), containsString("OK")));
//  }

  
  private void handleRequestsForServers(List<Server> servers) throws Exception {
    new ServerRequestHandler(servers).handleRequests();
  }

  private List<Server> createServerListFromFile() {
    final List<String[]> readPages = createHtmlReader().readPages();
//    readRecords.stream().map(e -> Arrays.toString(e)).forEach(System.out::println);
    List<Server> servers = ServerListMapper.createList(readPages);
    return servers;
  }

  private HtmlReader createHtmlReader() {
    try {
      Path path = Paths.get(PATH, FILENAME_CUSTOMER_PAGE_ELEMENTS);
      Reader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
      return new HtmlReader(reader);
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

}

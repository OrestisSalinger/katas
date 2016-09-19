package eu.salingers.servers;

import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Timer;

import eu.salingers.tooling.servers.ServerListMapper;
import eu.salingers.tooling.servers.data.file.CSVReader;
import eu.salingers.tooling.servers.model.servers.Server;

public class CheckServers {
  private static final String FILENAME_TEST = "servers.csv";

  private static final String PATH = "src/main/resources/";

  private static Timer timer = new Timer();

  public static void main(String[] args) throws Exception {

    List<Server> servers = createServerListFromFile(FILENAME_TEST);

    timer.schedule (new CheckServerTask(servers),0,1000*60);

  }

  private static List<Server> createServerListFromFile(String file) {
    final List<String[]> readRecords = createCSVReader(file).readRecords();
    // readRecords.stream().map(e -> Arrays.toString(e)).forEach(System.out::println);
    List<Server> servers = ServerListMapper.createList(readRecords);
    return servers;
  }

  private static CSVReader createCSVReader(String file) {
    try {
      return new CSVReader(createReader(PATH, file));
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  private static Reader createReader(final String pathTo, final String filenameTest) throws IOException {
    return Files.newBufferedReader(Paths.get(pathTo, filenameTest), Charset.forName("UTF-8"));
  }

}

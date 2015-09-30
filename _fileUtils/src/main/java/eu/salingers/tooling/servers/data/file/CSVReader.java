package eu.salingers.tooling.servers.data.file;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader {
  private static final String LINE_SEPARATOR = ";";
  
  private Reader source;

  public CSVReader(Reader source) {
    this.source = source;
  }

  List<String> readHeader() {
    try (BufferedReader reader = new BufferedReader(source)) {
      return reader.lines().findFirst().map(line -> Arrays.asList(line.split(LINE_SEPARATOR))).get();
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  public List<String[]> readRecords() {
    try (BufferedReader reader = new BufferedReader(source)) {
      return reader.lines()
          .skip(1)
          .map(line -> line.split(LINE_SEPARATOR)).collect(Collectors.toList());
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  
  
  
  
}

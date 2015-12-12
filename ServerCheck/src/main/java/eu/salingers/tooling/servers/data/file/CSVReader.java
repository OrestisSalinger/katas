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
  
  private CSVFile file;

  public CSVReader(Reader source) {
    try (BufferedReader reader = new BufferedReader(source)) {
//      NOTE: readHeader(reader) must be called first!!!
      file = new CSVFile(readHeader(reader), readRecords(reader));
    } catch (IOException e) {
      e.printStackTrace();
      throw new UncheckedIOException(e);
    }
    
  }

  
  
  private List<String> readHeader(BufferedReader reader) {
        final List<String> list = reader.lines().findFirst().map(line -> Arrays.asList(line.split(LINE_SEPARATOR))).get();
        return list;
  }

  private List<String[]> readRecords(BufferedReader reader) {
        final List<String[]> collect = reader.lines()
            .map(line -> line.split(LINE_SEPARATOR)).collect(Collectors.toList());
    collect.stream().map(e ->Arrays.toString(e)).forEach(System.out::println);
        return collect;
  }

  public List<String> readHeader() {
    return file.getHeader();
  }

  
  public List<String[]> readRecords() {
    return file.getRecords();
  }

  public List<String> readHeaderAndRecords() {
    // TODO Auto-generated method stub
    return null;
  }

  
  
  
  
}

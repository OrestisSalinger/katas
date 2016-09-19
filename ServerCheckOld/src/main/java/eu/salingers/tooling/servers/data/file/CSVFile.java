package eu.salingers.tooling.servers.data.file;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVFile {

  private List<String> header = Collections.emptyList();
  private List<String[]> records = Collections.emptyList();


  /**
   * @param header
   * @param records
   */
  public CSVFile(final List<String> header, final List<String[]> records) {
    this.header = header;
    this.records = records;
  }
  
  public List<String> getHeader() {
    final ArrayList<String> copy = new ArrayList<>();
    copy.addAll(header);
    return copy;
  }
  
  public List<String[]> getRecords() {
    final ArrayList<String[]> copy = new ArrayList<>();
    copy.addAll(records);
    return copy;
  }
  
}

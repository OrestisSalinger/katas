package eu.salingers.tooling.servers.model.servers;

import java.util.List;

public class Servers {

  private List<String[]> servers;
  private List<String> header;
  
  /**
   * @param readRecords
   * @param header
   */
  public Servers(List<String> header, List<String[]> readRecords) {
    this.servers = readRecords;
    this.header = header;
  }

  public List<String> getHeader() {
    return header;
  }

  public List<String[]> getServers() {
    return servers;
  }  
  
}

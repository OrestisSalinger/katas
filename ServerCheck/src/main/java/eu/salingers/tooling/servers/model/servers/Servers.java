package eu.salingers.tooling.servers.model.servers;

import java.util.List;

public class Servers {

  private List<String[]> servers;
  private List<String> header;
  
  /**
   * @param servers
   * @param header TODO: rename because it should not know the csv-file header here.It's just meta data.
   */
  public Servers(List<String> header, List<String[]> servers) {
    this.servers = servers;
    this.header = header;
  }

  public List<String> getHeader() {
    return header;
  }

  public List<String[]> getServers() {
    return servers;
  }  
  
}

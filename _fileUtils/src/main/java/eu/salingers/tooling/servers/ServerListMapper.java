package eu.salingers.tooling.servers;

import java.util.ArrayList;
import java.util.List;

import eu.salingers.tooling.servers.model.Server;



/**
 * Class responsible for mapping a <code>List<String[]></code>
 * to a <code>List<Servers></code> 
 * 
 * @author orestis@salingers.eu
 *
 */
public class ServerListMapper {
  /**
   * @param rawList
   * @return List of server objects.
   */
  public static final List<Server> createList(List<String[]> rawList){
    List<Server> servers = new ArrayList<>();
    for (int i = 0; i < rawList.size(); i++) {
      String[] array = rawList.get(i)[0].split(",");
      final Server server = new Server(array[0], array[1], array[2], array[3].contains("true") ? true : false);
      servers.add(server);
    }
    return servers;
  }
}

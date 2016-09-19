package eu.salingers.tooling.servers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import eu.salingers.tooling.servers.model.servers.Server;
import eu.salingers.tooling.servers.model.servers.Servers;
import eu.salingers.tooling.servers.notify.EmailNotifier;
import eu.salingers.tooling.servers.notify.Notifier;

/**
 * Class responsible for mapping a <code>List<String[]></code> to a <code>List<Servers></code>
 * 
 * @author orestis@salingers.eu
 *
 */
public class ServerListMapper {
  /**
   * @param rawList
   * @return List of server objects.
   */
  public static final List<Server> createList(List<String[]> rawList) {
    List<Server> servers = new ArrayList<>();//.emptyList();
    for (int i = 0; i < rawList.size(); i++) {
      servers.add(extractServer(rawList,i));
    }
    return servers;
  }

  /**
   * @param rawList
   * @return List of server objects.
   */
  public static final List<Server> createList(final Servers servers) {
    List<String> header = servers.getHeader();
    if (servers.getHeader().get(0) == null) {
      throw new IllegalArgumentException("Field description \"URL\" must not be null.");
    } else if (header.get(1) == null) {
      throw new IllegalArgumentException("Field description \"JavascriptEnabled\" must not be null.");
    }
    System.out.println("Header: " + Arrays.toString(header.toArray()));
    return extractServerList(servers);
  }

  private static List<Server> extractServerList(final Servers servers) {
    List<Server> serverList = new ArrayList<>();
    final List<String[]> serversRaw = servers.getServers();

    for (int i = 0; i < serversRaw.size(); i++) {
      serverList.add(extractServer(serversRaw, i));
    }
    return serverList;
  }

  private static Server extractServer(final List<String[]> serversRaw, int i) {
    String[] serverArray = serversRaw.get(i)[0].split(",");
//    if (serverArray.length != serversRaw.size()) {
//      throw new IllegalArgumentException(
//          "Fields described in header are unequal actual fields in record:\n" + Arrays.toString(serverArray));
//    }
    // TODO get data structure from file header
    final String url = serverArray[0];
    final Notifier notifier = serverArray[1].equals("email") ? new EmailNotifier() : null;
    final boolean isJavascriptEnabled = serverArray[2].equals("true");
    final String username = serverArray[3];
    final String password = serverArray[4];
    final Server server = new Server(url, notifier, isJavascriptEnabled, username, password);
    return server;
  }

}

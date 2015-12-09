package eu.salingers.tooling.servers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import eu.salingers.tooling.servers.model.servers.Server;

public class ServerRequestHandler {
  List<Server> servers;
  
  /**
   * @param requests
   */
  public ServerRequestHandler(List<Server> servers) {
    this.servers = servers;
  }

  public List<Server> handleRequests(){
    HttpUrlServerConnection connection = new HttpUrlServerConnection();
    ExecutorService executor = Executors.newWorkStealingPool();
    List<Callable<Server>> callables = createCalls(connection);
    try {
      executor.invokeAll(callables)
      .stream()
      .map(future -> {
          try {
              return future.get();
          }
          catch (Exception e) {
              throw new IllegalStateException(e);
          }
      });
    } catch (InterruptedException e) {
      // Intentionally swallowed.
      e.printStackTrace();
    }finally{
      executor.shutdown();
    }
    return servers;
  }

  private List<Callable<Server>> createCalls(HttpUrlServerConnection connection) {
    List<Callable<Server>> callables = new ArrayList<>();
    for (int i = 0; i < servers.size(); i++) {
      final int j = i;
      callables.add(() -> connection.setResponseInServer(servers.get(j)));
    }
    return callables;
  }
}
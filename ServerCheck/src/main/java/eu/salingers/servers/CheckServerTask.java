package eu.salingers.servers;

import java.util.List;
import java.util.TimerTask;

import eu.salingers.tooling.servers.ServerRequestHandler;
import eu.salingers.tooling.servers.model.servers.Server;
import eu.salingers.tooling.servers.notify.Emailer;

class CheckServerTask extends TimerTask {
  private List<Server> servers;

  public CheckServerTask(List<Server> servers) {
    this.servers = servers;
  }




  public void run() {
    System.out.println("hello Server Check");
     runServerChecks();
  }  
  
  
  
  private void runServerChecks() {
    handleRequestsForServers(servers);
    servers.stream().forEach(e -> validateResponseCode(e));
  }

  private boolean validateResponseCode(Server e) {
    final String responseCode = e.getResponseCode();
    System.out.println("ResponseCode for " + e.getUrl() + ": " + responseCode);
    if (!responseCode.contains("200 OK")) {
      StringBuilder msg = new StringBuilder(e.getUrl()).append(" Status ").append(responseCode);
      Emailer.sendEmail("orestis.salinger@icloud.com", msg.toString(),
          msg.toString(), "orestis.eu@googlemail.com",
          "orestis.eu@googlemail.com", "h4Tr3?lq_4gZ2a");
    }
    return responseCode.contains("200 OK");
  }

  private void handleRequestsForServers(List<Server> servers) {
    ServerRequestHandler handler = new ServerRequestHandler(servers);
    handler.handleRequests();
  }

  
  
}
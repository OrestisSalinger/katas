package eu.salingers.tooling.servers.data.file;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import eu.salingers.tooling.servers.ServerListMapper;
import eu.salingers.tooling.servers.model.servers.Server;

public class TestServerMapping extends TestServers {
  private final String[] ARRAY1 = {"https://staging.identitycloud.ch/controlcenter, email, false, test123 ,Test_123456"}; 
  private final String[] ARRAY2 = {"https://staging.identitycloud.ch/appdesigner,email,true,test123,Test_123456"};
  private final String[] ARRAY3 = {"https://staging.identitycloud.ch/iddirect, email, false, test123,Test_123456"};

  @Test
  public void mapArraysToServerList_ServerListSizeEqualsNumberOfArrays() {
    List<String[]> rawList = new ArrayList<>();
    rawList.add(ARRAY1);
    rawList.add(ARRAY2);    
    rawList.add(ARRAY3);    
    List<Server> servers = ServerListMapper.createList(rawList);
    assertThat(servers.size(), is(equalTo(rawList.size())));
  }
  
  @Test
  public void mapArraysToServerList_ServerValuesEqualsArrays() {
    List<String[]> rawList = new ArrayList<>();
    rawList.add(ARRAY1);
    rawList.add(ARRAY2);
    rawList.add(ARRAY3);    

    List<Server> servers = ServerListMapper.createList(rawList);
    for (int i = 0; i < servers.size(); i++) {
      System.out.println(servers.get(i));
      final String[] split = rawList.get(i)[0].split(",");
      assertThat(servers.get(i).getUrl(), is(equalTo(split[0])));
      assertThat(servers.get(i).getUsername(), is(equalTo(split[3])));
      assertThat(servers.get(i).getPassword(), is(equalTo(split[4])));
      assertThat(Boolean.toString(servers.get(i).isJavascriptEnabled()), is(equalTo(split[2].trim())));
    }
      
  }
}

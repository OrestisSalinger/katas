package eu.salingers.tooling.servers.data.file;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import eu.salingers.tooling.servers.ServerListMapper;
import eu.salingers.tooling.servers.model.servers.Server;

public class TestServerMapping {
  private final String[] ARRAY1 = {"https://staging.identitycloud.ch/controlcenter, test123 ,Test_123456,false"}; 
  private final String[] ARRAY2 = {"https://staging.identitycloud.ch/appdesigner,test123,Test_123456,true"};
  private final String[] ARRAY3 = {"https://staging.identitycloud.ch/iddirect,test123,Test_123456,false"};

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
      assertThat(servers.get(i).getUrl(), is(equalTo(rawList.get(i)[0].split(",")[0])));
      assertThat(servers.get(i).getUsername(), is(equalTo(rawList.get(i)[0].split(",")[1])));
      assertThat(servers.get(i).getPassword(), is(equalTo(rawList.get(i)[0].split(",")[2])));
      assertThat(servers.get(i).isJavascriptEnabled()+"", is(equalTo(rawList.get(i)[0].split(",")[3])));
    }
      
  }
}

package eu.salingers.tooling.team;

import java.util.ArrayList;
import java.util.List;

public final class ConnectTeam implements Team {

  private List<Member> members = new ArrayList<>();

  @Override
  public void addMember(Member member) {
    this.members.add(member);
    
  }

  public void addMembers(List<Member> members) {
    this.members.addAll(members);
    
  }
  
  List<Member> getTeamList(){
    return members;
  }
  

  Member getMemberByName(Team team,String name, Conversion function){
    return function.getByName(team, name);
  }


  public List<Member> getMembersByCompany(String company) {
    List<Member> companyMembers = new ArrayList<>();
    for (Member member : members){
      if (member.getCompany().equals(company)){
        companyMembers.add(member);
      }
      
    }
    return companyMembers;
  }
}

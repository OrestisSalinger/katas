package eu.salingers.tooling.team;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestWhoIsUmme {

  private static final String COMPANY = "Dev Bude";















  @Test
  public void addingMember_oneMemberInTeam_memberReturnedIsTheSame() {
    final Member memberExpected = new Member("LN","FN",COMPANY,TeamRole.Developer);
    Team connect = addMemberToTeam(new ConnectTeam(), memberExpected);

    eu.salingers.tooling.team.WhoIsUmme umme = new WhoIsUmme(connect);
    final ConnectTeam teamExtracted = (ConnectTeam) umme.getTeam();
//    final Member memberActual = teamExtracted.getMemberByName(memberExpected.getFirstName(),memberExpected.getLastName());
    
    System.out.println(memberExpected);
//    System.out.println(memberActual);
    
//    assertEquals(memberExpected, memberActual);
  }

  @Test
  public void addingMember_twoMemberInTeam_memberReturnedIsTheSame() {
    final Member memberExpected = new Member("LN","FN",COMPANY,TeamRole.Developer);
    final Member memberNotExpected = new Member("LN1","FN1",COMPANY,TeamRole.Developer);

    Team connect = addMemberToTeam(new ConnectTeam(), memberExpected);
    connect.addMember(memberNotExpected);
    eu.salingers.tooling.team.WhoIsUmme umme = new WhoIsUmme(connect);
    final ConnectTeam teamExtracted = (ConnectTeam) umme.getTeam();
//    final Member memberActual = teamExtracted.getMemberByName(memberExpected.getLastName());
    
    System.out.println(memberExpected);
//    System.out.println(memberActual);
//    
//    assertEquals(memberExpected, memberActual);
  }

 
  
  @Test
  public void getAllMembersOfCompany_twoCompanyMemberInTeam_membersReturnedAreTheSameCompany() {
    final Member memberExpected1 = new Member("LN","FN",COMPANY,TeamRole.Developer);
    final Member memberExpected2 = new Member("LN1","FN1",COMPANY,TeamRole.Developer);
    final Member memberNotExpected = new Member("LN3","FN3","Dev Bude2",TeamRole.Developer);
    
    
    List<Member> list = new ArrayList<Member>() {
      private static final long serialVersionUID = 1L;
      {
         add(memberExpected1);
         add(memberExpected2);
         add(memberNotExpected);

      }
     };
     
     ConnectTeam connect = new ConnectTeam();
//     String::contains;
//     ()->String.valueOf(x);
     
    
     
     
     
     connect.addMembers(list);
    
    eu.salingers.tooling.team.WhoIsUmme umme = new WhoIsUmme(connect);
    
    final ConnectTeam teamExtracted = (ConnectTeam) umme.getTeam();
    
    final List<Member> companyMembers = teamExtracted.getMembersByCompany(COMPANY);
    
    
    
    System.out.println("Company Meambers: "+ Arrays.toString(companyMembers.toArray()));
    System.out.println("All Members:      "+ Arrays.toString(list.toArray()));
    
//    assertEquals(memberExpected, memberActual);
  }


  @Test
  public void lambdaTest() {
   lambdaSort();
  }






  private Team addMemberToTeam(Team team, Member member) {
    team.addMember(member);
    return team;
  }

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  private void lambdaSort() {
    Integer[] numbers = {6, 5, 10, 7, 1, 9, 4, 8, 3, 2};
    
//    List<Integer> numbers2 = Collections.unmodifiableList(Arrays.asList(numbers)); //not safe

   List<Integer> numbers2 = new ArrayList<>();
   numbers2.addAll(Arrays.asList(numbers)); // more safe

    System.out.println("Array 1 " + Arrays.toString(numbers));
    System.out.println("Array 2 " + Arrays.toString(numbers2.toArray()));
//    Arrays.sort(numbers, new Comparator<Integer>() {
//
//      @Override
//      public int compare(Integer o1, Integer o2) {
//        return o1.compareTo(o2);
//      }
//
//    });
    
    //Comparator<Integer> ascending  = (first,second)->first.compareTo(second);
//    Arrays.sort(numbers,ascending);

    Comparator<Integer> descending  = (first,second)->second.compareTo(first);
    Arrays.sort(numbers,descending);

    
//    numbers2.sort(new Comparator<Integer>() {
//
//      @Override
//      public int compare(Integer o1, Integer o2) {
//        return o1.compareTo(o2);
//      }
//    });
    
    System.out.println("Array 1 " + Arrays.toString(numbers));
    System.out.println("Array 2 " + Arrays.toString(numbers2.toArray()));
  }

}

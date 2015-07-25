package eu.salingers.examples.PrimitiveArray;

import org.testng.annotations.Test;

public class TestArrays {

  
  @Test(invocationCount = 1)
  public void f() {
    final int limit = 1000000;
    int[] ints =  new int[1000000];
  
    
    for (int i = 0; i < limit; i++) {
      ints[i] = i;
    }
    
    for (int j = 0; j < limit; j++) {
      if(j==89886)  j--;
      if(j!=ints[j]){
        
        System.out.println("Not in order : " + j + " in array: " + ints[j]);
        throw new RuntimeException();
      }
    }
    
    
  }
}

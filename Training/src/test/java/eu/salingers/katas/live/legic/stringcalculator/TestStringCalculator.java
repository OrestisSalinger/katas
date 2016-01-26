package eu.salingers.katas.live.legic.stringcalculator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringCalculator {

  private StringCalculator stringCalculator() {
    final StringCalculator stringCalculator = new StringCalculator();
//  complex stuff here...
//    if(true) throw new IllegalArgumentException("tricked");
    return stringCalculator;
  }

  private void assertAdding(String numbers, int expected) {
    StringCalculator sc = stringCalculator();
    int actual = sc.add(numbers);
    assertEquals(expected, actual);
  }
    
  
  @Test(expected = IllegalArgumentException.class)
  public void add_negativeNumber_throwsException() {
    
    final StringCalculator stringCalculator = stringCalculator();
    
    stringCalculator.add("-1");
    
  }

  @Test
  public void add_multipleNumbers_returnsSum() {
    assertAdding("1,2", 3);
  }

  @Test
	public void add_singleNumber_returnsThatNumber() {
		assertAdding("1", 1);
	}


}

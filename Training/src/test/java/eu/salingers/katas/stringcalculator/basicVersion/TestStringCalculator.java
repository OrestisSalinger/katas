package eu.salingers.katas.stringcalculator.basicVersion;

import static org.junit.Assert.*;

import org.junit.Test;

import eu.salingers.katas.stringcalculator.basicVersion.StringCalculator;

public class TestStringCalculator {

  private StringCalculator calculate() {
    return new StringCalculator();
  }

  private void assertAdding(String numbers, int expected) {
    StringCalculator sc = calculate();
    int actual = sc.add(numbers);
    assertEquals(expected, actual);
  }
    
  
  @Test(expected = IllegalArgumentException.class)
  public void add_negativeNumber_throwsException() {
    calculate().add("-1");
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

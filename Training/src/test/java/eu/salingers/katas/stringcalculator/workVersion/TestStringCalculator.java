package eu.salingers.katas.stringcalculator.workVersion;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestStringCalculator {

  @Rule
  public ExpectedException expectedException = ExpectedException.none(); 
  
  private StringCalculator calculate() {
    return new StringCalculator();
  }

  private void assertAdding(String numbers, int expected) {
    int actual = calculate().add(numbers);
    assertEquals(expected, actual);
  }
    
  @Test
  public void parse_emptyString_returnsZero() {
    final StringCalculator sc = calculate();
    final String numbers = "";
    int actual = sc.parse(numbers);
    assertEquals(0, actual);
  }
  
  @Test
  public void parse_singleNumber_returnsThatNumber() {
    final StringCalculator sc = calculate();
    final String numbers = "1";
    int actual = sc.parse(numbers);
    assertEquals(1, actual);
  }

  @Test
  public void parse_singleNumber2_returnsThatNumber2() {
    final StringCalculator sc = calculate();
    final String numbers = "2";
    int actual = sc.parse(numbers);
    assertEquals(2, actual);
  }

  
  @Test(expected = IllegalArgumentException.class)
  public void add_negativeNumber_throwsExceptionSOBAD() {
    calculate().add("-1");
  }

  @Test
  public void add_negativeNumber_throwsExceptionGOOD() {
    try {
      calculate().add("-1");
    } catch (Exception e) {
      return;
    }
  assertTrue(false);
  
  }
 
  @Test
  public void add_negativeNumber_throwsExceptionBETTER() {
    final String numbers = "-1";
    expectedException.expect(IllegalArgumentException.class);    
    calculate().add(numbers);
  }

  @Test
  public void add_negativeNumber_throwsExceptionWithMessage() {
    final String numbers = "-1";
    expectedException.expect(IllegalArgumentException.class);    
    expectedException.expectMessage("Negative values are not allowed");    
    calculate().add(numbers);
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

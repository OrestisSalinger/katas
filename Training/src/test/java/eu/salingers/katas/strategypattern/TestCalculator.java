package eu.salingers.katas.strategypattern;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
/**
 * The Class TestCalculator.
 */
public class TestCalculator {

  /** The Constant FIBONACCI_1_TO_10. */
  private static final List<Integer> FIBONACCI_1_TO_10 = Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);

  @Test
  public void totalValues() throws Exception {
    final int expected = 376;
    int actual = new Calculator().getTotalValues(FIBONACCI_1_TO_10);
    assertEquals(expected, actual);
  }

}

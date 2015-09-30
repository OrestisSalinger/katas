package eu.salingers.katas.strategypattern;

import java.util.Arrays;
import java.util.List;

/**
 * The Class TestCalculator.
 */
final class Calculator {

  /** The Constant FIBONACCI_1_TO_10. */
  /**
   * Instantiates a new calculator.
   */
  Calculator() {
  }

int getTotalValues(final List<Integer> values) {
    int total = 0;
    for (Integer value : values) {
      total += value;
    }
    return total;
  }

}

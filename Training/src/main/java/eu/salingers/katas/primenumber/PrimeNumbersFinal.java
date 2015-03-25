package eu.salingers.katas.primenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author orestis@salingers.eu
 *
 */
public final class PrimeNumbersFinal {

  private PrimeNumbersFinal() {
  }

  /**
   * Calculate prime numbers.
   *
   * @return the list
   * @param max .
   */
  protected static List<Integer> calculatePrimeNumbers(final int max) {

    List<Integer> primes = new ArrayList<Integer>();

    for (int i = 0; i < max; i++) {
      addPrimesToList(calculate(i), primes, i);
    }

    return primes;
  }

  private static int calculate(final int i) {
    int count = 0;
    for (int j = 2; j <= i / 2; j++) {
      if (isModuloZero(i, j)) {
        count++;
      }
    }
    return count;
  }

  private static void addPrimesToList(final int count, final List<Integer> primes, final int i) {
    if (count == 0) {
      primes.add(new Integer(i));
    }
  }

  private static boolean isModuloZero(final int outerCount, final int innerCount) {
    return outerCount % innerCount == 0;
  }

}

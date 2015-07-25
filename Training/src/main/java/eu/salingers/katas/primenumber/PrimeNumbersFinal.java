package eu.salingers.katas.primenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @author orestis@salingers.eu
 *
 */
public final class PrimeNumbersFinal {

  PrimeNumbersFinal() throws InstantiationException {
    System.out.println("Do not instantiate " + PrimeNumbersFinal.class.getSimpleName());
    throw new InstantiationException("Do not instantiate " + PrimeNumbersFinal.class.getSimpleName());
  }

  /**
   * Calculate prime numbers.
   *
   * @return the list
   * @param max .
   */
  protected static List<Integer> calculatePrimeNumbers(final int max) {

    List<Integer> primes = new ArrayList<Integer>();

    for (int iteration = 0; iteration < max; iteration++) {
      if (calculate(iteration) == 0) {
        addPrimesToList(primes, iteration);
      }
    }

    return primes;
  }

  private static int calculate(final int iteration) {
    int count = 0;
    for (int i = 2; i <= iteration / 2; i++) {
      if (isModuloZero(iteration, i)) {
        count++;
      }
    }
    return count;
  }

  private static void addPrimesToList(final List<Integer> primes, final int i) {
      primes.add(new Integer(i));
  }

  private static boolean isModuloZero(final int outerCount, final int innerCount) {
    return outerCount % innerCount == 0;
  }

}

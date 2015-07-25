package eu.salingers.katas.primenumber;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author orestis@salingers.eu
 *
 */
public class PrimeNumbersBasicTest {
  /**
   * @throws Exception .
   */
  @Test
  public final void testCalculatePrimeNumbersFirstFifty() throws Exception {

    final Object[] first50PrimeNumbers = {0, 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};

    final Object[] primesToTest = new PrimeNumbersBasic().calculatePrimeNumbers().toArray();

    Assert.assertArrayEquals(first50PrimeNumbers, primesToTest);

  }

}

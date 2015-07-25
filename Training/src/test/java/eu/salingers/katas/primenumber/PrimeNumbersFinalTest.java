package eu.salingers.katas.primenumber;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author orestis@salingers.eu
 *
 */
public class PrimeNumbersFinalTest {

  /**
   * .
   */
  private static final int TWENTY = 20;

  /**
   * .
   */
  private static final int FIFTY = 50;

  /**
   * .
   */
  private static final int HUNDRED = 100;

  /**
   * @throws Exception .
   */
  @Rule
  public ExpectedException thrown = ExpectedException.none();
  
  @Test
  public final void testPrimeNumbersConstructorIsPrivate() throws Exception {
    thrown.expect(InstantiationException.class);
    thrown.expectMessage("Do not instantiate PrimeNumbersFinal");
    new PrimeNumbersFinal();

  }

  /**
   * @throws Exception .
   */

  @Test
  public final void testCalculatePrimeNumbersFirstFifty() throws Exception {

    final Object[] first50PrimeNumbers = {0, 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};

    final Object[] primesToTest = PrimeNumbersFinal.calculatePrimeNumbers(FIFTY).toArray();

    Assert.assertArrayEquals(first50PrimeNumbers, primesToTest);

  }

  /**
   * @throws Exception .
   */
  @Test
  public final void testCalculatePrimeNumbersFirstHundred() throws Exception {
    final Object[] first100PrimeNumbers = {0, 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};

    Assert.assertArrayEquals(first100PrimeNumbers, PrimeNumbersFinal.calculatePrimeNumbers(HUNDRED).toArray());
  }

  /**
   * @throws Exception .
   */
  @Test
  public final void testCalculatePrimeNumbersFirstTwenty() throws Exception {
    final Object[] first20PrimeNumbers = {0, 1, 2, 3, 5, 7, 11, 13, 17, 19};

    Assert.assertArrayEquals(first20PrimeNumbers, PrimeNumbersFinal.calculatePrimeNumbers(TWENTY).toArray());
  }

}

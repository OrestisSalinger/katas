package eu.salingers.katas.primenumber;

import org.junit.Assert;
import org.junit.Test;


public class PrimeNumbersTest {

	@Test
	public void testCalculatePrimeNumbers() throws Exception {
		Object[] first50PrimeNumbers = { 0, 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
				43, 47 };
		Object[] primesToTest = new PrimeNumbers().calculatePrimeNumbers().toArray();
		
		Assert.assertArrayEquals(first50PrimeNumbers, primesToTest);
		
		
		

	}

}

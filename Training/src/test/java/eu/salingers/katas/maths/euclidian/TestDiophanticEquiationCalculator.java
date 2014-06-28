package eu.salingers.katas.maths.euclidian;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

import static org.testng.Assert.*;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
//import org.owasp.esapi.ESAPI;
//import org.owasp.esapi.Randomizer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import eu.salingers.katas.maths.euclidian.RsaCalculator;

public class TestDiophanticEquiationCalculator {


	private RsaCalculator calc;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	private void throwsException() {
		thrown.expect(IllegalArgumentException.class);
		System.out.println("ftu");
	}







	@BeforeTest
	public void createCalculator(){
		calc = new RsaCalculator();
	}
	@AfterTest
	public void nullCalculator(){
		calc = null;
	}

	@Test(dataProvider = "sizes")
	public void generateTwoPrimes_digitsAsExpected(int sizePrime){
		String prime1 = String.valueOf(calc.getPrimes(sizePrime)[0].intValue());
		String prime2 = String.valueOf(calc.getPrimes(sizePrime)[1].intValue());
		System.out.println("prime1 " + prime1);
		System.out.println("prime2 " + prime2);
		assertNotEquals(prime1,prime2,"Primes Must Not Be Equal.");

//		assertEquals(prime1.length(),sizePrime);

	}

	  /**
     * Test of getRandomReal method, of class org.owasp.esapi.Randomizer.
     */
	@Test
public void testGetRandomReal() {
//    int min = -205234;
//    int max = 10012124;
////    Randomizer instance = ESAPI.randomizer();
//    int minResult = ( max - min ) / 2;
//    int maxResult = ( max - min ) / 2;
//    for ( int i = 0; i < 100; i++ ) {
////        float result = instance.getRandomReal(min, max);
//        if ( result < minResult ) minResult = (int) result;
//        if ( result > maxResult ) maxResult = (int) result;
//        System.out.println("result: " + result);
//
//    }
//    System.out.println("getRandomReal min: " + minResult);
//    System.out.println("getRandomReal max: " + maxResult);
//
//    assertEquals(true, (minResult >= min && maxResult < max));
}




	@Test
	public void generateE(){

	}

	@Test(dataProvider = "isRelativelyPrimeToData")
	public void isRelativelyPrimeTo(String isPrime, String to, boolean isPrimeTo) {
		assertEquals(calc.isRelativelyPrimeTo(isPrime,to),isPrimeTo);
	}

	private BigInteger bigInt(String isPrime) {
		return new BigInteger(isPrime);
	}

	@Test(dataProvider = "ggtData")
	public void findGgtDataProvider(String a, String b, String expected) {
		RsaCalculator calc = new RsaCalculator();
		BigInteger ggt = calc.findGgt(bigInt(a), bigInt(b));
		assertEquals(ggt.intValue(), Integer.parseInt(expected));
	}

	@Test(dataProvider = "calculateData")
	public void calulate(String a, String b, String c, boolean isDiophantic) {
		RsaCalculator calc = new RsaCalculator();
		assertEquals(calc.isDiophantic(bigInt(a), bigInt(b),
				bigInt(c)), isDiophantic);

	}

	@DataProvider
	private Object[][] calculateData() {
		return new Object[][] {
				{ "8", "16", "21", false },
				{ "6", "9", "14", false },
				{ "6", "9", "18", true },
				{ "81", "162", "21", false },
				{ "682", "322", "14", true },
				{ "61", "19", "11", true }};
	}

	@DataProvider
	private Object[][] ggtData() {
		return new Object[][] {
				{ "128", "34", "2" },
				{ "9", "99", "9" },
				{ "99", "9", "9" },
				{ "9999", "999999", "99" },
				{ "999999", "9999", "99" },
				{ "99", "9", "9" },
				{ "15", "99", "3" },
				{ "99", "15", "3" },
				{ "158992", "643232", "16" },
				{ "158837463827992", "648393047563232", "8" },
				{ "648393047563232", "158837463827992", "8" },
				{ "64839304736453637487563232", "15883773645372937463827992",
						"8" },
				{ "15883773645372937463827992", "64839304736453637487563232",
						"8" },
				{ "938473645437382938473648393048204",
						"7364536484984736475847645393049064", "4" },
				{ "7364536484984736475847645393049064",
						"938473645437382938473648393048204", "4" },
				{
						"73645364849847364758476453930490646483930473645363748756323215883773645372937463827999",
						"15736453648498473647584764539304906488377364537293746382799215883773645372937463827952",
						"3" },
				{
						"15736453648498473647584764539304906488377364537293746382799215883773645372937463827952",
						"73645364849847364758476453930490646483930473645363748756323215883773645372937463827999",
						"3" } };

	}

	@DataProvider
	private Object[][] isRelativelyPrimeToData() {
		return new Object[][] {
				{ "8", "16" ,false},
				{ "7", "23",true },
				{ "256", "2048",false },
				{  "6321314","12322131318",true },
				{ "12", "2048",true }};
	}

	@DataProvider
	private Object[][] sizes() {
		return new Object[][] {
				{4},
				{2},
				{26}};
	}

}

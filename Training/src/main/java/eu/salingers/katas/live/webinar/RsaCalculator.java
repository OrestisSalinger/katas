package eu.salingers.katas.live.webinar;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

//import org.owasp.esapi.ESAPI;
//import org.owasp.esapi.Randomizer;

class RsaCalculator {
	RsaCalculator() {
	}

	/**
	 * @param a
	 * @param b
	 * @param result
	 */
	boolean isDiophantic(BigInteger a, BigInteger b, BigInteger result) {
		BigInteger ggt = findGgt(a, b);
		return result.mod(ggt) == BigInteger.ZERO;
	}

	BigInteger findGgt(BigInteger a, BigInteger b) {
		while (!b.equals(BigInteger.ZERO)) {
			if (a.compareTo(b) == 1) {
				// System.out.println("\n.............\nA: " + a);
				// System.out.println("B: " + b);
				a = a.subtract(b);
			} else {
				b = b.subtract(a);
				// System.out.println("B: " + b);
				// System.out.println("A: " + a + "\n.............\n");
			}
		}
		// System.out.println("GGT: " + a);
		return a;
	}

	boolean isRelativelyPrimeTo(String isPrime, String to) {
		return (new BigInteger(to).mod(new BigInteger(isPrime)) != BigInteger.ZERO);
	}
	boolean isPrime(long n) {
	    if(n < 2) return false;
	    if(n == 2 || n == 3) return true;
	    if(n%2 == 0 || n%3 == 0) return false;
	    long sqrtN = (long)Math.sqrt(n)+1;
	    for(long i = 6L; i <= sqrtN; i += 6) {
	        if(n%(i-1) == 0 || n%(i+1) == 0) return false;
	    }
	    return true;
	}
	BigInteger[] getPrimes(int size) {
	    BigInteger probablePrime1 = BigInteger.probablePrime(size, createSecureNumber());
	    BigInteger probablePrime2 = BigInteger.probablePrime(size, createSecureNumber());

	    while (!isPrime(probablePrime1.longValue())) {
		     probablePrime1 = BigInteger.probablePrime(size, createSecureNumber());
		}
		while (!isPrime(probablePrime2.longValue())) {
		     probablePrime2 = BigInteger.probablePrime(size, createSecureNumber());
		}
		return new BigInteger[]{probablePrime1,probablePrime2};
	}

	private SecureRandom createSecureNumber() {
		SecureRandom number = null;
			 int min = -205234;
			    int max = 10012124;
//			    Randomizer instance = ESAPI.randomizer();

//			        Integer  result =  Float.floatToIntBits(instance.getRandomReal(min, max));

//			    System.out.println("result: " + String.valueOf(result));
		return number;
	}
}

package eu.salingers.katas.primenumber;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.internal.Lists;

public class PrimeNumbers {

	 PrimeNumbers() {

	}

	protected List<Integer> calculatePrimeNumbers() {
		final int num = 50;
		int count = 0;
		List<Integer> primes = Lists.newArrayList();
		for (int i = 0; i < num; i++) {
			count = 0;
			for (int j = 2; j <= i / 2; j++) {
				if (isModZero(i, j)) {
					count++;
				}
			}

			if (count == 0) {
				primes.add(new Integer(i));
			}

		}
		return primes;
	}

	private static boolean isModZero(int i, int j) {
		return i % j == 0;
	}

}

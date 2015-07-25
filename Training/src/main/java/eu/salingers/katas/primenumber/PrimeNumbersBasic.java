package eu.salingers.katas.primenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class PrimeNumbersBasic {

  PrimeNumbersBasic() {

  }

  protected List<Integer> calculatePrimeNumbers() {
    final int num = 50;
    int count = 0;
    List<Integer> primes = new ArrayList<Integer>();
    for (int i = 0; i < num; i++) {
      count = 0;
      for (int j = 2; j <= i / 2; j++) {
        if (i % j == 0) {
          count++;
        }
      }

      if (count == 0) {
        primes.add(new Integer(i));
      }

    }
    return primes;
  }
}

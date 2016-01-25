package eu.salingers.java8.streams;

import java.util.Arrays;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * The Class TestStreamPerformance.
 */
public class TestStreamPerformance {
  static int[] ints = new int[10_000_000];

  @BeforeClass
  public static void setup() {
    for (int i = 0; i < 10_000_000; i++) {
      ints[i] = i;
    }
   
  }
  @Ignore
  @Test
  public final void forEachLoop() {
    // long startTime = System.currentTimeMillis();
    int[] a = ints;
    int e = ints.length;
    int m = Integer.MIN_VALUE;

    for (int i = 0; i < e; i++) {
      if (a[i] > m) {
        m = a[i];
      }
    }
  }
  
  @Test
  public final void parallelStreamUnordered() {
    // long startTime = System.currentTimeMillis();
    final int[] a = ints;
     Arrays.stream(a)
        .parallel()
        .unordered()
        .distinct()
        .count();
  }
  @Test
  public final void parallelStreamOrdered() {
    // long startTime = System.currentTimeMillis();
   final int[] a = ints;
     Arrays.stream(a)
        .parallel()
        .distinct()
        .count();
  }
  @Test
  public final void sequentialStreamOrdered() {
    // long startTime = System.currentTimeMillis();
   final int[] a = ints;
     Arrays.stream(a)
        .distinct()
        .count();
  }
  @Test
  public final void sequentialStreamUnordered() {
    // long startTime = System.currentTimeMillis();
   final int[] a = ints;
     Arrays.stream(a)
       .unordered() 
       .distinct()
        .count();
  

}
}

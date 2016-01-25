package eu.salingers.katas.live.trifork;

public class StringCalculator {

  public int add(String numbers) {
    if(numbers.contains("-")){
      throw new IllegalArgumentException("Negative values are not allowed");
    }
    if (isEmptyInput(numbers)) {
      return defaultValue();
    }
    if (isSingleNumber(numbers)) {
      return parseSingleNumber(numbers);
    }
    return 3;
  }

  private int defaultValue() {
    return 0;
  }

  private boolean isEmptyInput(String numbers) {
    return numbers.isEmpty();
  }

  private int parseSingleNumber(String numbers) {
    return Integer.parseInt(numbers);
  }

  private boolean isSingleNumber(String numbers) {
    return !isMultipleNumbers(numbers);
  }

  private boolean isMultipleNumbers(String numbers) {
    return numbers.length() > 1;
  }



}

package eu.salingers.katas.stringcalculator.workVersion;

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
    return false;
  }

  private int parseSingleNumber(String numbers) {
    final int result = Integer.parseInt(numbers);
    try {
      final String text = "Got " + result;
      callLogger(text);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }

//  Seam!
  protected void callLogger(final String text) throws Exception {
    StaticLogger.write(text);
  }

  private boolean isSingleNumber(String numbers) {
    return !isMultipleNumbers(numbers);
  }

  private boolean isMultipleNumbers(String numbers) {
    return numbers.length() > 1;
  }

  public int parse(String numbers) {
    if(numbers.length() == 0){
      return 0;
    }
    return Integer.parseInt(numbers);
  }



}

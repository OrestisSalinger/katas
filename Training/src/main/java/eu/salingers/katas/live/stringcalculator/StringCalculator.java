package eu.salingers.katas.live.stringcalculator;

public class StringCalculator {

  private static final int MAX = 1000;

  public int add(final String number) {
    if (isDefault(number)) {
      return 0;
    }
    if (isNegative(number)) {
      throw new IllegalArgumentException("Negative values are not allowed");
    }
    String[] numbers = toArray(number, ",|\n");
    if (numbers.length == 1) {
      return toInt(number);
    } else {
      return sum(numbers);
    }
  }

  private boolean isNegative(final String number) {
    return number.contains("-");
  }

  private boolean isDefault(final String number) {
    return number == null || number.isEmpty();
  }

  private String[] toArray(final String input, final String delimiter) {
    return input.split(delimiter);
  }

  private int sum(final String[] numbers) {
    int sum = 0;
    for (String current : numbers) {

      if (!isGreaterThanThousand(current)) {
        sum += toInt(current);
      }
    }
    return sum;
  }

  private boolean isGreaterThanThousand(final String current) {
    return toInt(current) > MAX;
  }

  private int toInt(final String input) {
    return Integer.parseInt(input);
  }

}

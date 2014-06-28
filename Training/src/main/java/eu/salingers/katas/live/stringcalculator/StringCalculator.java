package eu.salingers.katas.live.stringcalculator;

public class StringCalculator {



	public int add(String number) {
		if (isDefault(number)) {
			return 0;
		}
		if (isNegative(number)) {
			throw new IllegalArgumentException(
					"Negative values are not allowed");
		}
		String[] numbers = toArray(number, ",|\n");
		if (numbers.length == 1) {
			return toInt(number);
		} else {
			return sum(numbers);
		}
	}

	private boolean isNegative(String number) {
		return number.contains("-");
	}

	private boolean isDefault(String number) {
		return number == null || number.isEmpty();
	}

	private String[] toArray(String input, String delimiter) {
		return input.split(delimiter);
	}

	private int sum(String[] numbers) {
		int sum = 0;
		for (String current : numbers) {

			if (!isGreaterThanThousand(current)) {
				sum += toInt(current);
			}
		}
		return sum;
	}

	private boolean isGreaterThanThousand(String current) {
		return toInt(current) > 1000;
	}

	private int toInt(String input) {
		return Integer.parseInt(input);
	}

}

package eu.salingers.katas.stringcalculator.finalVersion;

public class StringCalculator {

	public static final String NEGATIVE_VALUES_ARE_NOT_ALLOWED = "Negative values are not allowed!";
	private static final String DELIMITER = ",|\n";

	public int add(String input) throws Exception {
		String[] numbers = toArray(input, DELIMITER);
		if (isEmpty(input)) {
			return 0;
		}
		if (numbers.length == 1 && !isNegative(numbers[0])) {
			return toInt(input);
		} else {
			return sum(numbers);
		}
	}

	private String[] toArray(String input, String delimiter) {
		return input.split(delimiter);
	}

	private int sum(String[] numbers) throws Exception {
		int sum = 0;
		for (String current : numbers) {
			validateInput(current);
			if (!isGreaterThanThousand(current)) {
				sum += toInt(current);
			}

		}
		return sum;
	}

	private void validateInput(String current) throws Exception {
		if (isNegative(current)) {
			throw new Exception(NEGATIVE_VALUES_ARE_NOT_ALLOWED);
		}
	}

	private boolean isGreaterThanThousand(String current) {
		return toInt(current) > 1000;
	}

	private boolean isNegative(String current) {
		return toInt(current) < 0;
	}

	private boolean isEmpty(String input) {
		return input.isEmpty();
	}

	private int toInt(String input) {
		return Integer.parseInt(input);
	}

}

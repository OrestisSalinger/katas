package eu.salingers.katas.live.stringcalculator;

public interface Calculatable {

	public static final String PARAMETER_MUST_NOT_BE_NEGATIVE = "Negative values are not allowed";

	public int add(String number);

	public int subtract(String howMuch, String from);

	public int parse(String string);

}
package eu.salingers.katas.live.legic.stringcalculator;

import static org.junit.Assert.assertEquals;
//import junitparams.JUnitParamsRunner;

import org.junit.Test;

import eu.salingers.katas.live.legic.stringcalculator.StringCalculator;

public class TestStringCalculatorRETIRED {


	@Test
	public void add_emptyString_returnsZero() {
		assertEquals(0, calculator().add(""));
	}

  private StringCalculator calculator() {
    final StringCalculator stringCalculator = new StringCalculator();
    return stringCalculator;
  }

	@Test
	public void add_singleValue_isReplied() {
		assertEquals(new StringCalculator().add("1"), 1);
	}

	@Test
	public void add_twoNumbersCommaSeparated_returnSum() {
		assertEquals(new StringCalculator().add("1,2"), 3);
	}

	@Test
	public void add_twoNumbersNewLineSeparated_returnSum() {
		assertEquals(new StringCalculator().add("1\n2"), 3);
	}

	@Test
	public void add_inputGreaterThanThousand_returnSumIgnoreGreatInput()
			throws Exception {
		assertEquals(new StringCalculator().add("1\n2,1001"), 3);
	}


}

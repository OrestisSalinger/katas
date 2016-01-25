package eu.salingers.katas.live.webinar;

import static org.junit.Assert.assertEquals;
//import junitparams.JUnitParamsRunner;

import org.junit.Test;

import eu.salingers.katas.live.legic.stringcalculator.StringCalculator;

public class TestStringCalculator {


	@Test
	public void add_emptyString_returnsZero() {
		assertEquals(0, new StringCalculator().add(""));
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

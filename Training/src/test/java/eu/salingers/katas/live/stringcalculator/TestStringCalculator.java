package eu.salingers.katas.live.stringcalculator;

import static org.junit.Assert.assertEquals;
//import junitparams.JUnitParamsRunner;

import org.junit.Test;

public class TestStringCalculator {


	@Test
	public void add_emptyString_returnsZero() throws Exception {
		assertEquals(new StringCalculator().add(""), 0);
	}

	@Test
	public void add_singleValue_isReplied() throws Exception {
		assertEquals(new StringCalculator().add("1"), 1);
	}

	@Test
	public void add_twoNumbersCommaSeparated_returnSum() throws Exception {
		assertEquals(new StringCalculator().add("1,2"), 3);
	}

	@Test
	public void add_twoNumbersNewLineSeparated_returnSum() throws Exception {
		assertEquals(new StringCalculator().add("1\n2"), 3);
	}

	@Test
	public void add_threeNumbersBothWaysSeparated_returnSum() throws Exception {
		assertEquals(new StringCalculator().add("1\n2,3"), 6);
	}

	@Test
	public void add_inputGreaterThanThousand_returnSumIgnoreGreatInput()
			throws Exception {
		assertEquals(new StringCalculator().add("1\n2,1001"), 3);
	}


}

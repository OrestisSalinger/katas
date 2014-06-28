package eu.salingers.katas.reversecalculator;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCalculator {


	private Calculator calculator;
	@BeforeTest
	private void createCalculator() {
		calculator = new Calculator();
	}


	@Test
  public void newCalculator_accumolatorIsZero() {
	  assertEquals(BigDecimal.ZERO, calculator.getAccumlator());
  }
  @Test
  public void newCalculator_setAccumlator_accumlatorIsEqualToValue() {
	  calculator.setAccumlator(BigDecimal.ONE);
	  assertEquals(BigDecimal.ONE, calculator.getAccumlator());
  }
  @Test
  public void newCalculator_enteringValues_accumlatorStacksValues() {
	  BigDecimal value1 = new BigDecimal(1);
	  calculator.setAccumlator(value1);
	  calculator.enter();
	  assertEquals(calculator.getAccumlator(), value1);
	  BigDecimal value2 = new BigDecimal(2);
	  calculator.setAccumlator(value2);
	  calculator.enter();
	  assertEquals(calculator.getAccumlator(), value2);
	  assertEquals(calculator.getAccumlator(),value2);
  }

  @Test
  public void newCalculator_droppingValues_accumlatorRemovesDroppedValues() {
	  calculator.setAccumlator(new BigDecimal(1));
	  calculator.enter();
	  calculator.setAccumlator(new BigDecimal(2));
	  calculator.drop();
	  assertEquals(calculator.getAccumlator(),1);
  }







}

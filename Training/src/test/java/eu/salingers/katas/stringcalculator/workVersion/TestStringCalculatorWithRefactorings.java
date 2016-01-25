package eu.salingers.katas.stringcalculator.workVersion;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
//Extract and override!
public class TestStringCalculatorWithRefactorings {

  class TestableStringCalculatorWithSatics extends StringCalculatorWithStatics{
    
    private String written;

    @Override
    protected void callLogger(String text){
      written = text;
    }
  
  }
  @Test
  public void add_always_callsStaticLogger() {
    TestableStringCalculatorWithSatics tsc = new TestableStringCalculatorWithSatics();
    tsc.add("1");
    assertEquals("Got 1", tsc.written);
  }
  
  
}

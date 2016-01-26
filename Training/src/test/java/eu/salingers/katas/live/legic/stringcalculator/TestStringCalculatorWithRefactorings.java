package eu.salingers.katas.live.legic.stringcalculator;
import static org.junit.Assert.*;
import org.junit.Test;
//Extract and override!
public class TestStringCalculatorWithRefactorings {

  
  
  
  
  class TestableStringCalculatorWithSatics extends StringCalculatorWithStatics{
    
    private String written;

    @Override
    protected void write(String text){
      written = text;
    }
  
  }
  @Test
  public void add_always_callsStaticLogger() {
    TestableStringCalculatorWithSatics tsc = new TestableStringCalculatorWithSatics();
    tsc.add("1");
    assertEquals("got 1", tsc.written);
  }
  
  
}

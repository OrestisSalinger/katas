package eu.salingers.refactoring;

import static org.junit.Assert.*;

import org.junit.*;

public class RouteFileWriterTest {
	private RouteFileWriter roundFileWriter;
	private Route north;
	private Route south;
	private Purchaser jackson;
	private Purchaser smith;
	private Purchaser wesson;
	private Order jacksonOrder1;
	private Order jacksonOrder2;
	private Order smithOrder;
	private Order wessonOrder;
	
	@Before
	public void setUp() {
		jacksonOrder1 = new Order("123456");
		jacksonOrder2 = new Order("987");
		jackson = new Purchaser("Jackson", new Order[] { jacksonOrder1, jacksonOrder2 });
		
		smithOrder = new Order("567");
		smith = new Purchaser("Smith", new Order[] { smithOrder });
		
		wessonOrder = new Order("23");
		wesson = new Purchaser("Wesson", new Order[] { wessonOrder });
		
		north = new Route("North", new Purchaser[] { jackson, smith });
		south = new Route("South", new Purchaser[] { wesson });
		
		roundFileWriter = new RouteFileWriter(new Route[] { north, south });
	}
	
	@Test
	public void pizzaFileWritten() {
		jacksonOrder1.setType(true);
		jacksonOrder2.setType(true);
		smithOrder.setType(true);
		wessonOrder.setType(true);
		String actualFileContents = roundFileWriter.writePizzaFile();
		String expectedFileContents = "North,Jackson,123456\n" + "North,Jackson,987\n" + "North,Smith,567\n" + "South,Wesson,23\n";
		assertEquals(expectedFileContents, actualFileContents);
	}
	
	@Test
	public void pizzaOrdersNotWrittenIntoOrderFile() {
		jacksonOrder1.setType(true);
		jacksonOrder2.setType(true);
		smithOrder.setType(true);
		wessonOrder.setType(false);
		String actualFileContents = roundFileWriter.writePizzaFile();
		String expectedFileContents = "North,Jackson,123456\n" + "North,Jackson,987\n" + "North,Smith,567\n";
		assertEquals(expectedFileContents, actualFileContents);
	}
	
	@Test
	public void kebapFileWritten() {
		jacksonOrder1.setType(false);
		jacksonOrder2.setType(false);
		smithOrder.setType(false);
		wessonOrder.setType(false);
		String actualFileContents = roundFileWriter.writeKebapFile();
		String expectedFileContents = "North,Jackson,123456\n" + "North,Jackson,987\n" + "North,Smith,567\n" + "South,Wesson,23\n";
		assertEquals(expectedFileContents, actualFileContents);
	}
	
	@Test
	public void kebapOrderNotWrittenIntoPizzasFile() {
		jacksonOrder1.setType(false);
		jacksonOrder2.setType(false);
		smithOrder.setType(false);
		wessonOrder.setType(true);
		String actualFileContents = roundFileWriter.writeKebapFile();
		String expectedFileContents = "North,Jackson,123456\n" + "North,Jackson,987\n" + "North,Smith,567\n";
		assertEquals(expectedFileContents, actualFileContents);
	}
}

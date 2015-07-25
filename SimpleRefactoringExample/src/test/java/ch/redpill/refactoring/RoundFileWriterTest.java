package ch.redpill.refactoring;

import static org.junit.Assert.*;

import org.junit.*;

public class RoundFileWriterTest {
	private RoundFileWriter roundFileWriter;
	private Round north;
	private Round south;
	private Customer bloggs;
	private Customer jones;
	private Customer fred;
	private Parcel bloggsParcel1;
	private Parcel bloggsParcel2;
	private Parcel jonesParcel;
	private Parcel fredParcel;
	
	@Before
	public void setUp() {
		bloggsParcel1 = new Parcel("123456");
		bloggsParcel2 = new Parcel("987");
		bloggs = new Customer("Bloggs", new Parcel[] { bloggsParcel1, bloggsParcel2 });
		
		jonesParcel = new Parcel("567");
		jones = new Customer("Jones", new Parcel[] { jonesParcel });
		
		
		
		fredParcel = new Parcel("23");
		fred = new Customer("Fred", new Parcel[] { fredParcel });
		
		
		
		
		north = new Round("North", new Customer[] { bloggs, jones });
		south = new Round("South", new Customer[] { fred });
		roundFileWriter = new RoundFileWriter(new Round[] { north, south });
	}
	
	@Test
	public void magazineFileWritten() {
		bloggsParcel1.setType(true);
		bloggsParcel2.setType(true);
		jonesParcel.setType(true);
		fredParcel.setType(true);
		String actualFileContents = roundFileWriter.writeMagazineFile();
		String expectedFileContents = "North,Bloggs,123456\n" + "North,Bloggs,987\n" + "North,Jones,567\n" + "South,Fred,23\n";
		assertEquals(expectedFileContents, actualFileContents);
	}
	
	@Test
	public void newspaperParcelsNotWrittenIntoMagazineFile() {
		bloggsParcel1.setType(true);
		bloggsParcel2.setType(true);
		jonesParcel.setType(true);
		fredParcel.setType(false);
		String actualFileContents = roundFileWriter.writeMagazineFile();
		String expectedFileContents = "North,Bloggs,123456\n" + "North,Bloggs,987\n" + "North,Jones,567\n";
		assertEquals(expectedFileContents, actualFileContents);
	}
	
	@Test
	public void newspaperFileWritten() {
		bloggsParcel1.setType(false);
		bloggsParcel2.setType(false);
		jonesParcel.setType(false);
		fredParcel.setType(false);
		String actualFileContents = roundFileWriter.writeNewspaperFile();
		String expectedFileContents = "North,Bloggs,123456\n" + "North,Bloggs,987\n" + "North,Jones,567\n" + "South,Fred,23\n";
		assertEquals(expectedFileContents, actualFileContents);
	}
	
	@Test
	public void magazineParcelsNotWrittenIntoNewspaperFile() {
		bloggsParcel1.setType(false);
		bloggsParcel2.setType(false);
		jonesParcel.setType(false);
		fredParcel.setType(true);
		String actualFileContents = roundFileWriter.writeNewspaperFile();
		String expectedFileContents = "North,Bloggs,123456\n" + "North,Bloggs,987\n" + "North,Jones,567\n";
		assertEquals(expectedFileContents, actualFileContents);
	}
}

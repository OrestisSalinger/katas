package eu.salingers;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class TestFileFinder {
    
    private static final String REMOVE_FROM_FILENAME = ".sample";
	private static final String WILDCARD = "*";
	private static final String SOURCE_FILE_SUFFIX_PATTERN = ".properties.sample";
	private static final String PATH_IDCONNECT_REL = "../idconnect";

	@Test
    public void getMatches_allPropertiesSampleFilesInFreshCheckout_finds30Files() throws IOException {
    	 Path startingDir = Paths.get(PATH_IDCONNECT_REL);
         String sourceFilePattern = WILDCARD+SOURCE_FILE_SUFFIX_PATTERN;
         
         FileFinder finder =  findFiles(startingDir,sourceFilePattern);
         System.out.println("Found: "+finder.getMatches().size());
         assertEquals(30,finder.getMatches().size());
    }

	@Test
    public void copySampleFileToPropertiesFile_allPropertiesSampleFiles_finds65PropertiesFiles() throws IOException {
		 Path startingDir = Paths.get(PATH_IDCONNECT_REL);
		 String sourceFilePattern = WILDCARD+SOURCE_FILE_SUFFIX_PATTERN;

		 FileFinder finder =  findFiles(startingDir,sourceFilePattern);
         finder.copySampleFileToPropertiesFile(REMOVE_FROM_FILENAME);
         FileFinder finderAfter =  findFiles(startingDir,sourceFilePattern.replace(REMOVE_FROM_FILENAME, ""));
         List<File> fileListAfter = finderAfter.getMatches();
         System.out.println("Files found after: " + fileListAfter.size());

         assertEquals(65,fileListAfter.size());

    }
	
	
	private FileFinder findFiles(Path startingDir, String pattern) throws IOException {
		return  new FileFinder(startingDir, pattern);
		
	}





}

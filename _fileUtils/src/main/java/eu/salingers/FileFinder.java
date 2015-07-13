package eu.salingers;


/**
 * Sample code that finds files that match the specified glob pattern.
 * For more information on what constitutes a glob pattern, see
 * https://docs.oracle.com/javase/tutorial/essential/io/fileOps.html#glob
 *
 * The file or directories that match the pattern are printed to
 * standard out.  The number of matches is also printed.
 *
 * When executing this application, you must put the glob pattern
 * in quotes, so the shell will not expand any wild cards:
 *              java Find . -name "*.java"
 */

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


    public class FileFinder extends SimpleFileVisitor<Path> {
    	private List<File> matches = new ArrayList<File>(); 
        private final PathMatcher matcher;
        private int numMatches = 0;

        public FileFinder(Path startingDir, String pattern) throws IOException {
        	matcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
            Files.walkFileTree(startingDir, this);

        }

        // Compares the glob pattern against
        // the file or directory name.
        void find(Path file) {
        	Path name = file.getFileName();
            if (name != null && matcher.matches(name)) {
                numMatches++;
                getMatches().add(file.toFile());
                System.out.println("Found: " + file);
            }
        }

        
     /**
     * @return the list of files found.
     * @throws IOException 
     */
    List<File> copySampleFileToPropertiesFile(String removePattern) throws IOException {
            System.out.println("************ Entering copyToName(String name)");
        	System.out.println("Matched: " + numMatches);
        	copyFilesToPartialFileNames(getMatches(), removePattern);
        	return getMatches();
        }

    /**
     * @param sources
     * @param removePattern
     * @throws IOException
     */
    public void copyFilesToPartialFileNames(List<File> sources, String removePattern) throws IOException{
        for (File file : sources) {
			copyFileToDifferentName(file, new File(file.getAbsolutePath().replace(removePattern, "")));
		}
    }
    
    private void copyFileToDifferentName(File source, File dest) throws IOException{
    	try {
        	Files.copy(source.toPath(), dest.toPath());
        	System.out.println("Copied: " + source.getAbsolutePath() + " To " + dest.getAbsolutePath());
		} catch (FileAlreadyExistsException e) {
			System.out.println("File " + dest.getAbsolutePath() + " already exist.");
			//Intentionally swallowed.
		}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    // Invoke the pattern matching
        // method on each file.
        @Override
        public FileVisitResult visitFile(Path file,
                BasicFileAttributes attrs) {
        	find(file);
            return CONTINUE;
        }

        // Invoke the pattern matching
        // method on each directory.
        @Override
        public FileVisitResult preVisitDirectory(Path dir,
                BasicFileAttributes attrs) {
        	find(dir);
            return CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file,
                IOException exc) {
        	System.err.println(exc);
            return CONTINUE;
        }

		public List<File> getMatches() {
			return matches;
		}

	
        
//    public static void main(String[] args)
//        throws IOException {
//
//        if (args.length < 3 || !args[1].equals("-name"))
//            usage();
//
//        Path startingDir = Paths.get(args[0]);
//        String pattern = args[2];
//
//        Finder finder = new Finder(pattern);
//        Files.walkFileTree(startingDir, finder);
//        finder.done();
//    }
}
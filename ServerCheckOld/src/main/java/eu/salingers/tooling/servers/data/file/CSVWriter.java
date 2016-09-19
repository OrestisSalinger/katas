package eu.salingers.tooling.servers.data.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CSVWriter {


  public CSVWriter() {
  }
  
  public void appendLineToFile(String entry, String file) throws IOException{
    try(BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))){
      writer.append('\n');
      writer.append(entry);
    }
  }

  public void copyOverride(String from, String to) {
    Path sourcePath      = Paths.get(from);
    Path destinationPath = Paths.get(to);

    try {
        Files.copy(sourcePath, destinationPath,
                StandardCopyOption.REPLACE_EXISTING);
    } catch(FileAlreadyExistsException e) {
        //destination file already exists
    } catch (IOException e) {
        //something else went wrong
        e.printStackTrace();
    }
  }
  
}

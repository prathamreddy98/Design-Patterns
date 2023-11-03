package studentCoursesMgmt.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The `FileProcessor` class provides utility methods for reading from and writing to text files.
 * It allows the creation of a BufferedReader for reading and a BufferedWriter for writing text files.
 * Users can create readers and writers for specific files, read lines from files, write data to files,
 * and close file resources.
 * 
 * 
 * Usage:
 * 1. Create an instance of `FileProcessor`.
 * 2. Call `createReader(String filePath)` to initialize a reader for a specific file.
 * 3. Use `readNextLine()` to read lines from the file sequentially.
 * 4. Call `createWriter(String filePath)` to initialize a writer for a specific file.
 * 5. Use `writeToFile(String s)` to write data to the file.
 * 6. Call `close()` to close the reader or writer when done.
 * 
 * Note: It's essential to close the reader or writer to release file resources properly.
 * 
 * Example:
 * ```java
 * String filePath = "test.txt";
 * FileProcessor fp = new FileProcessor();
 * fp.createWriter(filePath);
 * String data = "Hello, World!";
 * fp.writeToFile(data);
 * fp.close();
 * ```
 * 
 * @author dedsec995
 * @version 0.3.1
 */

public class FileProcessor {
    private BufferedReader reader;
    private BufferedWriter writer;

    /**
     * Default constructor for the `FileProcessor` class.
     * Creates an instance without initializing a reader or writer.
     */
    public FileProcessor(){
    }

    public void createReader(String filePath) throws IOException {
        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get(filePath);
        reader = new BufferedReader(Files.newBufferedReader(file, charset));
    }

    public String readNextLine() throws IOException {
        if (reader == null) {
            throw new IllegalStateException("Reader is not initialized. Call createReader first.");
        }
        String line = reader.readLine();
        if (line == null) {
            reader.close();
        }
        return line;
    }

    /**
     * Initializes a BufferedWriter for writing to a specific file.
     *
     * @param filePath The path to the file to which data will be written.
     * @throws IOException If there is an error while opening the file for writing.
     */
    public void createWriter(String filePath) throws IOException {
        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get(filePath);
        writer = Files.newBufferedWriter(file, charset);
    }

    /**
     * Writes data to the file.
     *
     * @param s The data to be written to the file.
     * @throws IOException If there is an error while writing to the file.
     */
    public void writeToFile(String s) throws IOException {
        if (writer == null) {
            throw new IllegalStateException("Writer is not initialized. Call createWriter first.");
        }
        
        writer.write(s, 0, s.length());
    }

    /**
     * Closes the reader or writer, releasing associated file resources.
     *
     * @throws IOException If there is an error while closing the file resources.
     */
    public void close() throws IOException {
        if (writer != null) {
            writer.close();
        }
    }

    // Test purpose
    // public static void main(String[] args) {

    //     String filePath = "test.txt"; 

    //     try {
    //         FileProcessor fp = new FileProcessor();
    //         fp.createWriter(filePath);
    //         String data = "Hello, World!";
    //         fp.writeToFile(data);
    //         fp.close();
    //     } catch (IOException x) {
    //         System.err.format("IOException: %s%n", x);
    //         x.printStackTrace();
    //     }
    //     // ---------------------------------------- File Reader----------------------------------
    //     String filePath = "/home/aluhar1/dp/cs542-fall-23-assign1-dedsec995/studentCoursesMgmt/src/courseInfo/courseInfo3.txt";
    //     try {
    //         FileProcessor fp = new FileProcessor();
    //         fp.createReader(filePath);
    //         String line;
    //         while ((line = fp.readNextLine()) != null) {
    //             System.out.println(line);
    //         }
    //     } catch (IOException x) {
    //         System.err.format("IOException: %s%n", x);
    //         x.printStackTrace();
    //     }
    //     // ---------------------------------------------------------------------------------------

    //     // ---------------------------------------- Local File Read-------------------------------
    //     try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
    //     String line = null;
    //     while ((line = reader.readLine()) != null) {
    //     System.out.println(line);
    //     }
    //     } catch (IOException x) {
    //     System.err.format("IOException: %s%n", x);
    //     x.printStackTrace();
    //     }
    //     }
    //     // --------------------------------------------------------------------------------------
    // }
}

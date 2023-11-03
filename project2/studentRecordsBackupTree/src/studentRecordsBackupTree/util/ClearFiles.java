package studentRecordsBackupTree.util;

import java.io.FileWriter;
import java.io.IOException;

public class ClearFiles {
    /**
     * @param file_name
     * @param error_file
     */
    public static void ClearData(String file_name, String error_file){
        try{
            FileWriter fw = new FileWriter(file_name, false);
            fw.write("");
            fw.close();
        } catch(IOException ioException){
            Results.write_result(ioException.toString(), error_file, error_file);
        } finally{
            System.out.println("Finally Block");
        }
    }
}

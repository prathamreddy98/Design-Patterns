package studentRecordsBackupTree.util;
import java.io.FileWriter;
import java.io.IOException;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    public static void write_result(String ans, String Output, String error_file){
        try{
            FileWriter fw = new FileWriter(Output, true);
            fw.write(ans);
            fw.close();
                
        }
        catch(IOException e){
            Results.write_result(e.toString(), error_file, error_file);
        }
        finally{

        }
    }

	
}

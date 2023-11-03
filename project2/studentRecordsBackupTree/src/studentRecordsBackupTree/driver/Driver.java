package studentRecordsBackupTree.driver;
import studentRecordsBackupTree.bst.BSTBuilder;
import studentRecordsBackupTree.bst.BST;
import studentRecordsBackupTree.bst.Node;
import studentRecordsBackupTree.util.FileProcessor;

/**
 * @author placeholder
 *
 */

public class Driver {
	public static void main(String[] args) {
		

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

	    if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")
				|| args[3].equals("${arg3}") || args[4].equals("${arg4}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
			System.exit(0);
		}

		String input_file = args[0]; // input file
		int update_value = Integer.parseInt(args[4]);// update argument
		FileProcessor fp= new FileProcessor();
		String Output_file=args[1];
		String error_file=args[2];
		
		fp.read_file(input_file, update_value, Output_file, error_file);
		BST b= new BST();

   		 b.inorder(Output_file, error_file);

	}
}

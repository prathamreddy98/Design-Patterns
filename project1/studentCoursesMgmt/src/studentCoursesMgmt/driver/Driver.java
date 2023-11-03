package studentCoursesMgmt.driver;

import studentCoursesMgmt.util.FileProcessor;
import studentCoursesMgmt.util.Logger;
import studentCoursesMgmt.util.Results;
import studentCoursesMgmt.util.TheLogger;

/**
 * @author dedsec995
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

		Logger logger = new TheLogger(args[2], args[3],args[4],"registration_results.txt");
		Results result = new Results(args[2], args[3],args[4]);
		FileProcessor fp = new FileProcessor();
		Scheduling schedular = new Scheduling(args[0],args[1],fp,logger,result);
		schedular.schedule();
		// logger.logToRegResults("Logging to RegResults");
        // logger.logToRegConflicts("Logging to RegConflicts");

		/*   Waste Prints
		System.out.println("Hello World! Lets get started with the assignment");
		System.out.println("The arguments - " + args[0] + "  " + args[1] + "  " + args[2] + "  " + args[3] + "  " + args[4]);
		*/ 
	}
}

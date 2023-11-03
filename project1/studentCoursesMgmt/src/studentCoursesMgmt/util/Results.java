package studentCoursesMgmt.util;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
    private final String errorFile;
    private final String logRegResult;
    private final String logRegConflicts;

    public Results(String logRegResult, String logRegConflicts,String errorFile){
        this.logRegResult = logRegResult;
        this.logRegConflicts = logRegConflicts;
        this.errorFile = errorFile;
    }
    @Override
    public void DisplayIntermediateResult(String message) {
        System.out.println(message);
    }

    @Override
    public void DisplayFinalResult() {
        System.out.println("The final result");
    }

    @Override
    public void displayLoggedError(String message) {
        System.err.println("Error logged to " + errorFile + ": " + message);
    }
    @Override
    public void displayRegconflicts(String message) {
        System.out.println("Logged to " + logRegConflicts + ": " + message);
    }
    @Override
    public void DisplayLoggedToRegLogFile(String message) {
        System.out.println("Logged to " + logRegResult + ": " + message);
    }
    @Override
    public void displayLoggedError(String message, Exception x) {
        System.err.format("Exception: ", x);
        x.printStackTrace();
    }
    
	
}

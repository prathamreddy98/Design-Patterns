package studentCoursesMgmt.util;

public interface Logger {
    void logTheMessage(String logFileName, String message);
    void logToRegResults(String message);
    void logToRegConflicts(String message);
    void logError(String message);
    void logError(String message, Exception x);
    void writeToRegistrationResults(String result);
}

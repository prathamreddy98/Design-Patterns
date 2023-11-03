package studentCoursesMgmt.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The `TheLogger` class implements the Logger interface and provides a mechanism for logging various types of messages,
 * errors, and registration results to different log files. It supports appending log entries with timestamps.
 * 
 * This class is primarily used within a student courses management system to log information related to registration,
 * conflicts, errors, and registration results.
 * 
 * @author dedsec995
 * @version 0.3.2
 */

public class TheLogger implements Logger {
    private final String logRegResult;
    private final String logRegConflicts;
    private final String errorFile;
    private final String registrationResultsFile;

    /**
     * Constructs a new `TheLogger` instance with specified log file paths.
     *
     * @param logRegResult The path to the registration results log file.
     * @param logRegConflicts The path to the registration conflicts log file.
     * @param errorFile The path to the error log file.
     * @param registrationResultsFile The path to the registration results file.
     */

    public TheLogger(String logRegResult, String logRegConflicts, String errorFile, String registrationResultsFile) {
        this.logRegResult = logRegResult;
        this.logRegConflicts = logRegConflicts;
        this.errorFile = errorFile;
        this.registrationResultsFile = registrationResultsFile;
    }

    /**
     * Logs a message to a specified log file with a timestamp.
     * This is a generic method that other methods will call with their File they wish to log.
     * @param logFileName The path to the log file where the message will be logged.
     * @param message The message to be logged.
     * @return void Does not return anything.
     */

    @Override
    public void logTheMessage(String logFileName, String message) {
        try (FileWriter fileWriter = new FileWriter(logFileName, true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            printWriter.println(timestamp + " - " + message);
            // System.out.println("Logged to " + logFileName + ": " + message);
        } catch (IOException e) {
            System.err.println("Failed to log to " + logFileName + ": " + e.getMessage());
        }
    }

    /**
     * Logs an error message to the error log file with a timestamp.
     *
     * @param message The error message to be logged.
     * @return void
     */

    @Override
    public void logError(String message) {
        try (FileWriter fileWriter = new FileWriter(errorFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            printWriter.println(timestamp + " - Error: " + message);
            // System.out.println("Error logged to " + errorFile + ": " + message);
        } catch (IOException e) {
            System.err.println("Failed to log error: " + e.getMessage());
        }
    }

    @Override
    public void logToRegResults(String message) {
        logTheMessage(logRegResult, message);
    }

    @Override
    public void logToRegConflicts(String message) {
        logTheMessage(logRegConflicts, message);
    }

    /**
     * Writes a results to the registration results file.
     *
     * @param result The result to be written.
     * @return void
     */
    @Override
    public void writeToRegistrationResults(String result){
        try (FileWriter fileWriter = new FileWriter(registrationResultsFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(result);
        } catch (IOException e) {
            System.err.println("Failed to log error: " + e.getMessage());
        }
    }

    @Override
    public void logError(String message, Exception x) {
        try (FileWriter fileWriter = new FileWriter(errorFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter)) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            printWriter.println(timestamp + " - Error: " + message + x);
            // System.out.println("Error logged to " + errorFile + ": " + message);
        } catch (IOException e) {
            System.err.println("Failed to log error: " + e.getMessage());
        }
    }

}

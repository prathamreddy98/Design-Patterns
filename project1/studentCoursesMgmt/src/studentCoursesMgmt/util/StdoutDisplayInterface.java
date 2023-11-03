package studentCoursesMgmt.util;

public interface StdoutDisplayInterface {
	void displayLoggedError(String message);
    void displayLoggedError(String message, Exception x);
    void displayRegconflicts(String message);
}

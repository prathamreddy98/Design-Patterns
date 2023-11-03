package studentCoursesMgmt.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import studentCoursesMgmt.util.Courses;
import studentCoursesMgmt.util.FileProcessor;
import studentCoursesMgmt.util.Logger;
import studentCoursesMgmt.util.Student;
import studentCoursesMgmt.util.Results;

public class Scheduling {

    private final String coursePrefs;
    private final String courseInfo;
    private FileProcessor fp;
    private Logger logger;
    private Results results;

    public Scheduling(String coursePrefs, String courseInfo, FileProcessor fp, Logger logger, Results results) {
        this.coursePrefs = "src/coursePrefs/" + coursePrefs;
        this.courseInfo = "src/courseInfo/" + courseInfo;
        this.fp = fp;
        this.logger = logger;
        this.results = results;
    }

    public void schedule() {
        List<Student> students = new ArrayList<>();
        List<Courses> courses = new ArrayList<>();
        Pattern studentPattern = Pattern.compile(
                "(\\d{3})\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+)\\s+(\\S+);");
        Pattern coursePattern = Pattern.compile("([A-Za-z]):(\\d+):(\\d+)");
        double totalSatisfactionRating = 0;
        int totalStudents = 0;
        // logger.logToRegResults("The Result");
        // logger.logToRegConflicts("Lets have conflict");
        // logger.logError("The error");
        // results.DisplayIntermediateResult();
        // results.DisplayFinalResult();
        // results.DisplayLoggedToRegLogFile("The Result");
        // results.displayLoggedError("The error");
        // results.displayRegconflicts("Lets have conflict");

        // ----------------Read the coursePref File line by line and adding the data
        // into Student model-------------------------------
        try {
            fp.createReader(coursePrefs);
            String line;
            while ((line = fp.readNextLine()) != null) {
                Matcher matcher = studentPattern.matcher(line);
                if (matcher.find()) {
                    int studentId = Integer.parseInt(matcher.group(1));
                    String choice1 = matcher.group(2);
                    String choice2 = matcher.group(3);
                    String choice3 = matcher.group(4);
                    String choice4 = matcher.group(5);
                    String choice5 = matcher.group(6);
                    String choice6 = matcher.group(7);
                    String choice7 = matcher.group(8);
                    String choice8 = matcher.group(9);
                    String choice9 = matcher.group(10);

                    Student student = new Student(studentId, choice1, choice2, choice3, choice4, choice5, choice6,
                            choice7, choice8, choice9);
                    students.add(student);
                } else {
                    logger.logError("Input of coursePref does not match the expected format: " + line);
                    results.displayLoggedError("Input of coursePref does not match the expected format: " + line);
                }
                // System.out.println(line);
            }
        } catch (IOException x) {
            logger.logError("IOException: %s%n", x);
            results.displayLoggedError("IOException: %s%n", x);
            // System.err.format();
        }
        // -----------------------------------------------------------------------------------------------------------------------------------------------------

        // -----------------Read the courseInfo File line by line and adding the data
        // into Courses model--------------------------------------
        try {
            fp.createReader(courseInfo);
            String line;
            while ((line = fp.readNextLine()) != null) {
                Matcher matcher = coursePattern.matcher(line);
                if (matcher.find()) {
                    String courseName = matcher.group(1);
                    int capacity = Integer.parseInt(matcher.group(2));
                    int classTime = Integer.parseInt(matcher.group(3));
                    Courses course = new Courses(courseName, capacity, classTime);
                    courses.add(course);
                } else {
                    logger.logError("Input of courseInfo does not match the expected format: " + line);
                    results.displayLoggedError("Input of courseInfo does not match the expected format: " + line);
                }
                // System.out.println(line);
            }
        } catch (IOException x) {
            logger.logError("IOException: %s%n", x);
            results.displayLoggedError("IOException: %s%n", x);
        }
        // -----------------------------------------------------------------------------------------------------------------------------------------------------

        // For testing
        // for (Student student : students) {
        // System.out.println(student);
        // }
        // for (Courses course : courses) {
        // System.out.println(course);
        // }

        // Iterate through each student
        for (Student student : students) {
            List<String> assignedCourses = new ArrayList<>(); // To store assigned courses
            int satisfactionRating = 0;
            int allocatedCourse = 0;
            // Iterate through the student's course choices
            for (int i = 1; i <= 9; i++) {
                try {
                    String methodName = "getChoice" + i;
                    Method method = Student.class.getMethod(methodName);
                    String choice = (String) method.invoke(student);

                    // Check if the course choice is valid and has available seats
                    for (Courses course : courses) {
                        if (allocatedCourse >= 3) {
                            break;
                        }
                        if (course.getCourseName().equals(choice)) {
                            if (course.getCapacity() > 0) {
                                // Check for time conflicts with already assigned courses
                                boolean hasTimeConflict = false;
                                for (String assignedCourse : assignedCourses) {
                                    Courses assigned = getCourseByName(assignedCourse, courses);
                                    if (assigned != null && assigned.getClassTime() == course.getClassTime()) {
                                        hasTimeConflict = true;
                                        break;
                                    }
                                }

                                if (!hasTimeConflict) {
                                    // Assign the course to the student
                                    assignedCourses.add(choice);
                                    allocatedCourse++;
                                    course.setCapacity(course.getCapacity() - 1);
                                    // Calculate satisfaction rating
                                    satisfactionRating += (10 - i);
                                    logger.logToRegResults(
                                            "Assigned course " + choice + " to student " + student.getStudentId());
                                    results.DisplayIntermediateResult(
                                            "Assigned course " + choice + " to student " + student.getStudentId());
                                    break; // Break out of the course loop
                                } else {
                                    logger.logToRegConflicts(
                                            "Course " + choice + " has a time conflict and was not assigned to student "
                                                    + student.getStudentId());
                                    results.DisplayIntermediateResult("Course " + choice
                                            + " has a time conflict and was not assigned to student "
                                            + student.getStudentId() + " and this has been logged into the file");
                                }
                            } else {
                                logger.logError("Course " + choice + " is not assigned as seats are full for student "
                                        + student.getStudentId());
                                results.displayLoggedError(
                                        "Course " + choice + " is not assigned as seats are full for student "
                                                + student.getStudentId() + " and this has been logged to error file ");
                            }
                        }
                    }
                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    logger.logError("Error", e);
                    results.displayLoggedError("Error", e);
                    // e.printStackTrace();
                }
            }
            totalSatisfactionRating += (double) satisfactionRating / assignedCourses.size();
            totalStudents++;
            StringBuilder output = new StringBuilder();
            output.append(student.getStudentId()).append(":");
            for (int j = 0; j < assignedCourses.size(); j++) {
                output.append(assignedCourses.get(j));
                if (j < assignedCourses.size() - 1) {
                    output.append(",");
                }
            }
            output.append("::SatisfactionRating=")
                    .append(String.format("%.2f", (double) satisfactionRating / assignedCourses.size()));
            String result = output.toString();
            logger.writeToRegistrationResults(result);
            results.DisplayIntermediateResult(result);
        }
        if (totalStudents > 0) {
            double averageSatisfactionRating = (double) totalSatisfactionRating / totalStudents;
            logger.writeToRegistrationResults("AverageSatisfactionRating: " + String.format("%.2f", averageSatisfactionRating));
            results.DisplayIntermediateResult("AverageSatisfactionRating: " + String.format("%.2f", averageSatisfactionRating));
        } else {
            logger.logError("No students found to calculate the average satisfaction rating.");
            results.displayLoggedError("No students found to calculate the average satisfaction rating.");
        }
    }

    private Courses getCourseByName(String name, List<Courses> courses) {
        for (Courses course : courses) {
            if (course.getCourseName().equals(name)) {
                return course;
            }
        }
        return null;
    }

}

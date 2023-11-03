package studentCoursesMgmt.util;

public class Courses {
    private String courseName;
    private int capacity;
    private int classTime;

    public Courses(String courseName, int capacity, int classTime) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.classTime = classTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getClassTime() {
        return classTime;
    }

    public void setClassTime(int classTime) {
        this.classTime = classTime;
    }

    @Override
    public String toString() {
        return courseName + " " + capacity + " " + classTime;
    }
}

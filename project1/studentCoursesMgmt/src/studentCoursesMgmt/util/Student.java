package studentCoursesMgmt.util;

public class Student {
    private int studentId;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;
    private String choice5;
    private String choice6;
    private String choice7;
    private String choice8;
    private String choice9;

    public Student(int studentId, String choice1, String choice2, String choice3, String choice4, String choice5, String choice6, String choice7, String choice8, String choice9) {
        this.studentId = studentId;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
        this.choice5 = choice5;
        this.choice6 = choice6;
        this.choice7 = choice7;
        this.choice8 = choice8;
        this.choice9 = choice9;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getChoice1() {
        return choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public String getChoice5() {
        return choice5;
    }

    public String getChoice6() {
        return choice6;
    }

    public String getChoice7() {
        return choice7;
    }

    public String getChoice8() {
        return choice8;
    }

    public String getChoice9() {
        return choice9;
    }

    @Override
    public String toString() {
        return studentId + " " + choice1 + " " + choice2 + " " + choice3 + " " + choice4 + " " + choice5 + " " + choice6 + " " + choice7 + " " + choice8 + " " + choice9;
    }
}
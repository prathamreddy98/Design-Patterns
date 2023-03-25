package myCampusTour.myTour;

public enum EnumLecture {
    CS542_INPERSON("Attend lecture in person"),
    CS540_ONLINE("Attend lecture online");
    private String lecture;
    private EnumLecture(String attend_lecture) {
        lecture = attend_lecture;
    }
    public String get_lecture_info() {
        return lecture;
    }
}

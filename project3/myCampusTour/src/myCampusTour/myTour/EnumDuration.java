package myCampusTour.myTour;

public enum EnumDuration {
    BUILDINGS_VISIT(10),
    WALKING(15),
    BUS(3),
    PICKING_GIFT(5),
    CAFE_WAIT(24),
    CAFE_ONLINE(12),
    LECTURE(90);
    private int duration;
    private EnumDuration(int time) {
        duration = time;
    }
    public int get_duration() {
        return duration;
    }

}

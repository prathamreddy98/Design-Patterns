package myCampusTour.myTour;

public enum EnumPrice {
    WALKING(1.0),
    BUS(3.0),
    EVENT_CENTER(15),
    UNIVERSITY_UNION(10),
    CIW(10),
    MOUNTAIN_VIEW(10.5),
    ATTEND_LEC_CS542(20.0),
    VIDEO_STREAM_CS540(22.0);
    private double costs;
    private EnumPrice(double costing) {
        costs=costing;
    }
    public double getCost() {
        return costs;
    }
}

package myCampusTour.myTour;

public enum EnumEffortCalories {
    WALKING(300),
    BUS(10),
    BUILDINGS_VISIT(100),
    PICKING_GIFT(50),
    CIW_WAIT(25),
    MW_WAIT(10),
    ATTEND_LEC(30);
    private int efforts;
    private EnumEffortCalories(int effortsMeasure) {
        efforts = effortsMeasure;
    }

    public int getEffortsValue() {
        return efforts;
    }
}

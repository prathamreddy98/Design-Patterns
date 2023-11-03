package myCampusTour.myTour;

public enum EnumCarbonFootprint {
    BUS(0.3),
    GIFT_CENTER(0.2),
    CAFE(0.3),
    LECTURE_HALL(0.2),
    LECTURE_ONLINE(0.1),
    BUILDINGS(0.1);
    private double carbon_footprint;
    private EnumCarbonFootprint(double carbon) {
        carbon_footprint=carbon;
    }    

    public double get_carbon_footprint() {
        return carbon_footprint;
    }

}

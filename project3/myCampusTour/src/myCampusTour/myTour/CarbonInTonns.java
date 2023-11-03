package myCampusTour.myTour;

public class CarbonInTonns implements CarbonFootprintI {

    public double get_carbon_footprint(EnumCarbonFootprint carbon) {
        return carbon.get_carbon_footprint();
    }

}

package myCampusTour.TourActivity;

import java.util.ArrayList;

import myCampusTour.myTour.EnumBuilding;

public class VisitingBuildings {
    public ArrayList<EnumBuilding> buildings;
    double visiting_cost;
    double transportation_cost;
    int visiting_duration;
    int transport_duration;
    int visiting_calories;
    int transportation_calories;
    double visiting_co2;
    double transport_co2;


    public VisitingBuildings(
        ArrayList<EnumBuilding> buildings_list,
        double visitingcost,
        double transportationcost,
        int visitingduration,
        int transportduration,
        int visitingcalories,
        int transportcalories,
        double visitingco2,
        double transportco2
    ) {
        buildings=buildings_list;
        visiting_cost = visitingcost;
        transportation_cost = transportationcost;
        visiting_duration = visitingduration;
        transport_duration = transportduration;
        visiting_calories = visitingcalories;
        transportation_calories = transportcalories;
        visiting_co2 = visitingco2;
        transport_co2 = transportco2;
    }

    public double getTotalVisitCost() {
        return visiting_cost + transportation_cost; 
    }

    public int getTotalCalories() {
        return visiting_calories + transportation_calories;
    }

    public int getTotalDuration() {
        return visiting_duration + transport_duration;
    }

    public double getTotalCO2() {
        return visiting_co2 + transport_co2;
    }

}

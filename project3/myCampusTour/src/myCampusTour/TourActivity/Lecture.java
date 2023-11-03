package myCampusTour.TourActivity;

import myCampusTour.myTour.EnumLecture;

public class Lecture {
    public EnumLecture lecture;
    double lec_cost;
    int lec_duration;
    int lec_calories;
    double lec_co2;

    public Lecture(
        EnumLecture attend,
        double shopcost,
        int shopduration,
        int shopcalories,
        double shopco2
    ) {
        lecture=attend;
        lec_cost = shopcost;
        lec_duration = shopduration;
        lec_calories = shopcalories;
        lec_co2 = shopco2;
    }

    public double getLecCost() {
        return lec_cost; 
    }

    public int getTotalCalories() {
        return lec_calories;
    }

    public int getTotalDuration() {
        return lec_duration;
    }

    public double getTotalCO2() {
        return lec_co2;
    }
}

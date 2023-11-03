package myCampusTour.TourActivity;

import myCampusTour.myTour.EnumBuilding;

public class EatLunch {
    public EnumBuilding cafe;
    double lunch_cost;
    int lunch_duration;
    int lunch_calories;
    double lunch_co2;

    public EatLunch(
        EnumBuilding cafeshop,
        double shopcost,
        int shopduration,
        int shopcalories,
        double shopco2
    ) {
        cafe=cafeshop;
        lunch_cost = shopcost;
        lunch_duration = shopduration;
        lunch_calories = shopcalories;
        lunch_co2 = shopco2;
    }

    public double getLunchCost() {
        return lunch_cost; 
    }

    public int getTotalCalories() {
        return lunch_calories;
    }

    public int getTotalDuration() {
        return lunch_duration;
    }

    public double getTotalCO2() {
        return lunch_co2;
    }
}

package myCampusTour.TourActivity;

import myCampusTour.myTour.EnumBuilding;

public class ShoppingGift {
    public EnumBuilding shop;
    double gift_cost;
    int shop_duration;
    int shop_calories;
    double shop_co2;

    public ShoppingGift(
        EnumBuilding giftshop,
        double shopcost,
        int shopduration,
        int shopcalories,
        double shopco2
    ) {
        shop=giftshop;
        gift_cost = shopcost;
        shop_duration = shopduration;
        shop_calories = shopcalories;
        shop_co2 = shopco2;
    }

    public double getGiftCost() {
        return gift_cost; 
    }

    public int getTotalCalories() {
        return shop_calories;
    }

    public int getTotalDuration() {
        return shop_duration;
    }

    public double getTotalCO2() {
        return shop_co2;
    }
}

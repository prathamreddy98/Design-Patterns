package myCampusTour.builderWorkshop;

import java.util.ArrayList;
import myCampusTour.TourActivity.EatLunch;
import myCampusTour.TourActivity.Lecture;
import myCampusTour.TourActivity.ShoppingGift;
import myCampusTour.TourActivity.VisitingBuildings;
import myCampusTour.myTour.CarbonInTonns;
import myCampusTour.myTour.CostInDollar;
import myCampusTour.myTour.DurationTime;
import myCampusTour.myTour.EffortCalories;
import myCampusTour.myTour.EnumBuilding;
import myCampusTour.myTour.EnumCarbonFootprint;
import myCampusTour.myTour.EnumDuration;
import myCampusTour.myTour.EnumEffortCalories;
import myCampusTour.myTour.EnumLecture;
import myCampusTour.myTour.EnumPrice;
import myCampusTour.myTour.EnumTravel;

public class CampusTourIterinary extends TourIterinary {

    ArrayList<EnumBuilding> buildingsList;
    EnumTravel travel_option;
    EnumBuilding gift_shop;
    EnumBuilding dining;
    EnumLecture lecture;
    CostInDollar costInDollar = new CostInDollar();
    EffortCalories efforts = new EffortCalories();
    CarbonInTonns carbonTonnes = new CarbonInTonns();
    DurationTime duration = new DurationTime();

    VisitingBuildings visiting_buildings;
    ShoppingGift shopping_gift;
    EatLunch eat_lunch;
    Lecture lecture_attend;

    /**
     * @param buildings - To visit two buildings SOM and Watson
     * @param travellingOptions - Bus and on foot
     * @param giftshop - Collect gift from Event center or union
     * @param dining_hall- CIW or Mountain View
     * @param attend_lecture - CS 542 inperson or CS540 online
     * CarbonFootprint, effort and cost is there for each activities
     */
    public CampusTourIterinary(ArrayList<EnumBuilding> buildings, EnumTravel travellingOptions, EnumBuilding giftshop, 
    EnumBuilding dining_hall, EnumLecture attend_lecture) {
        buildingsList = buildings;
        travel_option = travellingOptions;
        gift_shop = giftshop;
        dining=dining_hall;
        lecture = attend_lecture;
    }

    public void school_buildings_visit() {
        
        double transport_cost = 0.0;
        int transportation_calories = 0;
        int transport_duration=0;
        double transport_co2 = 0.0;

        if(travel_option == EnumTravel.WALKING) {
           
            transport_cost = costInDollar.get_cost(EnumPrice.WALKING);
           
            transportation_calories = efforts.getCalories(EnumEffortCalories.WALKING);
            
            transport_duration = duration.get_duration(EnumDuration.WALKING);
            transport_co2 = 0.0;
        } else {
           
            transport_cost = costInDollar.get_cost(EnumPrice.BUS);
           
            transportation_calories = efforts.getCalories(EnumEffortCalories.WALKING);
            
            transport_duration = duration.get_duration(EnumDuration.BUS);
            transport_co2 = carbonTonnes.get_carbon_footprint(EnumCarbonFootprint.BUS);
        }

        double visiting_cost = 0.0;
        int visitin_calories = (2*efforts.getCalories(EnumEffortCalories.BUILDINGS_VISIT));
        double visitin_co2 = (2*carbonTonnes.get_carbon_footprint(EnumCarbonFootprint.BUILDINGS));
        int visitin_duration = (2* duration.get_duration(EnumDuration.BUILDINGS_VISIT));

        visiting_buildings = new VisitingBuildings(buildingsList, visiting_cost, transport_cost, visitin_duration, transport_duration, visitin_calories, transportation_calories, visitin_co2, transport_co2);
    

    }

    public void gift_shopping() {
        double giftcost=0.0;
        if(gift_shop == EnumBuilding.EVENTS_CENTER) {
        giftcost = costInDollar.get_cost(EnumPrice.EVENT_CENTER);
        } else if(gift_shop == EnumBuilding.UNIVERSITY_UNION) {
            giftcost = costInDollar.get_cost(EnumPrice.UNIVERSITY_UNION);
        }
        
        int giftcalories = efforts.getCalories(EnumEffortCalories.PICKING_GIFT);
        double giftco2 = carbonTonnes.get_carbon_footprint(EnumCarbonFootprint.GIFT_CENTER);
        int giftduration = duration.get_duration(EnumDuration.PICKING_GIFT);

        shopping_gift = new ShoppingGift(gift_shop, giftcost, giftduration, giftcalories, giftco2);

    }

    public void eat_lunch() {
        double costlunch=0.0;
        int lunchcalories = 0;
        int lunchwait = 0;
        if(dining == EnumBuilding.CIW) {
            costlunch = costInDollar.get_cost(EnumPrice.CIW);
            lunchcalories = efforts.getCalories(EnumEffortCalories.CIW_WAIT);
            lunchwait = duration.get_duration(EnumDuration.CAFE_WAIT);
        } else if(dining == EnumBuilding.MOUNTAIN_VIEW) {
            costlunch = costInDollar.get_cost(EnumPrice.MOUNTAIN_VIEW);
            lunchcalories = efforts.getCalories(EnumEffortCalories.MW_WAIT);
            lunchwait = duration.get_duration(EnumDuration.CAFE_ONLINE);
        }

        double carO2 = carbonTonnes.get_carbon_footprint(EnumCarbonFootprint.CAFE);
                
        eat_lunch = new EatLunch(dining, costlunch, lunchwait, lunchcalories, carO2);
    }

    public void go_to_lecture() {
        double costing=0.0;
        double co2=0.0;

        if(lecture == EnumLecture.CS542_INPERSON) {
            costing = costInDollar.get_cost(EnumPrice.ATTEND_LEC_CS542);
            co2 = carbonTonnes.get_carbon_footprint(EnumCarbonFootprint.LECTURE_HALL);
        } else {
            costing = costInDollar.get_cost(EnumPrice.VIDEO_STREAM_CS540);
        }   co2 = carbonTonnes.get_carbon_footprint(EnumCarbonFootprint.LECTURE_ONLINE);
    
        int calories = efforts.getCalories(EnumEffortCalories.ATTEND_LEC);
        
        int timing = duration.get_duration(EnumDuration.LECTURE);

        lecture_attend = new Lecture(lecture, costing, timing, calories, co2);
    }

    public void printing_result() {
        System.out.println("a. Visiting buildings");
        for(int i=0;i<visiting_buildings.buildings.size();i++) {
            System.out.println(
                "\t" + (i+1) + ". " + visiting_buildings.buildings.get(i).getBuilding()
            );
        }

        System.out.println(
            "Travelling by: \n"+ "\t" +travel_option
        );

        System.out.println("b. Shopping gift at");
        System.out.println(
            "\t1. " + shopping_gift.shop.getBuilding()
        );

        System.out.println("c. Eating lunch at");
        System.out.println(
            "\t1. " + eat_lunch.cafe.getBuilding()
        );

        System.out.println("d. Attend lecture");
        System.out.println(
            "\t1. " + lecture_attend.lecture.get_lecture_info()
        );

        System.out.println(
            "Total Tour Cost: $" + calculateTotalCost() 
        );

        System.out.println(
            "Total Tour Calories burn: " + calculateCalories() 
        );

        System.out.println(
            "Total Tour Duration: " + calculateDuration() 
        );

        System.out.println(
            String.format("Total Tour CO2: %.2f",calculateCO2())
        );

    }

    public double calculateTotalCost() {
        double sum=visiting_buildings.getTotalVisitCost() + shopping_gift.getGiftCost() + eat_lunch.getLunchCost() + lecture_attend.getLecCost();
        return sum;
    }

    public double calculateCO2() {
        double sum=visiting_buildings.getTotalCO2()+shopping_gift.getTotalCO2()+eat_lunch.getTotalCO2()+lecture_attend.getTotalCO2();
        return sum;
    }

    public int calculateCalories() {
        int sum = visiting_buildings.getTotalCalories()+shopping_gift.getTotalCalories()+eat_lunch.getTotalCalories()+lecture_attend.getTotalCalories();
        return sum;
    }

    public int calculateDuration() {
        int sum=visiting_buildings.getTotalDuration()+shopping_gift.getTotalDuration()+eat_lunch.getTotalDuration()+lecture_attend.getTotalDuration();
        return sum;
    }

}

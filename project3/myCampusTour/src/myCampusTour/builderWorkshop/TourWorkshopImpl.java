package myCampusTour.builderWorkshop;

import myCampusTour.builderWorkshop.TourIterinary;
import myCampusTour.util.MyLogger;
import myCampusTour.util.MyLogger.DebugLevel;

public class TourWorkshopImpl implements BuilderWorkshopI {

    /* 
     *  Class to construct the Tour itenary
     */
    public void construct(TourIterinary tourItenirary) {

        MyLogger.writeMessage("Inside TourWorkshopImpl calling the construct method", DebugLevel.TOUR);

        tourItenirary.school_buildings_visit();
        tourItenirary.gift_shopping();
        tourItenirary.eat_lunch();
        tourItenirary.go_to_lecture();
        tourItenirary.printing_result();
    }
}

package myCampusTour.myTour;

public class EffortCalories implements EffortI {

    public int getCalories(EnumEffortCalories efforts) {
        return efforts.getEffortsValue();
    }
    
}

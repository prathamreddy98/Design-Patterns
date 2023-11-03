package myCampusTour.myTour;

public class CostInDollar implements CostI {
   
    
    public double get_cost(EnumPrice costs){

        return costs.getCost();
    }
    
}

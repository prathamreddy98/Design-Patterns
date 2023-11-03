package myCampusTour.driver;

import java.util.ArrayList;

import myCampusTour.builderWorkshop.BuilderWorkshopI;
import myCampusTour.builderWorkshop.CampusTourIterinary;
import myCampusTour.builderWorkshop.TourWorkshopImpl;
import myCampusTour.myTour.EnumBuilding;
import myCampusTour.myTour.EnumLecture;
import myCampusTour.myTour.EnumTravel;
import myCampusTour.util.MyLogger;

/**
 * @author placeholder
 *
 */
public class Driver {
	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */

	    if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}")) {

			System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
			System.exit(0);
		}
		
		System.out.println("Hello World! Lets get started with the assignment");

		try {
			MyLogger.setDebugValue(Integer.parseInt(args[1]));
		} catch (NumberFormatException errorNumber) {
			System.out.println(errorNumber);
		}

		ArrayList<EnumBuilding> buildings = new ArrayList<EnumBuilding>();

		buildings.add(EnumBuilding.WATSON);
		buildings.add(EnumBuilding.SOM);

		CampusTourIterinary tourItenirary = new CampusTourIterinary(buildings, EnumTravel.BUS, EnumBuilding.UNIVERSITY_UNION, EnumBuilding.CIW, EnumLecture.CS542_INPERSON);
		TourWorkshopImpl tourWorkshpopImpl = new TourWorkshopImpl();
		tourWorkshpopImpl.construct(tourItenirary);

		CampusTourIterinary tourItenirary1 = new CampusTourIterinary(buildings, EnumTravel.WALKING, EnumBuilding.EVENTS_CENTER, EnumBuilding.MOUNTAIN_VIEW, EnumLecture.CS540_ONLINE);
		TourWorkshopImpl tourWorkshpopImpl1 = new TourWorkshopImpl();
		tourWorkshpopImpl1.construct(tourItenirary1);

	}
}

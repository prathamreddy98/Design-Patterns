package myCampusTour.myTour;

public enum EnumBuilding {
    WATSON("Watson building"),
    SOM("School of Managment building"),
    BARTLE_LIBRARY("Bartle Library"),
    ANDERSON_CTR("Anderson canter"),
    BING_PHARMACY("Binghamton Pharmacy building"),
    CIW("College in the woods dining hall"),
    MOUNTAIN_VIEW("Mountain View dining hall"),
    EVENTS_CENTER("Events Center gift shop"),
    UNIVERSITY_UNION("University Union gift shop");
    private String buildingName;

    private EnumBuilding(String buildName) {
        buildingName=buildName;
    }

    public String getBuilding() {
        return buildingName;
    }

}

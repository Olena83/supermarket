package supermarketNew;


import java.util.HashMap;
import java.util.Map;

import static supermarketNew.WashServices.*;

public class PassengerCar extends Car {
    //make a Map of services and prices
    private Map<String, Integer> services;
    private Map.Entry<String, Integer> service;

    //make a constructor that is creating services map
    public PassengerCar() {
        services = new HashMap<>();
        services.put(WashWithWater.name(), 150);
        services.put(WashWithFoam.name(), 250);
        services.put(EngineWashing.name(), 200);
        services.put(WaxCovering.name(), 500);
        services.put(Drying.name(), 0);
        services.put(FloorCarpetWashing.name(), 50);
        services.put(SalonCleaning.name(), 300);
    }

    //print in console services that are available for this type of car
    public String getServices() {
        String passCarServices = "Services for passenger car: ";
        for (Map.Entry<String, Integer> entry : services.entrySet()) {
            if (entry.getValue().equals(0)) {
                passCarServices = passCarServices + '\n' + entry.getKey() + " This service is temporally unavailable";
            } else
                passCarServices = passCarServices + '\n' + entry.getKey() + " " + entry.getValue() + " UAH";
        }
        return passCarServices;
    }
    // this method is to set entries to the receipt
    public Map.Entry<String, Integer> getService() {
        return service;
    }
    //check is service from input exist and ready to use
    public Boolean serviceCheck(String inputLine){
        Boolean serviceForThisCar = false;
        for (Map.Entry<String, Integer> entry : services.entrySet()) {
            if (entry.getKey().toLowerCase().equals(inputLine.replaceAll("\\s+", "").toLowerCase())) {
                serviceForThisCar = true;

                if (entry.getValue().equals(0)) {
                    serviceForThisCar = null;
                } else {
                    this.service = entry;
                }
                break;
            }
        }
        return serviceForThisCar;
    }
}
package supermarketNew;

import java.util.HashMap;
import java.util.Map;

public class AdditionalServices {
    private Map<String, Integer> addServices;
    private Map.Entry<String, Integer> addService;

    public AdditionalServices() {
        addServices = new HashMap<>();
        for (supermarketNew.Services additionalService : supermarketNew.Services.values()) {
            addServices.put(additionalService.name(), additionalService.getAddPrice());
        }
    }

    public String getAdditionalServices() {
        String additionalServices = "Additional services: ";
        for (Map.Entry<String, Integer> entry : addServices.entrySet()) {
            if (entry.getValue().equals(0)) {
                additionalServices = additionalServices + '\n' + entry.getKey() + " This service is temporally unavailable";
            } else
                additionalServices = additionalServices + '\n' + entry.getKey() + " " + entry.getValue() + " UAH";
        }
        return additionalServices;
    }

    public Map.Entry<String, Integer> getAddService() {
        return addService;
    }

    public Boolean addServiceCheck(String inputLine){
        Boolean addedService = false;
        for (Map.Entry<String, Integer> entry : addServices.entrySet()) {
            if (entry.getKey().toLowerCase().equals(inputLine.replaceAll("\\s+", "").toLowerCase())) {
                addedService = true;
                if (entry.getValue().equals(0)) {
                    addedService = null;
                } else {
                    this.addService = entry;
                }
                break;
            }
        }
        return addedService;
    }
}
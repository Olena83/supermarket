package supermarketNew;

import java.util.Map;

public class Car {
    private Map.Entry<String, Integer> service;
    public String getServices(){
        String answer = "You have to choose the type of car to see all services";
        return answer;
    }
    public Boolean serviceCheck(String inputLine){
        System.out.println("You didn't choose any car, so you can't choose a service");
        return false;
    }
    public Map.Entry<String, Integer> getService() {
        return service;
    }
}

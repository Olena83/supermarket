package supermarketNew;

import java.util.HashMap;
import java.util.Map;

public class Receipt {
    //This is receipt of services that client chose
    private Map<String, Integer> receipt;

    //constructor that creates receipt map we need
    public Receipt() {
        receipt = new HashMap<>();
    }

    //method is using to put services that client chose in receipt map
    public void putInReceipt(Map.Entry<String, Integer> inReceiptEntry){
        String service = inReceiptEntry.getKey();
        Integer price = inReceiptEntry.getValue();
        if (receipt.containsKey(service)){
            Integer newPrice = receipt.get(service) + price;
            receipt.replace(service, newPrice);
        } else {
            receipt.put(service, price);
        }
    }
    // Method returns Receipt in String
    public String getReceipt() {
        String thisReceipt = "";
        if (receipt.isEmpty()){
            thisReceipt = "Your receipt is empty";
            return thisReceipt;
        } else
            for (Map.Entry<String, Integer> entry : receipt.entrySet()){
                thisReceipt = thisReceipt + entry.getKey() + " " + entry.getValue() + " UAH" + '\n';
            }
        return thisReceipt;
    }
    //This method have to sum all prices in 1 class( for 1 car)
    public int totalPrice(){
        int sum;
        if (receipt.isEmpty()){
            sum = 0;
        } else {
            sum = receipt.values().stream()
                    .mapToInt(i -> i)
                    .sum();
        }
        return sum;

    }
    public void clearReceipt(){
        receipt.clear();
    }

}

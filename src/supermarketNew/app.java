package supermarketNew;




import java.util.Arrays;
import java.util.Scanner;

import static supermarketNew.CarsTypes.Carvan;
import static supermarketNew.CarsTypes.Motorcycle;
import static supermarketNew.CarsTypes.PassengerCar;
import static supermarketNew.CarsTypes.SUV;
import static supermarketNew.CarsTypes.Truck;
import static supermarketNew.CarsTypes.*;
import static supermarketNew.Condition.*;
import static supermarketNew.Messages.*;


public class app {
    public static void main(String[] args) {
        String marker = CarChoosing.name();
        String input = " ";
        Car chosenCar = new Car();
        Receipt receipt = new Receipt();
        AdditionalServices additionalServices;

        System.out.println(HELLO);
        do {
            Scanner scanner = new Scanner(System.in);
            if (marker.equals(CarChoosing.name())) {
                System.out.printf(CHOOSE_CAR, Arrays.toString(CarsTypes.values()));
                input = scanner.nextLine();
                do {
                    if (isEqual("quit", input) || isEqual("q", input)) {
                        System.out.printf(BYE, receipt.getReceipt(), receipt.totalPrice());
                        break;
                    }
                    if (isEqual("Receipt", input)) {
                        System.out.printf(RECEIPT, receipt.getReceipt());
                        break;
                    }
                    if (isEqual(PassengerCar, input) || isEqual(Carvan, input) || isEqual(Motorcycle, input) ||
                            isEqual(SUV, input) || isEqual(Truck, input)) {
                        marker = ServiceChoosing.name();
                        System.out.println("You choose " + input.replaceAll("\\s+", ""));
                        break;
                    } else if (isEqual(HeavyDutyWehicles, input)) {
                        System.out.println(UNAVAILABLE);
                        break;
                    } else {
                        System.out.println(INCORRECT);
                        break;
                    }
                } while (marker.equals(CarChoosing.name()));
            }
            if (marker.equals(ServiceChoosing.name())) {
                if (isEqual(PassengerCar, input)) {
                    chosenCar = new PassengerCar();
                } else if (isEqual(Carvan, input)) {
                    chosenCar = new Carvan();
                } else if (isEqual(Motorcycle, input)) {
                    chosenCar = new Motorcycle();
                } else if (isEqual(SUV, input)) {
                    chosenCar = new SUV();
                } else if (isEqual(Truck, input)) {
                    chosenCar = new Truck();
                }
                marker = ReceiptSetting.name();
            }
            if (marker.equals(ReceiptSetting.name())) {
                System.out.printf(SERVICES, chosenCar.getServices());
                input = scanner.nextLine();
                do {
                    if (isEqual("quit", input) || isEqual("q", input)) {
                        System.out.printf(BYE, receipt.getReceipt(), receipt.totalPrice());
                        break;
                    }
                    if (isEqual("Back", input)) {
                        marker = CarChoosing.name();
                        continue;
                    }
                    if (isEqual("Receipt", input)) {
                        System.out.printf(RECEIPT, receipt.getReceipt());
                        break;
                    }
                    if (chosenCar.serviceCheck(input) == null) {
                        System.out.println(UNAVAILABLE);
                        break;
                    } else if (chosenCar.serviceCheck(input)) {
                        marker = MoreOptionsChoosing.name();
                        receipt.putInReceipt(chosenCar.getService());
                        System.out.println(ADD_TO_RECEIPT);
                    } else
                        System.out.println(INCORRECT);
                    break;
                } while (marker.equals(ReceiptSetting.name()));
            }
            if (marker.equals(MoreOptionsChoosing.name())) {
                System.out.println(MORE_OPTIONS);
                input = scanner.nextLine();
                switch (input) {
                    case "yes":
                    case "Yes":
                        marker = ReceiptSetting.name();
                        break;
                    case "No":
                    case "no":
                        marker = AdditionalServiceChoosing.name();
                        break;
                    case "Back":
                    case "back":
                        marker = ReceiptSetting.name();
                        break;
                    case "Quit":
                    case "quit":
                    case "q":
                    case "Q":
                        System.out.printf(BYE, receipt.getReceipt(), receipt.totalPrice());
                        break;
                    case "Receipt":
                    case "receipt":
                        System.out.printf(RECEIPT, receipt.getReceipt());
                        break;
                    default:
                        System.out.println(INCORRECT);
                        break;
                }
            }
            if (marker.equals(AdditionalServiceChoosing.name())) {
                additionalServices = new AdditionalServices();
                System.out.printf(ADD_SERVICES, additionalServices.getAdditionalServices());
                input = scanner.nextLine();
                do {
                    if (isEqual("quit", input) || isEqual("q", input)) {
                        System.out.printf(BYE, receipt.getReceipt(), receipt.totalPrice());
                        break;
                    }
                    if (isEqual("Back", input)) {
                        marker = ReceiptSetting.name();
                        continue;
                    }
                    if (isEqual("No", input)) {
                        marker = OrderConfirm.name();
                        continue;
                    }
                    if (isEqual("Receipt", input)) {
                        System.out.printf(RECEIPT, receipt.getReceipt());
                        break;
                    }
                    if (additionalServices.addServiceCheck(input) == null) {
                        System.out.println(UNAVAILABLE);
                        break;
                    } else if (additionalServices.addServiceCheck(input)) {
                        marker = MoreAddOptionsChoosing.name();
                        receipt.putInReceipt(additionalServices.getAddService());
                        System.out.println(ADD_TO_RECEIPT);
                    } else
                        System.out.println(INCORRECT);
                    break;
                } while (marker.equals(AdditionalServiceChoosing.name()));
            }
            if (marker.equals(MoreAddOptionsChoosing.name())) {
                System.out.println(MORE_OPTIONS);
                input = scanner.nextLine();
                switch (input) {
                    case "yes":
                    case "Yes":
                        marker = AdditionalServiceChoosing.name();
                        break;
                    case "No":
                    case "no":
                        marker = OrderConfirm.name();
                        break;
                    case "Back":
                    case "back":
                        marker = AdditionalServiceChoosing.name();
                        break;
                    case "Quit":
                    case "quit":
                    case "q":
                    case "Q":
                        System.out.printf(BYE, receipt.getReceipt(), receipt.totalPrice());
                        break;
                    case "Receipt":
                    case "receipt":
                        System.out.printf(RECEIPT, receipt.getReceipt());
                        break;
                    default:
                        System.out.println(INCORRECT);
                        break;
                }
            }
            if (marker.equals(OrderConfirm.name())) {
                System.out.printf(ORDER_CONFIRM, receipt.getReceipt());
                input = scanner.nextLine();
                switch (input) {
                    case "Yes":
                    case "yes":
                        marker = END.name();
                        break;
                    case "No":
                    case "no":
                        receipt.clearReceipt();
                        marker = CarChoosing.name();
                        break;
                    case "Back":
                    case "back":
                        marker = AdditionalServiceChoosing.name();
                        break;
                    case "Quit":
                    case "quit":
                        System.out.printf(BYE, receipt.getReceipt(), receipt.totalPrice());
                        break;
                    default:
                        System.out.println(INCORRECT);
                        break;
                }
            }
            if (marker.equals(END.name())) {
                System.out.printf(BYE, receipt.getReceipt(), receipt.totalPrice());
                input = "quit";
            }
        } while (!(isEqual("quit", input) || isEqual("q", input)));
    }

    //checking equals of standard values and input data
    private static boolean isEqual(Object stringOrEnum, String inputLine) {
        boolean equal = false;
        if (stringOrEnum.toString().toLowerCase().equals(inputLine.replaceAll("\\s+", "").toLowerCase()))
            equal = true;
        return equal;
    }
}
package supermarket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import static supermarket.Message.*;
import static supermarket.Stage.*;
import static supermarket.Price.*;

public class appmarket  {
    public static void main(String[] args) throws IOException {
        double sum = 0;
        Stage stage = WELCOME;
        String input = null;
        double quantity = 0;



        System.out.println(welcome);
        do {BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            if (stage.equals(WELCOME)){
                System.out.println(departs);
                input = bufferedReader.readLine();
                switch(input){
                    case "f":
                        stage = SALE;
                        break;
                    case "n":
                        stage = SALE;
                        break;
                    case "r":
                        stage = SALE;
                        break;
                    case "q":

                        break;
                    default:
                        System.out.println(incorrect_welcome);
                        stage = WELCOME;
                        break;
                }
            }
            else if (stage.equals(SALE)){
                switch (input) {
                    case "f":
                        System.out.println(food_assortment);
                        input = bufferedReader.readLine();
                        stage = FOOD;
                        break;
                    case "n":
                        System.out.println(beverage_assortment);
                        input = bufferedReader.readLine();
                        stage = BEVERAGE;
                        break;
                    case "r":
                        System.out.println(electrics_assortment);
                        input = bufferedReader.readLine();
                        stage = ELECTRICS;
                        break;
                    default:
                        System.out.println(incorrect_welcome);
                        stage = WELCOME;
                        break;
                }

            }
            else if (stage.equals(FOOD)) {
                switch (input) {
                    case "b":
                        System.out.println(price_bread + bread_message);
                        try {
                            input = bufferedReader.readLine();
                            quantity = Integer.parseInt(input);
                            System.out.println(quantity * price_bread + assortments_quantity);
                            sum = sum + (quantity * price_bread);
                            stage = OTHER_PRODUCT;

                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            input = "b";
                        }
                        break;

                    case "m":
                        System.out.println(price_majonez + majonez_message);
                        try {
                            input = bufferedReader.readLine();
                            quantity = Integer.parseInt(input);
                            System.out.println((quantity * price_majonez)+ assortments_quantity );
                            sum = sum + (quantity * price_majonez);
                            stage = OTHER_PRODUCT;
                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            input = "m";
                        }
                        break;

                    case "w":
                        System.out.println(price_kreker + kreker_message);
                        try {
                            input = bufferedReader.readLine();
                            quantity = Integer.parseInt(input);
                            System.out.println((quantity*price_kreker)+ assortments_quantity);
                            sum = sum + (quantity * price_kreker);
                            stage = OTHER_PRODUCT;
                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            input = "w";
                        }
                        break;

                    case "u":
                        System.out.println(price_sausage + sausage_message);
                        try {
                            input = bufferedReader.readLine();
                            quantity = Integer.parseInt(input);
                            System.out.println((quantity*price_sausage)+ assortments_quantity);
                            sum = sum + (quantity * price_sausage);
                            stage = OTHER_PRODUCT;
                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            input = "u";
                        }
                        break;
                    case "q":
                        break;
                    default:
                        System.out.println(incorrect_food);
                        System.out.println(food_assortment);
                        input = bufferedReader.readLine();
                        stage = FOOD;
                        break;
                }
            }
            else if (stage.equals(BEVERAGE)) {
                switch (input) {
                    case "z":
                        System.out.println(price_water + water_message);
                        try {
                            input = bufferedReader.readLine();
                            quantity = Integer.parseInt(input);
                            System.out.println((quantity*price_water)+ assortments_quantity);
                            sum = sum + (quantity * price_water);
                            stage = OTHER_PRODUCT1;

                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            input = "z";
                        }
                        break;

                    case "y":
                        System.out.println(price_juice + juice_message);
                        try {
                            input = bufferedReader.readLine();
                            quantity = Integer.parseInt(input);
                            System.out.println((quantity*price_juice)+ assortments_quantity);
                            sum = sum + (quantity * price_juice);
                            stage = OTHER_PRODUCT1;
                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            input = "y";
                        }
                        break;

                    case "s":
                        System.out.println(price_beer + beer_message);
                        try {
                            input = bufferedReader.readLine();
                            quantity = Integer.parseInt(input);
                            System.out.println((quantity*price_beer)+ assortments_quantity);
                            sum = sum + (quantity * price_beer);
                            stage = OTHER_PRODUCT1;
                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            input = "s";
                        }
                        break;

                    case "v":
                        System.out.println(price_wine + wine_message);
                        try {
                            input = bufferedReader.readLine();
                            quantity = Integer.parseInt(input);
                            System.out.println((quantity*price_wine)+assortments_quantity);
                            sum = sum + (quantity * price_wine);
                            stage = OTHER_PRODUCT1;
                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            input = "v";
                        }
                        break;
                    case "q":
                        break;
                    default:
                        System.out.println(incorrect_beverage);
                        System.out.println(beverage_assortment);
                        input = bufferedReader.readLine();
                        stage = BEVERAGE;
                        break;
                }
            }
            else if (stage.equals(ELECTRICS)) {
                switch (input) {
                    case "d":
                        System.out.println(price_mobile + mobile_message);
                        try {
                            input = bufferedReader.readLine();
                            quantity = Integer.parseInt(input);
                            System.out.println((quantity*price_mobile)+ assortments_quantity);
                            sum = sum + (quantity * price_mobile);
                            stage = OTHER_PRODUCT2;

                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            input = "d";
                        }
                        break;

                    case "g":
                        System.out.println(price_tv + tv_message);
                        try {
                            input = bufferedReader.readLine();
                            quantity = Integer.parseInt(input);
                            System.out.println((quantity*price_tv)+ assortments_quantity);
                            sum = sum + (quantity * price_tv);
                            stage = OTHER_PRODUCT2;
                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            input = "g";
                        }
                        break;

                    case "j":
                        System.out.println(price_freeger + freeger_message);
                        try {
                            input = bufferedReader.readLine();
                            quantity = Integer.parseInt(input);
                            System.out.println((quantity*price_freeger)+ assortments_quantity);
                            sum = sum + (quantity * price_freeger);
                            stage = OTHER_PRODUCT2;
                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            input = "j";
                        }
                        break;

                    case "l":
                        System.out.println(price_laptop + laptop_message);
                        try {
                            input = bufferedReader.readLine();
                            quantity = Integer.parseInt(input);
                            System.out.println((quantity*price_laptop)+ assortments_quantity);
                            sum = sum + (quantity * price_laptop);
                            stage = OTHER_PRODUCT2;
                        } catch (NumberFormatException e) {
                            System.out.print(error);
                            input = "l";
                        }
                        break;
                    case "q":
                        break;
                    default:
                        System.out.println(incorrect_electronics);
                        System.out.println(electrics_assortment);
                        input = bufferedReader.readLine();
                        stage = ELECTRICS;
                        break;
                }
            }
            else if (stage.equals(OTHER_PRODUCT)){
                System.out.println(other_product);
                input = bufferedReader.readLine();
                switch (input) {
                    case "s":
                        System.out.println(food_assortment);
                        input = bufferedReader.readLine();
                        stage = FOOD;
                        break;
                    case "d":
                        System.out.println(departs);
                        input = bufferedReader.readLine();
                        stage = SALE;
                        break;
                    case "q":
                        break;
                    default:
                        System.out.println(incorrect_welcome);
                        stage = OTHER_PRODUCT;
                        break;}
            }
            else if (stage.equals(OTHER_PRODUCT1)){
            System.out.println(other_product);
            input = bufferedReader.readLine();
            switch (input) {
                case "s":
                    System.out.println(beverage_assortment);
                    input = bufferedReader.readLine();
                    stage = BEVERAGE;
                    break;
                case "d":
                    System.out.println(departs);
                    input = bufferedReader.readLine();
                    stage = SALE;
                    break;
                case "q":
                    break;
                default:
                    System.out.println(incorrect_welcome);
                    stage = OTHER_PRODUCT1;
                    break;}
        }
            else if (stage.equals(OTHER_PRODUCT2)){
                System.out.println(other_product);
                input = bufferedReader.readLine();
                switch (input) {
                    case "s":
                        System.out.println(electrics_assortment);
                        input = bufferedReader.readLine();
                        stage = ELECTRICS;
                        break;
                    case "d":
                        System.out.println(departs);
                        input = bufferedReader.readLine();
                        stage = SALE;
                        break;
                    case "q":
                        break;
                    default:
                        System.out.println(incorrect_welcome);
                        stage = OTHER_PRODUCT2;
                        break;}
            }
    } while (!input.equals("q"));
        System.out.println(order + sum + good_day);
    }
}


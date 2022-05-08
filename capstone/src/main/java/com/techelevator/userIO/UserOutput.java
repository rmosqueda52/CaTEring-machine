package com.techelevator.userIO;

import com.techelevator.models.Item;
import com.techelevator.models.VendingMachine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserOutput {
    public static final DecimalFormat money = new DecimalFormat("0.00");


    public static void printStarBanner() {
        System.out.println("*******************************************************************************");
    }

    public static void emptyLine() {
        System.out.println();
    }

    public static void welcomeBanner() {
        printStarBanner();
        System.out.println("******************************Catering Machine 9000****************************");
        printStarBanner();
        emptyLine();
    }

    public static void printPurchaseMenuBannerAndOptions(VendingMachine vendingMachine){
        emptyLine();
        printStarBanner();
        System.out.println("*********************************Purchase Menu*********************************");
        printStarBanner();
        emptyLine();
        System.out.println("(M) ------ Feed Money ------------------");
        System.out.println("(S) ------ Select Item -----------------");
        System.out.println("(F) ------ Finish Transaction ----------");
        emptyLine();
        System.out.println(currentMoneyProvidedToString(vendingMachine));
    }

    public static void printHomeScreenOptions(){
        System.out.println("(D) ------ Display Catering Items ------");
        System.out.println("(P) ------ Purchase Items --------------");
        System.out.println("(E) ------ Exit ------------------------");
        emptyLine();
    }

    public static void printFeedMoneyMenuOptionList(){
        UserOutput.emptyLine();
        System.out.println("Select your denomination to deposit -- $1, $5, $10, $20");
        System.out.println("--------- Make sure to include the ($) sign -----------");
        System.out.println("--------- For Example ----- $1 ------------------------");
        UserOutput.emptyLine();
    }

    public static void printSelectMenuInstructions(){
        emptyLine();
        printStarBanner();
        System.out.println("*********************************Select an Item********************************");
        printStarBanner();
        emptyLine();
        System.out.println("Input the slot of the item you wish to purchase");
        System.out.println("For example : 'A1' 'B2' ");
        emptyLine();
    }

    public static void printSalesReportConfirmation(){
        emptyLine();
        System.out.println("Sales report has been printed");
        emptyLine();
    }

    public static void printHomeScreenInvalidSelection(){
        emptyLine();
        System.out.println("Invalid selection please select (D, P or E).");
        emptyLine();
    }

    public static void printPurchaseMenuInvalidSelection(){
        emptyLine();
        System.out.println("Invalid selection please select (M, S or F).");
    }

    public static void goodBye(){
        emptyLine();
        printStarBanner();
        System.out.println("*******************************Thank you for Using*****************************");
        System.out.println("******************************Catering Machine 9000****************************");
        printStarBanner();
    }

    public static void displayListOfInventoryOfItems(List<Item> items) {
        emptyLine();

        for (Item item : items) {
            System.out.println(item.getSlot() + " || " + item.getName() + " || " + "$" + item.getPrice());

        }
        emptyLine();
    }

    public static String currentMoneyProvidedToString(VendingMachine vendingMachine) {
        return "Current Money Provided: $" + money.format(vendingMachine.getTotalMoneyUserFed());
    }

    public static String buildItemMessage(String type) {
        if (type.equals("Munchy")) {
            return "Munchy, Munchy, so Good!";
        } else if (type.equals("Sandwich")) {
            return "Sandwich So Delicious, Yum!";
        } else if (type.equals("Drink")) {
            return "Drinky, Drinky, Slurp Slurp!";
        } else if (type.equals("Dessert")) {
            return "Sugar, Sugar, so Sweet!";
        } else
            return "Nobody knows what type of food this is";
    }

    public static String buildChangeString(double[] countTheChange){
        String changeString = "Your change: $" + money.format(countTheChange[4]) + "\n";
        if (countTheChange[0] > 0) {
            changeString += "Dollars($1): " + (int)countTheChange[0] + "\n";
        }
        if (countTheChange[1] > 0) {
            changeString += "Quarter(s): " + (int)countTheChange[1] + "\n";
        }
        if (countTheChange[2] > 0) {
            changeString += "Dime(s): " + (int)countTheChange[2] + "\n";
        }
        if (countTheChange[3] > 0) {
            changeString += "Nickel(s): " + (int)countTheChange[3] + "\n";
        }
        return changeString;
    }


    public static String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss a");
        LocalDateTime rightNow = LocalDateTime.now();
        return rightNow.format(formatter);
    }

    public static String getTimeForSalesReport() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss a");
        LocalDateTime rightNow = LocalDateTime.now();
        return rightNow.format(formatter);
    }
}


package com.techelevator.view;

import com.techelevator.logger.Logger;
import com.techelevator.models.Item;
import com.techelevator.models.VendingMachine;
import com.techelevator.userIO.UserInput;
import com.techelevator.userIO.UserOutput;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Menu {
    VendingMachine vendingMachine = new VendingMachine();


    public void run() {

        try {
            readFromCateringFile();// Reads file then builds a list
        } catch (IOException e) {
            System.out.println("Test Not successful could not make list");
        }

        boolean isRunning = true;
        while (isRunning) {
            UserOutput.welcomeBanner();
            String selection = UserInput.displayHomeMenu(vendingMachine);
            if (selection.equals("list")) {
                UserOutput.displayListOfInventoryOfItems(vendingMachine.getInventoryOfItems());
            } else if (selection.equals("purchase")) {
                runPurchase();
            } else if (selection.equals("exit")) {
                UserOutput.goodBye();
                isRunning = false;
            } else if (selection.equals("secret")) {
                UserOutput.printSalesReportConfirmation();
                salesReportGenerator();
            } else if (selection.equals("invalid")) {
                UserOutput.printHomeScreenInvalidSelection();
            }
        }
    }

    public void runPurchase() {
        boolean isPurchasing = true;
        while (isPurchasing) {
            String selection = UserInput.displayPurchaseMenu(vendingMachine);
            if (selection.equals("feed")) {
                runFeed();
            } else if (selection.equals("select")) {
                runSelect();
            } else if (selection.equals("finish")) {
                runFinish();
                isPurchasing = false;
            } else if (selection.equals("invalid")) {
                UserOutput.printPurchaseMenuInvalidSelection();
            }
        }
    }

    public void runFeed() {
        UserOutput.printFeedMoneyMenuOptionList();
        UserInput.getMoneyFedFromUser(vendingMachine);
    }

    public void runSelect() {
        UserInput.displaySelectMenu(vendingMachine);
    }

    public void runFinish(){
        UserOutput.emptyLine();
        System.out.println(UserOutput.buildChangeString(vendingMachine.getChange()));
        vendingMachine.setTotalMoneyUserFed(0);
    }

    public void readFromCateringFile() throws IOException {
        File readFile = new File("catering.csv");
        try {
            Scanner fileReader = new Scanner(readFile);
            while (fileReader.hasNextLine()) {
                String currentLine = fileReader.nextLine();
                String[] itemArray = currentLine.split(","); //Split by comma to make the item
                Item item = new Item(itemArray[0], itemArray[1], itemArray[2], Double.parseDouble(itemArray[3]));
                vendingMachine.addItemToList(item); //Add each item to the vending machine.
            }
        } catch (FileNotFoundException e) {
            System.out.println("Internal Error - ItemList Not Found");
        }
    }

    public void salesReportGenerator() {
        Logger reportLogger = new Logger("Sales Report " + UserOutput.getTimeForSalesReport() + ".csv");

        double totalSales = 0.00;
        for (Item item : vendingMachine.getInventoryOfItems()) {
            int fullStock = 7;
            int numberSold = fullStock - item.getQuantity();
            reportLogger.write(item.getName() + ", " + numberSold);
            totalSales += numberSold * item.getPrice();
        }
        reportLogger.write("\n");
        reportLogger.write("TOTAL SALES: $" + UserOutput.money.format(totalSales));
        try {
            reportLogger.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

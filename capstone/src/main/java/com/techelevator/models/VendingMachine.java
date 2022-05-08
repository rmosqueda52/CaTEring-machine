package com.techelevator.models;

import com.techelevator.userIO.UserOutput;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private double totalMoneyUserFed = 0.00;
    private List<Item> inventoryOfItems = new ArrayList<>();

    public void addItemToList(Item item) {
        inventoryOfItems.add(item);
    }

    public double getTotalMoneyUserFed() {
        return totalMoneyUserFed;
    }

    public void setTotalMoneyUserFed(double totalMoneyUserFed) {
        this.totalMoneyUserFed = totalMoneyUserFed;
    }

    public List<Item> getInventoryOfItems() {
        return inventoryOfItems;
    }

    public void addMoneyToVendingMachine(double moneyFed) {
        totalMoneyUserFed += moneyFed;
    }

    public double[] getChange(){
        double calculatedCount = roundDecimalTo2Places(this.totalMoneyUserFed);
        double one = 1.00;
        double quarter = .25;
        double dime = .10;
        double nickel = .05;
        double countOne = 0, countQuarter = 0, countDime = 0, countNickel = 0;

        while (calculatedCount > 0) {
            if (calculatedCount >= one) {
                calculatedCount -= one;
                calculatedCount = roundDecimalTo2Places(calculatedCount);
                countOne++;
            } else if (calculatedCount >= quarter) {
                calculatedCount -= quarter;
                calculatedCount = roundDecimalTo2Places(calculatedCount);
                countQuarter++;
            } else if (calculatedCount >= dime) {
                calculatedCount -= dime;
                calculatedCount = roundDecimalTo2Places(calculatedCount);
                countDime++;
            } else if (calculatedCount >= nickel) {
                calculatedCount -= nickel;
                calculatedCount = roundDecimalTo2Places(calculatedCount);
                countNickel++;
            }
        }
        double [] countTheChange = new double[] {countOne, countQuarter, countDime, countNickel, this.totalMoneyUserFed};
        return countTheChange;
    }

    public static double roundDecimalTo2Places(double numberToConvert) {
        BigDecimal convertMe = new BigDecimal(numberToConvert).setScale(2, RoundingMode.HALF_UP);
        numberToConvert = convertMe.doubleValue();
        return numberToConvert;
    }

}

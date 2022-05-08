package com.techelevator.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VendingMachineTest {
    VendingMachine vendingMachine;

    @Before
    public void setUp() throws Exception {
     vendingMachine = new VendingMachine();
     Item bacon =new Item("A1", "Bacon", "Munchy", 1.50);
     Item orangeCake =new Item("B2", "Orange Cake", "Dessert", 3.00);
     Item doritos =new Item("C3", "Doritos", "Munchy", 1.00);
     Item beer =new Item("D4", "Beer", "Papsi", 0.25);

     vendingMachine.addItemToList(bacon);
     vendingMachine.addItemToList(orangeCake);
     vendingMachine.addItemToList(doritos);
     vendingMachine.addItemToList(beer);

    }

    @Test
    public void addPositiveNumbers(){
        double expected = 20.00;
        vendingMachine.addMoneyToVendingMachine(20.00);
        double actual = vendingMachine.getTotalMoneyUserFed();

        Assert.assertEquals(expected,actual,0.00);
    }

    @Test
    public void makeSure4ItemsInList(){
        int expected = 4;

        int actual = vendingMachine.getInventoryOfItems().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkItemSlots(){
        String expected = "A1";
        String expected1 = "B2";
        String expected2 = "C3";
        String expected3 = "D4";

        String actual = vendingMachine.getInventoryOfItems().get(0).getSlot();
        String actual1 = vendingMachine.getInventoryOfItems().get(1).getSlot();
        String actual2 = vendingMachine.getInventoryOfItems().get(2).getSlot();
        String actual3 = vendingMachine.getInventoryOfItems().get(3).getSlot();

        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2,actual2);
        Assert.assertEquals(expected3,actual3);
    }

    @Test
    public void checkItemName(){
        String expected = "Bacon";
        String expected1 = "Orange Cake";
        String expected2 = "Doritos";
        String expected3 = "Beer";

        String actual = vendingMachine.getInventoryOfItems().get(0).getName();
        String actual1 = vendingMachine.getInventoryOfItems().get(1).getName();
        String actual2 = vendingMachine.getInventoryOfItems().get(2).getName();
        String actual3 = vendingMachine.getInventoryOfItems().get(3).getName();

        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2,actual2);
        Assert.assertEquals(expected3,actual3);
    }

    @Test
    public void checkItemType(){
        String expected = "Munchy";
        String expected1 = "Dessert";
        String expected2 = "Munchy";
        String expected3 = "Papsi";

        String actual = vendingMachine.getInventoryOfItems().get(0).getType();
        String actual1 = vendingMachine.getInventoryOfItems().get(1).getType();
        String actual2 = vendingMachine.getInventoryOfItems().get(2).getType();
        String actual3 = vendingMachine.getInventoryOfItems().get(3).getType();

        Assert.assertEquals(expected,actual);
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2,actual2);
        Assert.assertEquals(expected3,actual3);
    }

    @Test
    public void checkItemPrice(){
        double expected = 1.50;
        double expected1 = 3.00;
        double expected2 = 1.00;
        double expected3 = 0.25;

        double actual = vendingMachine.getInventoryOfItems().get(0).getPrice();
        double actual1 = vendingMachine.getInventoryOfItems().get(1).getPrice();
        double actual2 = vendingMachine.getInventoryOfItems().get(2).getPrice();
        double actual3 = vendingMachine.getInventoryOfItems().get(3).getPrice();

        assertEquals(expected,actual,0.00);
        assertEquals(expected1, actual1,0.00);
        assertEquals(expected2,actual2, 0.00);
        assertEquals(expected3,actual3, 0.00);
    }

    @Test
    public void count_the_change_array_size_test(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(15.90);
        //Act
        int expected = 5;
        int actual = vendingMachine.getChange().length;
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void count_the_change_array_size_test_for_no_change(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(0.00);
        //Act
        int expected = 5;
        int actual = vendingMachine.getChange().length;
        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void count_the_change_array_size_test_for_one_of_each(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(1.40);
        //Act
        double[] testArray = new double[] {1,1,1,1,1.40};
        double [] actual = vendingMachine.getChange();
        //Assert
        assertArrayEquals(testArray,actual, 0);
    }

    @Test
    public void count_the_change_array_size_test_for_multiple_Dollars(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(8.40);
        //Act
        double[] testArray = new double[] {8,1,1,1,8.40};
        double [] actual = vendingMachine.getChange();
        //Assert
        assertArrayEquals(testArray,actual, 0);
    }

    @Test
    public void count_the_change_array_size_test_for_dollars_only(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(100.00);
        //Act
        double[] testArray = new double[] {100,0,0,0,100.00};
        double [] actual = vendingMachine.getChange();
        //Assert
        assertArrayEquals(testArray,actual, 0);
    }

    @Test
    public void count_the_change_array_size_test_for_quarters_only(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(0.75);
        //Act
        double[] testArray = new double[] {0,3,0,0,0.75};
        double [] actual = vendingMachine.getChange();
        //Assert
        assertArrayEquals(testArray,actual, 0);
    }

    @Test
    public void count_the_change_array_size_test_for_dimes_only(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(0.10);
        //Act
        double[] testArray = new double[] {0,0,1,0,0.10};
        double [] actual = vendingMachine.getChange();
        //Assert
        assertArrayEquals(testArray,actual, 0);
    }

    @Test
    public void count_the_change_array_size_test_for_nickels_only(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(0.05);
        //Act
        double[] testArray = new double[] {0,0,0,1,0.05};
        double [] actual = vendingMachine.getChange();
        //Assert
        assertArrayEquals(testArray,actual, 0);
    }

    @Test
    public void count_the_change_array_size_test_for_nickels_and_dimes(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(0.15);
        //Act
        double[] testArray = new double[] {0,0,1,1,0.15};
        double [] actual = vendingMachine.getChange();
        //Assert
        assertArrayEquals(testArray,actual, 0);
    }

    @Test
    public void count_the_change_array_size_test_for_nickels_and_dimes_and_quarters(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(0.40);
        //Act
        double[] testArray = new double[] {0,1,1,1,0.40};
        double [] actual = vendingMachine.getChange();
        //Assert
        assertArrayEquals(testArray,actual, 0);
    }

    @Test
    public void count_the_change_array_size_test_for_dimes_and_quarters(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(0.35);
        //Act
        double[] testArray = new double[] {0,1,1,0,0.35};
        double [] actual = vendingMachine.getChange();
        //Assert
        assertArrayEquals(testArray,actual, 0);
    }

    @Test
    public void count_the_change_array_size_test_for_dollars_and_quarters(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(1.25);
        //Act
        double[] testArray = new double[] {1,1,0,0,1.25};
        double [] actual = vendingMachine.getChange();
        //Assert
        assertArrayEquals(testArray,actual, 0);
    }

    @Test
    public void count_the_change_array_size_test_for_dollars_and_dimes(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(1.10);
        //Act
        double[] testArray = new double[] {1,0,1,0,1.10};
        double [] actual = vendingMachine.getChange();
        //Assert
        assertArrayEquals(testArray,actual, 0);
    }

    @Test
    public void count_the_change_array_size_test_for_dollars_and_nickels(){
        //Arrange
        vendingMachine.setTotalMoneyUserFed(1.05);
        //Act
        double[] testArray = new double[] {1,0,0,1,1.05};
        double [] actual = vendingMachine.getChange();
        //Assert
        assertArrayEquals(testArray,actual, 0);
    }

    @Test
    public void test_round_quarter_to_2_decimal_places(){
        //Arrange
        double quarter = 0.2499999999999;
        double expected = 0.25;
        //Act
        double actual = VendingMachine.roundDecimalTo2Places(quarter);
        //Assert
        assertEquals(expected, actual, 0.00);
    }

    @Test
    public void test_round_dime_to_2_decimal_places(){
        //Arrange
        double dime = 0.09999999999999999;
        double expected = 0.10;
        //Act
        double actual = VendingMachine.roundDecimalTo2Places(dime);
        //Assert
        assertEquals(expected, actual, 0.00);
    }

    @Test
    public void test_round_nickel_to_2_decimal_places(){
        //Arrange
        double nickel = 0.04999999999999999;
        double expected = 0.05;
        //Act
        double actual = VendingMachine.roundDecimalTo2Places(nickel);
        //Assert
        assertEquals(expected, actual, 0.00);
    }

    @Test
    public void test_round_dollar_and_change_to_2_decimal_places(){
        //Arrange
        double nickel = 5.34999999999999999;
        double expected = 5.35;
        //Act
        double actual = VendingMachine.roundDecimalTo2Places(nickel);
        //Assert
        assertEquals(expected, actual, 0.00);
    }

}

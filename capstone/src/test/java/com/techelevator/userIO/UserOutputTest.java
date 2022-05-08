package com.techelevator.userIO;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DecimalFormat;

import static org.junit.Assert.*;

public class UserOutputTest {
    public static final DecimalFormat money = new DecimalFormat("0.00");
    double[] testChangePrinter;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test_change_string_builder_output__dollars_quarters_dimes_nickels() {
        testChangePrinter = new double[]{2, 1, 1, 1, 2.40};
        //Arrange
        String expected = "Your change: $2.40\n" +
                "Dollars($1): 2\n" +
                "Quarter(s): 1\n" +
                "Dime(s): 1\n" +
                "Nickel(s): 1\n";
        //Act
        String actual = UserOutput.buildChangeString(testChangePrinter);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void test_change_string_builder_output_quarters_dimes_nickels() {
        testChangePrinter = new double[]{0, 1, 1, 1, 2.40};
        //Arrange
        String expected = "Your change: $2.40\n" +
                "Quarter(s): 1\n" +
                "Dime(s): 1\n" +
                "Nickel(s): 1\n";
        //Act
        String actual = UserOutput.buildChangeString(testChangePrinter);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void test_change_string_builder_output_dimes_nickels() {
        testChangePrinter = new double[]{0, 0, 1, 1, 2.40};
        //Arrange
        String expected = "Your change: $2.40\n" +
                "Dime(s): 1\n" +
                "Nickel(s): 1\n";
        //Act
        String actual = UserOutput.buildChangeString(testChangePrinter);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void test_change_string_builder_output_nickels() {
        testChangePrinter = new double[]{0, 0, 0, 1, 2.40};
        //Arrange
        String expected = "Your change: $2.40\n" +
                "Nickel(s): 1\n";
        //Act
        String actual = UserOutput.buildChangeString(testChangePrinter);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void test_change_string_builder_output_No_Change() {
        testChangePrinter = new double[]{0, 0, 0, 0, 0.00};
        //Arrange
        String expected = "Your change: $0.00\n";
        //Act
        String actual = UserOutput.buildChangeString(testChangePrinter);
        //Assert
        assertEquals(expected, actual);
    }
    @Test
    public void test_item_is_munchy(){
        //Arrange
        String expected = "Munchy, Munchy, so Good!";
        //Act
        String actual = UserOutput.buildItemMessage("Munchy");
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void test_item_is_sandwich(){
        //Arrange
        String expected = "Sandwich So Delicious, Yum!";
        //Act
        String actual = UserOutput.buildItemMessage("Sandwich");
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void test_item_is_drink(){
        //Arrange
        String expected = "Drinky, Drinky, Slurp Slurp!";
        //Act
        String actual = UserOutput.buildItemMessage("Drink");
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void test_item_is_dessert(){
        //Arrange
        String expected = "Sugar, Sugar, so Sweet!";
        //Act
        String actual = UserOutput.buildItemMessage("Dessert");
        //Assert
        assertEquals(expected, actual);
    }
}



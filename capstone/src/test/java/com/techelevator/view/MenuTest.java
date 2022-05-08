package com.techelevator.view;

import com.techelevator.models.VendingMachine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuTest {
VendingMachine vendingMachine;
Menu menu;

    @Before
    public void setUp() throws Exception {
        vendingMachine = new VendingMachine();
        menu = new Menu();
    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test
//    public void does_finish_transaction_reset_fed_money_to_zero(){
//        //Arrange
//        vendingMachine.setTotalMoneyUserFed(20.00);
//        //Act
//        menu.runFinish();
//        //Assert
//        assertEquals(0.00, vendingMachine.getTotalMoneyUserFed(), 0.00);
//    }

}

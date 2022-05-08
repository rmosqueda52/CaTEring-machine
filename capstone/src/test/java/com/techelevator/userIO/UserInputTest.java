package com.techelevator.userIO;

import com.techelevator.logger.Logger;
import com.techelevator.models.VendingMachine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class UserInputTest {

    @Before
    public void setUp() throws Exception {
        Logger testLogger = new Logger("Audit.txt");
        Scanner scanner = new Scanner((System.in));
        VendingMachine vendingMachine = new VendingMachine();
    }

    @After
    public void tearDown() throws Exception {
    }

//    @Test Ask Margaret?????
//    public void testReturnList(){
//        String expected = "list";
//
//
//        String actual =
//    }



}

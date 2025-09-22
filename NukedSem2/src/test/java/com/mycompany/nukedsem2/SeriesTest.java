/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.nukedsem2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author lab_services_student
 */
public class SeriesTest {

    public SeriesTest() {
    }

    @Test
    public void testSearchSeries() {
        Series test = new Series();
        //check that episodes are a number
        test.CaptureSeries("101", "Extreme Sports", "12", "10");
        //alter functions to return strings and print returned values so that it can be tested
        assertEquals("SERIES ID: 101\nSERIES NAME: Extreme Sports\nSERIES AGE RESTRICTION: 12\nSERIES NUMBER OF EPISODES: 10\n--------------------------------------\nEnter (1) to launch menu or any other key to exit", test.SearchSeries("101"));
    }

    @Test
    public void testSearchSeries_SeriesNotFound() {
        Series test = new Series();
        test.CaptureSeries("101", "Extreme Sports", "12", "10");
        assertEquals("Series with Series Id: 102 was not found!\n--------------------------------------\nEnter (1) to launch menu or any other key to exit", test.SearchSeries("102"));
    }//checks error messaging

    @Test
    public void testUpdateSeries() {
        Series test = new Series();
        test.CaptureSeries("101", "Extreme Sports", "12", "10");
        assertEquals("SERIES ID: 101\n"
                + "SERIES NAME: Extreme Sports\n"
                + "SERIES AGE RESTRICTION: 12\n"
                + "SERIES NUMBER OF EPISODES: 10\n"
                + "--------------------------------------\n"
                + "Enter (1) to launch menu or any other key to exit", test.SearchSeries("101"));
        //checks that the series in it's inital form is correct
        test.UpdateSeries("101", "11", "CHANGED", "1");
        //updates the series
        assertNotEquals("SERIES ID: 101\n"
                + "SERIES NAME: Extreme Sports\n"
                + "SERIES AGE RESTRICTION: 12\n"
                + "SERIES NUMBER OF EPISODES: 10\n"
                + "--------------------------------------\n"
                + "Enter (1) to launch menu or any other key to exit", test.SearchSeries("101"));
        //checks to see that the series has changed
        assertEquals("SERIES ID: 101\n"
                + "SERIES NAME: CHANGED\n"
                + "SERIES AGE RESTRICTION: 11\n"
                + "SERIES NUMBER OF EPISODES: 1\n"
                + "--------------------------------------\n"
                + "Enter (1) to launch menu or any other key to exit", test.SearchSeries("101"));
        //checks to see that the changes are correct

    }

    @Test
    public void testDeleteSeries() {
        Series test = new Series();
        test.CaptureSeries("101", "Extreme Sports", "12", "10");
        test.CaptureSeries("102", "Moderate Athletics", "11", "13");
        assertEquals("--------------------------------------\nSeries with Series Id: 101 WAS deleted!\n--------------------------------------\nEnter (1) to launch menu or any other key to exit", test.DeleteSeries("y", "101"));//do messaging
//tests error messaging
    }

    @Test
    public void testDeleteSeries_SeriesNotFound() {
         Series test = new Series();
        test.CaptureSeries("101", "Extreme Sports", "12", "10");
        assertEquals("Series with Series Id: 102 was not found!\n--------------------------------------\nEnter (1) to launch menu or any other key to exit", test.DeleteSeries("y","102"));
        //check if the series was not found
    }

    @Test
    public void testSeriesAgeRestriction_AgeValid() {
        Series test = new Series();
        assertTrue(test.validateAge("18"));
        assertTrue(test.validateAge("2"));//confirms the acceptable range of values for age restriction
    }

    @Test
    public void testSeriesAgeRestriction_SeriesAgeInValid() {
        Series test = new Series();
        assertFalse(test.validateAge("0"));
        assertFalse(test.validateAge("ten"));//checks that data validatin is performed and that ages falling outside of the acceptable range are not allowed
        assertFalse(test.validateAge("19"));
    }

}

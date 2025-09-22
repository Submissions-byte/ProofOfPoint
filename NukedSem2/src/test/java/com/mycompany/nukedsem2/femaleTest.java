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
public class femaleTest {

    female test = new female(68, 165, 35);

    public femaleTest() {
    }

    /**
     * Test of IBW method, of class female.
     */
    @Test
    public void testIBW() {
        String check = String.format("%.2f", test.IBW());
        double use = Double.parseDouble(check);
        assertEquals(56.91, use, "IBW");    //tests IBW to two decimal places
    }

    
    /**
     * Test of BMR method, of class female.
     */
    @Test
    public void testBMR() {

        String check = String.format("%.2f", test.BMR());
        double use = Double.parseDouble(check);
        assertEquals(1375.25, use, "BMR");  //tests BMR to two decimal places
    }

    /**
     * Test of BF method, of class female.
     */
    @Test
    public void testBF() {
        String check = String.format("%.2f", test.BF());
        double use = Double.parseDouble(check);
        assertEquals(32.62, use, "BF");     //tests BF to two decimal places
    }

}

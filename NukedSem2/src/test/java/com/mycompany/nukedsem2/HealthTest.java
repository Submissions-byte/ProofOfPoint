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
public class HealthTest {

    Health test = new Health(82, 180, 35);

    public HealthTest() {
    }
    /**
     * Test of BMI method, of class Health.
     */
    @Test
    public void testBMI() {
//        Health test = new Health(75, 182, 20, 0);
        String check = String.format("%.2f", test.BMI());
        double use = Double.parseDouble(check);
        assertEquals(25.31, use, "BMI");    //tests BMI to two decimal places
    }

    /**
     * Test of IBW method, of class Health.
     */
    @Test
    public void testIBW() {
        String check = String.format("%.2f", test.IBW());
        double use = Double.parseDouble(check);
        assertEquals(74.99, use, "IBW");    //tests IBW to two decimal places
    }

    /**
     * Test of BMR method, of class Health.
     */
    @Test
    public void testBMR() {
        String check = String.format("%.2f", test.BMR());
        double use = Double.parseDouble(check);
        assertEquals(1775, use, "BMR"); //tests BMR to two decimal places
    }

    /**
     * Test of TDEE method, of class Health.
     */
    @Test
    public void testTDEE() {
        String check = String.format("%.2f", test.TDEE());
        double use = Double.parseDouble(check);
        assertEquals(2751.25, use, "TDEE"); //tests TDEE to two decimal places
    }

    /**
     * Test of BF method, of class Health.
     */
    @Test
    public void testBF() {
        String check = String.format("%.2f", test.BF());
        double use = Double.parseDouble(check);
        assertEquals(22.22, use, "BF"); //tests BF to two decimal places
    }

    /**
     * Test of FM method, of class Health.
     */
    @Test
    public void testFM() {
        String check = String.format("%.2f", test.FM());
        double use = Double.parseDouble(check);
        assertEquals(18.22, use, "FM"); //tests FM to two decimal places
    }

    /**
     * Test of LBM method, of class Health.
     */
    @Test
    public void testLBM() {
        String check = String.format("%.2f", test.LBM());
        double use = Double.parseDouble(check);
        assertEquals(63.78, use, "LBM");    //tests LBM to two decimal places
    }

    /**
     * Test of FFMI method, of class Health.
     */
    @Test
    public void testFFMI() {
        String check = String.format("%.2f", test.FFMI());
        double use = Double.parseDouble(check);
        assertEquals(19.68, use, "FFMI");   //tests FFMI to two decimal places
    }
}

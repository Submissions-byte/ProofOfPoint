/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.nukedsem2;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class NukedSem2 {

    public static void main(String[] args) {
        System.out.println("LATEST SERIES - 2025\n**************************************\nEnter (1) to launch menu or any other key to exit"); //38 *s as indicated
        Scanner scan = new Scanner(System.in);
        Series helper = new Series();           //this was the issue
        escape:
        {

            while (scan.nextInt() == 1) {
                scan.nextLine();
                System.out.println("Please select one of the following menu items:\n(1)Capture a new series.\n(2)Search for a series.\n(3)Update series age restriction.\n(4)Delete a series.\n(5)Print series report - 2025\n(6)Exit Application.");
                //creates menu
                int selection = scan.nextInt();
                scan.nextLine();

                switch (selection) {
                    case 1:
                        System.out.println("Enter the series id: ");
                        String id = scan.nextLine();        //gathers inputs
                        System.out.println("Enter the series name: ");
                        String name = scan.nextLine();
                        System.out.println("Enter the series age restriction: ");
                        String age = scan.nextLine();

                        while (!helper.validateAge(age)) {
                            System.out.println("You have entered a incorrect series age!!!\nPlease re-enter the series age >>");
                            age = scan.nextLine();
                        }

                        System.out.println("Enter the number of episodes for " + name + ": ");
                        String episode = scan.nextLine();
                        while (!episode.matches("\\d+")) {
                            System.out.println("You have entered a invalid number of episodes !!!\nPlease re-enter the number of episodes >>");
                            episode = scan.nextLine();
                        }

                        while (!(Integer.parseInt(episode) > 0)) {
                            System.out.println("You have entered a invalid number of episodes !!!\nPlease re-enter the number of episodes >>");
                            episode = scan.nextLine();
                        }
                        //ensures inputs are valid

                        System.out.println(helper.CaptureSeries(id, name, age, episode));
                        break;
                    case 2:
                        System.out.println("Enter series id to search: ");      //assume id can be numeric, alphabetic or alpha-numeric
                        String id2 = scan.nextLine();   //gets the id to search for
                        System.out.println("--------------------------------------");
                        System.out.println(helper.SearchSeries(id2));   //outputs relevant info
                        break;

                    case 3:
                        System.out.println("Enter the series id to update: ");
                        String id3 = scan.nextLine();
                        System.out.println("Enter the series name: ");
                        String name3 = scan.nextLine();     //gathers inputs
                        System.out.println("Enter the age restriction: ");
                        String age3 = scan.nextLine();
                        while (!helper.validateAge(age3)) { //confirms updated age still conforms to specifications
                            System.out.println("You have entered a incorrect series age!!!\nPlease re-enter the series age >>");
                            age3 = scan.nextLine();
                        }
                        System.out.println("Enter the number of episodes: ");
                        String episode3 = scan.nextLine();
                        while (!episode3.matches("\\d+")) {
                            System.out.println("You have entered a invalid number of episodes !!!\nPlease re-enter the number of episodes >>");
                            episode3 = scan.nextLine();
                        }

                        while (!(Integer.parseInt(episode3) > 0)) {
                            System.out.println("You have entered a invalid number of episodes !!!\nPlease re-enter the number of episodes >>");
                            episode3 = scan.nextLine();
                        }
                        //ensures inputs are valid

                        helper.UpdateSeries(id3, age3, name3, episode3);
                        break;
                    case 4:
                        System.out.println("Enter the series id to delete: ");
                        String id4 = scan.nextLine();   //gets id to search for
                        System.out.println("Are you sure you want to delete series " + id4 + " from the system? Yes (y) to delete.");
                        String response = scan.nextLine();//confirms whether or not the user wishes to delete the series
                        System.out.println(helper.DeleteSeries(response, id4)); //performs the action
                        break;
                    case 5:
                        helper.SeriesReport();  //prints the series report
                        break;
                    case 6:
                        break escape;   //escapes the menu/ends part A
                    default:
                        break;  //defaults to it
                }

            }
        }

//        scan.close(); would close here but it causes conflict with part B as a terminal application
        scan.nextLine();//moves scanner/cursor
        System.out.println("\n\nPart B: \n");
        System.out.println("\nHealth metric calculator:\n");//Heading info

        System.out.println("Enter weight(kg):");
        int weight = Integer.parseInt(scan.nextLine());
        System.out.println("Enter height(cm):");    //gathers input in stated unit of measurement
        int height = Integer.parseInt(scan.nextLine());
        System.out.println("Enter age(years):");
        int age = Integer.parseInt(scan.nextLine());
        System.out.println("Enter gender(male/female)(male by default):");  //defaults to male in case user does not indicate a gender
        String gender = scan.nextLine();
        scan.close();

        if (gender.contentEquals("female")) {   //checks the user's gender
            female user = new female(weight, height, age);
            System.out.format("Bodyfat percentage: %.2f \nBody Mass Index: %.2f \nBasal Metabolic Rate: %.2f kcal/day\nTotal Daily Energy Expenditure: %.2f kcal/day\nFat-Free Mass Index: %.2f \nFat Mass: %.2fkg\nIdeal Body Weight: %.2fkg\nLean Body Mass: %.2fkg\n", user.BF(), user.BMI(), user.BMR(), user.TDEE(), user.FFMI(), user.FM(), user.IBW(), user.LBM());//note
            //prints out the user's health metrics that were calculated in their respective units of measurement
            double[][] out = user.monteCarlo();
            System.out.println("\nMonte Carlo projection of Lean Body Mass\n\t\tWorst Case\tMean Case\tBest Case");
            for (int i = 0; i < out.length; i++) {  //gives the user a monte carlo projection of their future lean body mass to show how their muscle mass shall atrophy with time
                System.out.printf("Age " + (age + i) + ":\t\t%.2fkg\t\t%.2fkg\t\t%.2fkg\n", out[i][100], out[i][5000], out[i][9000]);
            }
        } else {
            Health user = new Health(weight, height, age);
            System.out.format("Bodyfat percentage: %.2f \nBody Mass Index: %.2f \nBasal Metabolic Rate: %.2f kcal/day\nTotal Daily Energy Expenditure: %.2f kcal/day\nFat-Free Mass Index: %.2f \nFat Mass: %.2fkg\nIdeal Body Weight: %.2fkg\nLean Body Mass: %.2fkg\n", user.BF(), user.BMI(), user.BMR(), user.TDEE(), user.FFMI(), user.FM(), user.IBW(), user.LBM());//note
            double[][] out = user.monteCarlo();

            System.out.println("\nMonte Carlo projection of Lean Body Mass\n\t\tWorst Case\tMean Case\tBest Case");
            for (int i = 0; i < out.length; i++) {  //gives the user a monte carlo projection of their future lean body mass to show how their muscle mass shall atrophy with time
                System.out.printf("Age " + (age + i) + ":\t\t%.2fkg\t\t%.2fkg\t\t%.2fkg\n", out[i][100], out[i][5000], out[i][9000]);

            }

        }
    }

}

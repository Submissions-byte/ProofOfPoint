/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nukedsem2;

/**
 *
 * @author lab_services_student
 */
public class Health {

    private int weight, height, age; //potentially ethnicity as well as boolean/int for condtions and or heredity

    //maybe alter so that inheritance separates male and female or ages or fitness lvls and maybe other factors
    //arrays need to be included somewhere -- use to show at various projected ages    monte carlo gaurenteed, divide standard deviation and work through with it falling anywhere within the range at each iteration and from there calculate distribution
    //iterate through and log then iterate through log, neat numbers for percentiles: 10 000 is 100 hundreds
    public Health(int weight, int height, int age) {
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public int getHeight() {
        return height;      //getters so that the variables may be used in the sub-class
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }
    
    

    
    
    public double BMI() {
        double h = height;
        h = h / 100;
        return weight / (h * h);  //calculates the Body Mass Index
    }

    public double IBW() {
            return (50 + 2.3 * (0.39370079 * height - 60)); //Calculates the ideal body weight
    }

    public double BMR() {
            return 10 * weight + 6.25 * height - 5 * age + 5;//calculates the basal metabolic rate i.e. the amount of calories burned at rest    
    }

    public double TDEE() {        
        return this.BMR()*1.55;     //calculates the total amount f calories burned in a day
    }

    public double BF() {
            return (1.2 * BMI()) + 0.23 * age - 10.8 - 5.4; //calculates the body fate percentage of the user     
    }

    public double FM() {
        return BF() / 100 * weight; //calculates the user's fat mass
    }

    public double LBM() {
        return weight - FM();   //calculates the user's lean body mass
    }

    public double FFMI() {
        double h = height;
        h = h / 100;
        return LBM() / (h * h);     //calculates the user's fat-free mass index which can be used to determine how much the user's bodyfat contributes to their BMI
    }

    public double[][] monteCarlo() {
        double[][] logLBM = new double[1][10000];
        logLBM[0][5000]=logLBM[0][100]=logLBM[0][9000]=LBM();//current LBM
        if(age<=80){//accounts for the possibility that the user is older than 80
            logLBM = new double[80-age+1][10000];
        //rinse and repeat
        for (int i = 0; i < 10000; i++) {
            logLBM[0][i] = LBM();
            for (int y = 1; y < (80 - age + 1); y++) {
                logLBM[y][i] = logLBM[y - 1][i] * (1 - ((Math.round((Math.random() * 2)) * 0.25) + 0.5)/100);   //populates an array with values corresponding to the user's lean body mass over the course of their life, up until age 80, and does multiple simulations of it within a standard deviation of the mean as per the mnte carlo method
            }
        }
        for (int y = 0; y < (80 - age + 1); y++) {      //sorts the array created for use in determining percentiles of the distribution of values
            for (int i = 0; i < logLBM[y].length; i++) {
                // Inner nested loop pointing 1 index ahead
                for (int j = i + 1; j < logLBM[y].length; j++) {

                    // Checking elements
                    double temp = 0;
                    if (logLBM[y][j] < logLBM[y][i]) {

                        // Swapping
                        temp = logLBM[y][i];
                        logLBM[y][i] = logLBM[y][j];
                        logLBM[y][j] = temp;
                    }
                }
            }
        }
        }
        return logLBM;
    }
}

class female extends Health {

    public female(int weight, int height, int age) {
        super(weight, height, age);
    }

    @Override
    public double IBW() {
        return (45.5 + 2.3 * (0.39370079 * this.getHeight() - 60));//overrides IBW as it varies by gender
    }
    
    @Override
    public double BMR(){
        return 10 * this.getWeight() + 6.25 * this.getHeight() - 5 * this.getAge() - 161; //overrrides BMR as it varies by gender
    }
    
    @Override
    public double BF(){
        return (1.2 * BMI()) + 0.23 * this.getAge() - 5.4;      //overrides BF as it varies by gender
    }

}

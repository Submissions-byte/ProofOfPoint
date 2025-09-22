/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nukedsem2;

import java.util.ArrayList;

/**
 *
 * @author lab_services_student
 */
public class Series {

    private ArrayList<SeriesModel> seriesList = new ArrayList<>();
    
    //maybe add checks for data validation, at least data type(id's are no.'s)

    public String CaptureSeries(String id, String name, String age, String episode) {

        //they don't instruct on repeating ids
    //check that episodes are a number, not sure about id tho
        SeriesModel series = new SeriesModel(id, name, age, episode);
        seriesList.add(series);
        return "Series processed successfully!!!\nEnter (1) to launch menu or any other key to exit";

        //  System.out.println(seriesList.size());
    }

    public boolean validateAge(String Age) {
        if (!Age.matches("\\d+")) {
            return false;       //confirms that the age is a number
        }
        int age = Integer.parseInt(Age);
        if (age >= 2 && age <= 18) {
            return true;    //confirms that the age is within the specified range
        }
        return false;
    }

    public String SearchSeries(String id) {
        SeriesModel temp = new SeriesModel(null, null, null, null);
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesID().contains(id)) {     
                temp = seriesList.get(i);   //gets a reference to the series and breaks out of the lop once it's found
                break;
            }
        }
        String out;
        if (!(temp.getSeriesID() == null)) {
            out = ("SERIES ID: " + temp.getSeriesID() + "\nSERIES NAME: " + temp.getSeriesName() + "\nSERIES AGE RESTRICTION: " + temp.getSeriesAge() + "\nSERIES NUMBER OF EPISODES: " + temp.getSeriesNumberOfEpisodes());
        //provides seriies info for output
        } else {
             out = ("Series with Series Id: " + id + " was not found!");
        }
        return (out +"\n--------------------------------------\nEnter (1) to launch menu or any other key to exit");

    }

    public void UpdateSeries(String id, String age, String name, String episode) {
        for (int i = 0; i < seriesList.size(); i++) {
            if (seriesList.get(i).getSeriesID().contentEquals(id)) { //finds series
                seriesList.get(i).setSeriesAge(age);                   //updates values
                seriesList.get(i).setSeriesName(name);
                seriesList.get(i).setSeriesNumberOfEpisodes(episode);
                break;
            }
        }
        //if the series is not found nothing need be done
        System.out.println("Enter (1) to launch menu or any other key to exit");

    }

    public String DeleteSeries(String response, String id) {
        String out = ("Series with Series Id: " + id + " was not found!");//the series  not found by default and this is only corrected if it's found
        if (response.contentEquals("y")) { //checks that the user has confirmed their intent to delete this series    
            for (int i = 0; i < seriesList.size(); i++) {
                if (seriesList.get(i).getSeriesID().contentEquals(id)) {//finds series
                    out ="--------------------------------------\nSeries with Series Id: " + id + " WAS deleted!";//indicates successful deletion
                    seriesList.remove(i);
                    break;
                }
            }
        }
        return (out +"\n--------------------------------------\nEnter (1) to launch menu or any other key to exit");    //returns messaging
    }

    public void SeriesReport() {
        for (int i = 0; i < seriesList.size(); i++) {//traverses through the list of series
            System.out.println("SERIES " + (i+1));
            System.out.println("--------------------------------------");
            System.out.println("SERIES ID: " + seriesList.get(i).getSeriesID());
            System.out.println("SERIES NAME: " + seriesList.get(i).getSeriesName());
            System.out.println("SERIES AGE RESTRICTION: " + seriesList.get(i).getSeriesAge());
            System.out.println("NUMBER OF EPISODES: " + seriesList.get(i).getSeriesNumberOfEpisodes());
            System.out.println("--------------------------------------");
        }
        System.out.println("Enter (1) to launch menu or any other key to exit");

    }

    public void ExitSeriesApplication() {
        //can only be implemented in the main method with a jump lest the scanner need be closed and a new one created which may be prone to errors on part b
        //and would otherwise be done, potentially
    }
}

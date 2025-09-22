/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nukedsem2;

/**
 *
 * @author lab_services_student
 */
public class SeriesModel {
    private String SeriesID,SeriesName,SeriesAge,SeriesNumberOfEpisodes;

    public SeriesModel(String SeriesID, String SeriesName, String SeriesAge, String SeriesNumberOfEpisodes) {
        this.SeriesID = SeriesID;
        this.SeriesName = SeriesName;
        this.SeriesAge = SeriesAge;
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }
    
//    public boolean validateAge(String Age){
//        if(!Age.matches("\\d+"))
//            return false;
//        int age = Integer.parseInt(Age);
//        if(age>=2 && age<=18)
//            return true;
//        return false;
//    }

    public void setSeriesName(String SeriesName) {
        this.SeriesName = SeriesName;
    }

    public void setSeriesAge(String SeriesAge) {
        this.SeriesAge = SeriesAge;
    }

    public void setSeriesNumberOfEpisodes(String SeriesNumberOfEpisodes) {
        this.SeriesNumberOfEpisodes = SeriesNumberOfEpisodes;
    }

    public String getSeriesID() {
        return SeriesID;
    }

    public String getSeriesName() {
        return SeriesName;
    }

    public String getSeriesAge() {
        return SeriesAge;
    }

    public String getSeriesNumberOfEpisodes() {
        return SeriesNumberOfEpisodes;
    }
    
    
}
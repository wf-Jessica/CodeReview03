package Citybike;

import java.util.ArrayList;

public class Station {

    private static int count=1;
    private int stationID;
    private String location;
    private ArrayList<Integer> bikes;


    public Station(String location) {
        this.stationID = count++;
        this.location = location;
        this.bikes = new ArrayList<>();
    }
    public Station(){}

    public String getLocation() {
        return location;
    }

    public int getStationID() {
        return stationID;
    }


    public void addBike(Integer bikeID) {
        this.bikes.add(bikeID);
    }

    public void removeBike(Integer bikeID){
        this.bikes.remove(bikeID);
    }

    public ArrayList<Integer> getBikes(){
        return this.bikes;
    }


    public void returnBike(Integer bikeID) {
        if (this.bikes.size() <= 7) {
            addBike(bikeID);
            Main.checkWhichUser(bikeID);
        } else {
            System.out.println("This station is already full");
        }
}}

package Citybike;


import java.text.SimpleDateFormat;
import java.util.*;

public class User {
    private static int count = 1;
    private int userID;
    private String name;
    private String surname;
    private Integer currentlyRentedBike;
    private Rent rent;
    private ArrayList<Rent> rents = new ArrayList<>();

    public User(String name, String surname) {
        this.userID = count++;
        this.name = name;
        this.surname = surname;
    }

    public User() {
    }
//check if the bike can be rented removes bike from station and creates rent object
    public void rentABike(Integer bikeID) {
        if (Main.bikes.get(bikeID).getState() == Bike.bikeStatus.CanBeRented) {
            Main.checkWhichStation(bikeID);
            this.currentlyRentedBike = bikeID;
            GregorianCalendar today = (GregorianCalendar) Calendar.getInstance();
            this.rent = new Rent(bikeID, today);
            this.rents.add(this.rent);
        } else {
            System.out.println("Kann im Moment nicht ausgeliehen werden");
        }
    }

    public int getUserID() {
        return userID;
    }

//adds the renting end in the rent -object
    public void removeBike(Integer bikeID) {
        this.rent.setRentEnd();
        this.currentlyRentedBike = null;
    }

    public Integer getCurrentlyRentedBike() {
        return currentlyRentedBike;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }


    public void printAllRentedBikesEver() {
        SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss dd.MM.yyyy");
        String printName = this.name + " " + this.surname;
        System.out.printf("%S" + "%17s" + "%28s%n", printName, "Start", "End");
        System.out.println("----------------------------------------------------------------------");
        for (Rent rent : rents) {
            System.out.printf("Bike" + "%2S" + "%34S" + "%30S%n", rent.getBikeID(), sdf.format(rent.getRentStart().getTime()),
                    sdf.format(rent.getRentEnd().getTime()));
        }
    }
}
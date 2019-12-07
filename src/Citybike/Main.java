package Citybike;

import java.util.*;

public class Main {

    static HashMap<Integer, Bike> bikes = new HashMap<>();
    static HashMap<Integer, Station> stations = new HashMap<>();
    static HashMap<Integer,User>users= new HashMap<>();

    public static void main(String[] args) {

        //10 Bikes
    Bike bike1= new Bike("green", Bike.bikeStatus.CanNotBeRented);
    Bike bike2= new Bike("orange", Bike.bikeStatus.CanBeRented);
    Bike bike3= new Bike("blue", Bike.bikeStatus.CanBeRented);
    Bike bike4= new Bike("black", Bike.bikeStatus.Discarded);
    Bike bike5= new Bike("gray", Bike.bikeStatus.CanNotBeRented);
    Bike bike6= new Bike("yellow", Bike.bikeStatus.CanBeRented);
    Bike bike7= new Bike("pink", Bike.bikeStatus.InService);
    Bike bike8= new Bike("red", Bike.bikeStatus.CanNotBeRented);
    Bike bike9= new Bike("lightblue", Bike.bikeStatus.InService);
    Bike bike10= new Bike("olive", Bike.bikeStatus.Discarded);

    //add it to a Hashmap
    bikes.put(bike1.getBikeID(),bike1);
    bikes.put(bike2.getBikeID(),bike2);
    bikes.put(bike3.getBikeID(),bike3);
    bikes.put(bike4.getBikeID(),bike4);
    bikes.put(bike5.getBikeID(),bike5);
    bikes.put(bike6.getBikeID(),bike6);
    bikes.put(bike7.getBikeID(),bike7);
    bikes.put(bike8.getBikeID(),bike8);
    bikes.put(bike9.getBikeID(),bike9);
    bikes.put(bike10.getBikeID(),bike10);

    //create 3 Stations
    Station station1=new Station("Karlsplatz");
    Station station2=new Station("Handelskai");
    Station station3=new Station("Praterstern");
    //add it to a Hashmap
    stations.put(station1.getStationID(),station1);
    stations.put(station2.getStationID(),station2);
    stations.put(station3.getStationID(),station3);
    //add 3 bikes to station 1 and 4 bikes to station 2
    station1.addBike(bike2.bikeID);
    station1.addBike(bike4.bikeID);
    station1.addBike(bike5.bikeID);
    station2.addBike(bike6.bikeID);
    station2.addBike(bike7.bikeID);
    station2.addBike(bike8.bikeID);
    station2.addBike(bike9.bikeID);


    //create 5 Users
    User user1=new User("Jessica","Triltsch");
    User user2=new User("Isabella","Triltsch");
    User user3=new User("Nikola","Ilic");
    User user4=new User("Roman","Springer");
    User user5=new User("Max","Mustermann");
    //put it in a Hashmap
    users.put(user1.getUserID(),user1);
    users.put(user2.getUserID(),user2);
    users.put(user3.getUserID(),user3);
    users.put(user4.getUserID(),user4);
    users.put(user5.getUserID(),user5);

    System.out.println("========================================================================================");
    System.out.println(user3.getName()+" "+user3.getSurname()+" hat sich im Moment bereits "+ user3.getCurrentlyRentedBike()+" Fahrräder ausgeborgt ");
    System.out.println("In der Station "+station1.getLocation()+" befinden sich Momentan die Fahrräder mit den IDs" + station1.getBikes().toString());
    user3.rentABike(2);
    System.out.println("========================================================================================");
    System.out.println(user3.getName()+" "+user3.getSurname()+" hat sich im Moment bereits "+ user3.getCurrentlyRentedBike()+" Fahrräder ausgeborgt ");
    System.out.println("In der Station "+station1.getLocation()+" befinden sich Momentan die Fahrräder mit den IDs" + station1.getBikes().toString());
    System.out.println("=======================================================================================");
    station3.returnBike(2);
    System.out.println(user3.getName()+" "+user3.getSurname()+" hat sich im Moment bereits "+ user3.getCurrentlyRentedBike()+" Fahrräder ausgeborgt ");
    System.out.println("In der Station "+station3.getLocation()+" befinden sich Momentan die Fahrräder mit den IDs" + station3.getBikes().toString());

    user3.rentABike(6);
    station2.returnBike(6);
    System.out.println("======================================================================================");
    user3.printAllRentedBikesEver();


} //go through stations Hashmap looks for bikeID and in which station bike was found
public static void checkWhichStation(Integer bikeID){
        Station st = new Station();
        for(Map.Entry<Integer, Station> entry : stations.entrySet()){
            if(entry.getValue().getBikes().contains(bikeID)){
                st = entry.getValue();
                break;
            }
        }
        st.removeBike(bikeID);
    }

    //go through users Hashmap give back the user, after checking bikeID
    public static void checkWhichUser(Integer bikeID){
        User us = new User();
        for(Map.Entry<Integer, User> entry : users.entrySet()){
            if(entry.getValue().getCurrentlyRentedBike() == bikeID){
                us = entry.getValue();
                break;
            }
        }
        us.removeBike(bikeID);
    }

}


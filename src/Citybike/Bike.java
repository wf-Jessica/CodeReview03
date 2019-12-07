package Citybike;

public class Bike {

    public enum bikeStatus {
        CanBeRented, CanNotBeRented, InService, Discarded
    }
    private static Integer count=1;
    protected int bikeID;
    private String color;
    private bikeStatus state;

    public Bike(String color, bikeStatus state) {
        this.bikeID = count++;
        this.color = color;
        this.state = state;
    }

    public int getBikeID() {
        return bikeID;
    }

    public bikeStatus getState() {
        return state;
    }


}

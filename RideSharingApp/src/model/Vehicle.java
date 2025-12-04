package model;

public abstract class Vehicle {
    protected String id;
    protected int location; // 1 - 100

    public Vehicle(String id, int location) {
        this.id = id;
        this.location = location;
    }

    public int distanceTo(int clientLocation) {
        return Math.abs(clientLocation - location);
    }

    public abstract boolean isEligible(TripRequest req);

    public String getId() { return id; }
    public int getLocation() { return location; }
}

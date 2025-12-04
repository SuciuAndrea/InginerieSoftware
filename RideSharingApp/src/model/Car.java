package model;

public class Car extends Vehicle {

    public Car(String id, int location) {
        super(id, location);
    }

    @Override
    public boolean isEligible(TripRequest req) {
        return true; // masinile nu au limitari
    }
}

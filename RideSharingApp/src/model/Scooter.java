package model;

public class Scooter extends Vehicle {

    private int maxRangeKm;

    public Scooter(String id, int location, int maxRangeKm) {
        super(id, location);
        this.maxRangeKm = maxRangeKm;
    }

    @Override
    public boolean isEligible(TripRequest req) {
        return maxRangeKm >= req.getTripKm() * 0.5;
    }

    public int getMaxRangeKm() { return maxRangeKm; }
}

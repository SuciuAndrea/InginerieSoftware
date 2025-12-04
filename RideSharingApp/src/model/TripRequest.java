package model;

public class TripRequest {

    private int clientLocation;
    private int destinationLocation;

    public TripRequest(int clientLocation, int destinationLocation) {
        this.clientLocation = clientLocation;
        this.destinationLocation = destinationLocation;
    }

    public int getTripKm() {
        return Math.abs(destinationLocation - clientLocation);
    }

    public int getClientLocation() {
        return clientLocation;
    }
}

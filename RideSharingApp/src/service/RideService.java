package service;

import model.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RideService {

    public List<Vehicle> findBestOptions(TripRequest req, List<Vehicle> vehicles) {

        return vehicles.stream()
                .filter(v -> v.isEligible(req))
                .sorted(Comparator.comparingInt(v -> v.distanceTo(req.getClientLocation())))
                .limit(3)
                .collect(Collectors.toList());
    }
}

import mediator.*;
import model.*;
import service.RideService;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ChatMediator mediator = new ChatMediatorImpl();
        User system = new SystemBot(mediator);
        User client = new Client(mediator, "Client");

        mediator.addUser(system);
        mediator.addUser(client);

        client.send("Cerere ride: sunt aici -> 50, vreau să merg la 80.");

        TripRequest req = new TripRequest(50, 80);

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("Car1", 55));
        vehicles.add(new Car("Car2", 40));
        vehicles.add(new Scooter("Scoot1", 60, 20));
        vehicles.add(new Scooter("Scoot2", 48, 5));
        vehicles.add(new Scooter("Scoot3", 52, 40));

        RideService rideService = new RideService();
        List<Vehicle> best = rideService.findBestOptions(req, vehicles);

        system.send("Cele mai apropiate 3 optiuni:");

        for (Vehicle v : best) {
            system.send(v.getId() + " la distanta: " + v.distanceTo(req.getClientLocation()));
        }
    }
}

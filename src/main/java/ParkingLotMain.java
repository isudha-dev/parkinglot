import model.EntryGate;
import model.Gate;
import model.Vehicle;
import model.VehicleType;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;
import repository.TicketRepository;
import service.ParkingSpotVehicleTypeMatchingService;
import service.TicketService;
import strategy.parkingspotfindingstrategy.ParkingSpotFindingStrategy;
import strategy.parkingspotfindingstrategy.RandomParkingSpotFindingStrategy;

public class ParkingLotMain {

    public static void main(String[] args) {

        ObjectRegistry objectRegistry = new ObjectRegistry();

        objectRegistry.register("parkingSpotRepository", new ParkingSpotRepository());
        objectRegistry.register("parkingLotRepository", new ParkingLotRepository());
        objectRegistry.register("ticketRepository", new TicketRepository());
        objectRegistry.register("parkingSpotVehicleTypeMatchingService", new ParkingSpotVehicleTypeMatchingService());
        objectRegistry.register("parkingSpotFindingStrategy", new RandomParkingSpotFindingStrategy((ParkingSpotVehicleTypeMatchingService) objectRegistry.get("parkingSpotVehicleTypeMatchingService")));

        TicketService ticketService = new TicketService(
            (TicketRepository) objectRegistry.get("ticketRepository"),
            (ParkingSpotRepository) objectRegistry.get("parkingSpotRepository"),
            (ParkingLotRepository) objectRegistry.get("parkingLotRepository"),
            (ParkingSpotFindingStrategy) objectRegistry.get("parkingSpotFindingStrategy")
        );



        Vehicle vehicle = new Vehicle();
        vehicle.setNumber("MH43AT6747");
        vehicle.setVehicleType(VehicleType.SMALL);

//        Gate gate = new EntryGate();
//
//        ticketService.getTicket()




    }

}

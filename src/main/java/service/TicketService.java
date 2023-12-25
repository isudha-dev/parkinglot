package service;

import java.util.Date;
import exception.ParkingLotNotAvailableException;
import exception.ParkingSpotNotAvailable;
import model.EntryGate;
import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingSpot;
import model.ParkingSpotStatus;
import model.Ticket;
import model.Vehicle;
import repository.ParkingLotRepository;
import repository.ParkingSpotRepository;
import repository.TicketRepository;
import strategy.parkingspotfindingstrategy.ParkingSpotFindingStrategy;

public class TicketService {
    private ParkingSpotFindingStrategy parkingSpotFindingStrategy;
    private ParkingLotRepository parkingLotRepository;

    private TicketRepository ticketRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public TicketService(TicketRepository ticketRepository, ParkingSpotRepository parkingSpotRepository, ParkingLotRepository parkingLotRepository, ParkingSpotFindingStrategy parkingSpotFindingStrategy){
        this.ticketRepository = ticketRepository;
        this.parkingSpotRepository = parkingSpotRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotFindingStrategy = parkingSpotFindingStrategy;
    }

    public Ticket getTicket(Vehicle vehicle, EntryGate entryGate) throws ParkingLotNotAvailableException, ParkingSpotNotAvailable {
        ParkingSpot availableSpot = parkingSpotFindingStrategy.getAvailableSpot(vehicle.getVehicleType(), parkingLotRepository.getParkingLotFromGate(entryGate));
        availableSpot.setParkingSpotStatus(ParkingSpotStatus.UNAVAILABLE);

        Ticket ticket = new Ticket();
        ticket.setGate(entryGate);
        ticket.setGeneratedBy(entryGate.getOperator());
        ticket.setEntryTime(new Date().toString());
        ticket.setVehicle(vehicle);

        parkingSpotRepository.save(availableSpot);
        ticket.setParkingSpot(availableSpot);
        ticketRepository.save(ticket);

        return ticket;
    }

    /*
    Steps
    Find available spot
    Generate ticket obj
    Add all details in ticket obj
    Save the ticket
     */
    public void updateParkingSpotStatus(ParkingLot parkingLot, ParkingSpot parkingSpot){
        for(ParkingFloor parkingFloor: parkingLot.getParkingFloors()){
            for(ParkingSpot spot: parkingFloor.getParkingSpots()){
                if(spot.equals(parkingSpot)){
                    if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)){
                        parkingSpot.setParkingSpotStatus((ParkingSpotStatus.UNAVAILABLE));
                    } else {
                        parkingSpot.setParkingSpotStatus(ParkingSpotStatus.AVAILABLE);
                    }
                }

            }
        }
        parkingLotRepository.update(parkingLot);
    }

}

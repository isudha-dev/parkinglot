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
import strategy.parkingspotfindingstrategy.ParkingSpotFindingStrategy;

public class TicketService {
    private ParkingSpotFindingStrategy parkingSpotFindingStrategy;
    private ParkingLotRepository parkingLotRepository;

    public TicketService(ParkingSpotFindingStrategy parkingSpotFindingStrategy, ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
        this.parkingSpotFindingStrategy = parkingSpotFindingStrategy;
    }

    public Ticket getTicket(Vehicle vehicle, EntryGate entryGate) throws ParkingLotNotAvailableException, ParkingSpotNotAvailable {
        ParkingSpot availableSpot = parkingSpotFindingStrategy.getAvailableSpot(vehicle.getVehicleType(), parkingLotRepository.getParkingLotFromGate(entryGate));
        Ticket ticket = new Ticket();
        ticket.setGate(entryGate);
        ticket.setGeneratedBy(entryGate.getOperator());
        ticket.setEntryTime(new Date().toString());
        ticket.setParkingSpot(availableSpot);
        ticket.setVehicle(vehicle);
        return ticket;

        //todo: create ticker repository and save this ticket before returning to user
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

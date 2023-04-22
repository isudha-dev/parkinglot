package strategy.parkingspotfindingstrategy;

import exception.ParkingSpotNotAvailable;
import model.ParkingLot;
import model.ParkingSpot;
import model.VehicleType;

public interface ParkingSpotFindingStrategy {

    ParkingSpot getAvailableSpot(VehicleType vehicleType, ParkingLot parkingLot) throws ParkingSpotNotAvailable;

}

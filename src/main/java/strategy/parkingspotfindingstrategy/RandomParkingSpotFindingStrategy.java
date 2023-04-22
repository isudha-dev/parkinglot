package strategy.parkingspotfindingstrategy;

import exception.ParkingSpotNotAvailable;
import model.ParkingFloor;
import model.ParkingLot;
import model.ParkingSpot;
import model.ParkingSpotStatus;
import model.VehicleType;
import service.ParkingSpotVehicleTypeMatchingService;

public class RandomParkingSpotFindingStrategy implements ParkingSpotFindingStrategy{
    private ParkingSpotVehicleTypeMatchingService parkingSpotVehicleTypeMatchingService;
    public RandomParkingSpotFindingStrategy(ParkingSpotVehicleTypeMatchingService parkingSpotVehicleTypeMatchingService){
        this.parkingSpotVehicleTypeMatchingService=parkingSpotVehicleTypeMatchingService;
    }

    @Override public ParkingSpot getAvailableSpot(final VehicleType vehicleType, final ParkingLot parkingLot) throws ParkingSpotNotAvailable {
        for(ParkingFloor parkingFloor: parkingLot.getParkingFloors()){
            for(ParkingSpot parkingSpot: parkingFloor.getParkingSpots()){
                if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE) && parkingSpotVehicleTypeMatchingService.matches(parkingSpot.getSpotType(),vehicleType)){
                    return parkingSpot;
                }
            }
        }
        throw new ParkingSpotNotAvailable();
    }
}

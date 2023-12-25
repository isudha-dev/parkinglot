package repository;

import java.util.HashMap;
import java.util.Map;
import exception.ParkingLotAlreadyExistsException;
import exception.ParkingLotNotAvailableException;
import model.Gate;
import model.ParkingLot;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLotMap;
    private Map<Gate, ParkingLot> gateParkingLotMap;

    public ParkingLotRepository(){
        this.parkingLotMap = new HashMap<>();
        this.gateParkingLotMap = new HashMap<>();
    }

    public ParkingLot save(ParkingLot parkingLot) throws ParkingLotAlreadyExistsException, ParkingLotNotAvailableException {
        if(parkingLotMap.containsKey(parkingLot.getId())){
            throw new ParkingLotAlreadyExistsException();
        }
        for(Gate gate: parkingLot.getGates()){
            // todo:
//            getParkingLotFromGate(gate).setGates(gate);
        }
        return parkingLotMap.put(parkingLot.getId(),parkingLot);
    }

    public ParkingLot get(long parkingLotId){
        return parkingLotMap.get(parkingLotId);
    }

    public ParkingLot update(ParkingLot parkingLot){
        return parkingLotMap.put(parkingLot.getId(),parkingLot);
    }

    public ParkingLot getParkingLotFromGate(Gate gate) throws ParkingLotNotAvailableException {
        if(gateParkingLotMap.containsKey(gate))
            return gateParkingLotMap.get(gate);
        else
            throw new ParkingLotNotAvailableException();
    }


}

package models;

import java.util.List;
import java.util.Map;

public class ParkingLot {
    List<ParkingFloor> floors;
    List<Gate> gates;
    int id;
    String name;
    String address;
    Map<VehicleType, Integer> map;

}

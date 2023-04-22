package models;

import java.sql.Time;

public class Ticket {
    int id;
    Vehicle vehicle;
    Time entryTime;
    ParkingSpot parkingSpot;
    Gate gate;
    Operator operator;

}

package dto;

import model.EntryGate;
import model.Vehicle;

public class GenerateTicketRequestDTO {
    private Vehicle vehicle;
    private EntryGate entryGate;

    public GenerateTicketRequestDTO(Vehicle vehicle, EntryGate entryGate){
        this.vehicle = vehicle;
        this.entryGate = entryGate;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(final Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public EntryGate getEntryGate() {
        return entryGate;
    }
    public void setEntryGate(final EntryGate entryGate) {
        this.entryGate = entryGate;
    }
}

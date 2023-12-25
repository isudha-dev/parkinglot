package controller;

import dto.GenerateTicketRequestDTO;
import dto.GenerateTicketResponseDTO;
import exception.ParkingLotNotAvailableException;
import exception.ParkingSpotNotAvailable;
import model.Ticket;
import service.TicketService;

public class TicketController {

    private TicketService ticketService;
    public TicketController(final TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDTO getTicket(GenerateTicketRequestDTO generateTicketRequestDTO) throws ParkingLotNotAvailableException, ParkingSpotNotAvailable {
        Ticket ticket = ticketService.getTicket(generateTicketRequestDTO.getVehicle(), generateTicketRequestDTO.getEntryGate());

        GenerateTicketResponseDTO generateTicketResponseDTO = new GenerateTicketResponseDTO();
        generateTicketResponseDTO.setTicket(ticket);

        return generateTicketResponseDTO;

    }
}

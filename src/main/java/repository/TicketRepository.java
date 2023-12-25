package repository;

import java.util.HashMap;
import java.util.Map;
import model.Ticket;

public class TicketRepository {

    Map<Long, Ticket> ticketMap = new HashMap<>();
    long lastIdCount = 0;

    public Ticket save(Ticket ticket){
        lastIdCount++;
        ticket.setId(lastIdCount );
        ticketMap.put(lastIdCount, ticket);
        return ticket;
    }

}

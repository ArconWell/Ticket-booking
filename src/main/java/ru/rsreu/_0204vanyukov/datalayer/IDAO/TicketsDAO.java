package ru.rsreu._0204vanyukov.datalayer.IDAO;

import ru.rsreu._0204vanyukov.model.Documents;
import ru.rsreu._0204vanyukov.model.Tickets;

import java.util.List;

public interface TicketsDAO {
    List<Tickets> getTickets();
    List<Tickets> getDocumentTickets(Documents document);
    void addTicket(Tickets ticket);
    void updateTicket(Tickets ticket);
    void deleteTicket(Tickets ticket);
    void departureAllowed(Tickets ticket);
    void departureNotAllowed(Tickets ticket);
    void ticketPaid(Tickets ticket);
    void tickedNotPaid(Tickets ticket);
}

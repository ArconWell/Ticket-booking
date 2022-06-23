package ru.rsreu._0204vanyukov.model;

public class Tickets {
    int id;
    int document_id;
    int flight_id;
    Boolean departure_allowed;
    Boolean ticket_paid;

    public Tickets(int id, int document_id, int flight_id, Boolean departure_allowed, Boolean ticket_paid) {
        this.id = id;
        this.document_id = document_id;
        this.flight_id = flight_id;
        this.departure_allowed = departure_allowed;
        this.ticket_paid = ticket_paid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocument_id() {
        return document_id;
    }

    public void setDocument_id(int document_id) {
        this.document_id = document_id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public Boolean getDeparture_allowed() {
        return departure_allowed;
    }

    public void setDeparture_allowed(Boolean departure_allowed) {
        this.departure_allowed = departure_allowed;
    }

    public Boolean getTicket_paid() {
        return ticket_paid;
    }

    public void setTicket_paid(Boolean ticket_paid) {
        this.ticket_paid = ticket_paid;
    }
}

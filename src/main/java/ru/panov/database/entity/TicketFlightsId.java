package ru.panov.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class TicketFlightsId implements Serializable {

    @Column(name = "ticket_no", nullable = false, length = 13)
    private Character ticketNo;

    @Column(name = "flight_id", nullable = false)
    private Integer flightId;
}
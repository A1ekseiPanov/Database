package ru.panov.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.sql.Timestamp;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Check(constraints = "scheduled_arrival > scheduled_departure AND " +
        "(actual_arrival IS NULL OR (actual_departure IS NOT NULL AND actual_arrival > actual_departure)) AND " +
        "status IN ('On Time', 'Delayed', 'Departed', 'Arrived', 'Scheduled', 'Cancelled')")
public class Flights {

    @Id
    @Column(name = "flight_id", nullable = false, columnDefinition = "serial")
    private Long flight_id;

    @Column(name = "flight_no", nullable = false, length = 6)
    private Character flight_no;

    @Column(name = "scheduled_departure", nullable = false)
    private Timestamp scheduledDeparture;

    @Column(name = "scheduled_arrival", nullable = false)
    private Timestamp scheduledArrival;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(name = "actual_departure")
    private Timestamp actualDeparture;

    @Column(name = "actual_arrival")
    private Timestamp actualArrival;

    @ManyToOne
    @JoinColumn(name = "aircraft_code")
    private Aircrafts aircraft;

    @ManyToOne
    @JoinColumn(name = "departure_airport")
    private Airports departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport")
    private Airports arrivalAirport;

    @OneToMany(mappedBy = "flight")
    private List<TicketFlights> ticketFlights;
}
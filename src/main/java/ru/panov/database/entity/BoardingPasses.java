package ru.panov.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "boarding_passes",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_flight_boarding_no", columnNames = {"flight_id", "boarding_no"}),
                @UniqueConstraint(name = "unique_flight_seat_no", columnNames = {"flight_id", "seat_no"})
        })
@Entity
public class BoardingPasses {

    @EmbeddedId
    private BoardingPassesId id;

    @ManyToOne
    @MapsId("ticketNo")
    @JoinColumn(name = "ticket_no")
    private Tickets ticket;

    @ManyToOne
    @MapsId("flightId")
    @JoinColumn(name = "flight_id")
    private Flights flight;

    @Column(name = "boarding_no", nullable = false)
    private Integer boardingNo;

    @Column(name = "seat_no", nullable = false, length = 4)
    private String seatNo;
}
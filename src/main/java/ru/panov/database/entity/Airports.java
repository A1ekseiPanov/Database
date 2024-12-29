package ru.panov.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Airports {
    @Id
    @Column(name = "airport_code", nullable = false, length = 3)
    private Character airportCode;

    @Column(name = "airport_name", nullable = false, columnDefinition = "text")
    private String airportName;

    @Column(nullable = false, columnDefinition = "text")
    private String city;

    @Column(nullable = false)
    private Float longitude;

    @Column(nullable = false)
    private Float latitude;

    @Column(nullable = false, columnDefinition = "text")
    public String timezone;

    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flights> arrivalAirports;

    @OneToMany(mappedBy = "departureAirport")
    private List<Flights> departureAirports;
}
package ru.panov.database.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Embeddable
public class SeatsId implements Serializable {

    @Column(name = "seat_no", nullable = false, length = 4)
    private String seatNo;

    @Column(name = "aircraft_code", nullable = false, length = 3)
    private Character aircraftCode;
}
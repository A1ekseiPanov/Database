package ru.panov.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Check(constraints = "fare_conditions IN ('Economy', 'Comfort', 'Business')")
public class Seats {

    @EmbeddedId
    private SeatsId id;

    @Column(name = "fare_conditions", nullable = false, length = 10)
    private String fareConditions;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @MapsId("aircraftCode")
    @JoinColumn(name = "aircraft_code")
    private Aircrafts aircraft;
}
package ru.panov.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Check(constraints = "range > 0")
public class Aircrafts {

    @Id
    @Column(name = "aircraft_code", nullable = false, length = 3)
    private Character aircraftCode;

    @Column(nullable = false, columnDefinition = "text")
    private String model;

    @Column(nullable = false)
    private Integer range;

    @OneToMany(mappedBy = "aircraft", cascade = CascadeType.ALL)
    private List<Flights> flights;
}
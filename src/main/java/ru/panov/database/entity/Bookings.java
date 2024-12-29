package ru.panov.database.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bookings {
    @Id
    @Column(name = "book_ref", nullable = false, length = 6)
    private Character bookRef;

    @Column(name = "book_date", nullable = false)
    private Timestamp bookDate;

    @Column(name = "total_amount", nullable = false, scale = 2, precision = 10)
    private BigDecimal totalAmount;

    @OneToMany(mappedBy = "booking")
    private List<Tickets> tickets;
}
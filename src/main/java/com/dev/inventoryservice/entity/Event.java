package com.dev.inventoryservice.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "event")
public class Event {

    @Id
    private Long id;
    private String name;
    private Long totalCapacity;
    private Long leftCapacity;
    private BigDecimal ticketPrice;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;
}

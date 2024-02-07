package com.smart.parking.client.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "slots")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Slots {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String PlaceCode;
    private String description;
    @ManyToOne(fetch = FetchType.EAGER)
    private TypeSlots typeSlots;
}

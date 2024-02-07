package com.smart.parking.client.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double lat;
    private Double lng;
    private String description;
    private String mode;
    private boolean is_active;
    private String Search_name;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Options> options ;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<TypeVehicles> typeVehicles;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Slots> slots;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ParkPictures> pictures;
    private int capacity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ParkZone parkZone;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private City city;
}

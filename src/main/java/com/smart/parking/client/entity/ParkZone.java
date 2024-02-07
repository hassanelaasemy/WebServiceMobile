package com.smart.parking.client.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
@Entity
@Table(name = "parkzone")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParkZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double lat;
    private Double lng;
    @OneToMany(mappedBy = "parkZone",fetch = FetchType.LAZY)
    private Set<Parking> parking;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id")
    @JsonIgnore
    private Zone zone;


}

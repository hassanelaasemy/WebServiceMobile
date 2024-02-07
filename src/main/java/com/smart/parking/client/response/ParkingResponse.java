package com.smart.parking.client.response;

import com.smart.parking.client.entity.Options;
import com.smart.parking.client.entity.ParkPictures;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingResponse {
    private Long id;
    private String name;
    private Double lat;
    private Double lng;
    private String description;
    private String mode;
    private ParkPictures pictures;
    private Set<ParkPictures> parkPictures;
    private Set<Options> options;
    private int capacity;
    private String address;
    private String street;
    private String rating;
    private boolean favorite;
}

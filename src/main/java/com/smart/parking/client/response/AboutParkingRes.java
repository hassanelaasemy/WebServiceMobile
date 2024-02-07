package com.smart.parking.client.response;

import com.smart.parking.client.entity.ParkPictures;
import com.smart.parking.client.entity.Rating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AboutParkingRes {

    private Long id;
    private String name;
private Double lat;
    private Double lng;
    private String description;
    private String mode;
    private ParkPictures pictures;
    private int capacity;
    private String address;
    private String street;
    private String rating;
    private boolean favorite;

}

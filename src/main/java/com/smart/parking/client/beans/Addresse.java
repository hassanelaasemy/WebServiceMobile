package com.smart.parking.client.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Addresse {
    private String country;
    private Double lat;
    private Double lng;
    private String city;
    private String neighborhood;
}

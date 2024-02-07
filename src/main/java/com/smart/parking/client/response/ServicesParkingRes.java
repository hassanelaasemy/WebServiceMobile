package com.smart.parking.client.response;

import com.smart.parking.client.entity.Options;
import com.smart.parking.client.entity.TypeVehicles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServicesParkingRes {
    private Long id;
    private Set<TypeVehicles> typeVehicles;
    private Set<Options> options;
    private int capacity;
}

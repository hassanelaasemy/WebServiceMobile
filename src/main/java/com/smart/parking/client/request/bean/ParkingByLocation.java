package com.smart.parking.client.request.bean;

import com.smart.parking.client.beans.Location;
import com.smart.parking.client.interfaces.IBean;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingByLocation implements IBean {
        private Location location;
}

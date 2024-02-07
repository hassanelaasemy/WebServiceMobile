package com.smart.parking.client.request.bean;

import com.smart.parking.client.beans.Location;
import com.smart.parking.client.interfaces.IBean;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingListRequest implements IBean {
private String country;
private String city;
private Location location;
}

package com.smart.parking.client.request;

import com.smart.parking.client.beans.MetaData;
import com.smart.parking.client.interfaces.IBean;
import com.smart.parking.client.request.bean.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GeneralRequest {
    private MetaData metaData;
    private Date timeStamps;
    private RegisterRequest register;
    private LoginRequest login;
    private ParkingListRequest listParking;
    private ReviewsRequest reviews;
    private UserUpdateRequest userUpdateRequest;
    private UpdateAvatarRequest updateAvatarRequest;
}

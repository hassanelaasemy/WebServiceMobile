package com.smart.parking.client.response;

import com.smart.parking.client.beans.ReviewsBean;
import com.smart.parking.client.entity.Rating;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewsParkingRes {
    private Long id;
    private List<Rating> reviews;
}

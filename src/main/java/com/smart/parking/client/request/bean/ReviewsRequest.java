package com.smart.parking.client.request.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewsRequest {
    private Long parking;
    private String description;
    private double rating;
}

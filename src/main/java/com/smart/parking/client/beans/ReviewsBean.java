package com.smart.parking.client.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewsBean {
    private Long id;
    private String user;
    private Double rating;
    private String description;
    private boolean status;
}

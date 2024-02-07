package com.smart.parking.client.controller;

import com.smart.parking.client.request.GeneralRequest;
import com.smart.parking.client.response.GeneralResponse;
import com.smart.parking.client.services.ParkingService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/reviews/parking")
public class ReviewController {

    private final ParkingService parkingService;

    public ReviewController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @GetMapping("/find/{id}/byauth")
    public ResponseEntity<?> authReviewParkingByID(@PathVariable("id") Long id ,  @NonNull HttpServletRequest request){
        return ResponseEntity.ok().body(parkingService.authRatingByParking(id , request));
    }

    @PostMapping("/manage/byid")
    public ResponseEntity<?> InsertReviewParkingByID(@RequestBody GeneralRequest generalRequest, @NonNull HttpServletRequest request){
        return ResponseEntity.ok().body(parkingService.ManageReviewParkingByID(generalRequest , request));
    }

    @PostMapping("/delete/byid")
    public ResponseEntity<?> DeleteReviewParkingByID(@RequestBody GeneralRequest generalRequest, @NonNull HttpServletRequest request){
        return ResponseEntity.ok().body(parkingService.DeleteReviewParkingByID(generalRequest , request));
    }
}


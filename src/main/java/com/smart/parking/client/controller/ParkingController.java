package com.smart.parking.client.controller;


import com.smart.parking.client.entity.Parking;
import com.smart.parking.client.request.GeneralRequest;
import com.smart.parking.client.response.ParkingResponse;
import com.smart.parking.client.services.ParkingService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/parking")
public class ParkingController {
    private final ParkingService parkingService;
    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    @PostMapping("/byCity")
    public ResponseEntity<?> parkingbyCity(@RequestBody GeneralRequest request ,  @NonNull HttpServletRequest httpServletRequest){
        return ResponseEntity.ok().body(parkingService.findParkingByCity(request , httpServletRequest));
    }

    /*@PostMapping("/bylocation")
    public ResponseEntity<?> parkingbylocation(@RequestBody GeneralRequest request){
        return ResponseEntity.ok().body(parkingService.findParkingByLocation(request));
    } */

    @GetMapping("/byid/{id}/about")
    public ResponseEntity<?> DisplayAboutParkingByID(@PathVariable("id") Long id , @NonNull HttpServletRequest request){
        return ResponseEntity.ok().body(parkingService.GetAboutParkingById(id , request));
    }

    @GetMapping("/byid/{id}/services")
    public ResponseEntity<?> DisplayServicesParkingByID(@PathVariable("id") Long id ){
        return ResponseEntity.ok().body(parkingService.GetServicesParkingById(id));
    }

    @GetMapping("/byid/{id}/media")
    public ResponseEntity<?> DisplayMediaParkingByID(@PathVariable("id") Long id ){
        return ResponseEntity.ok().body(parkingService.GetMediaParkingById(id));
    }
    @GetMapping("/byid/{id}/reviews")
    public ResponseEntity<?> DisplayReviewsParkingByID(@PathVariable("id") Long id ){
        return ResponseEntity.ok().body(parkingService.GetReviewsParkingById(id));
    }

    @GetMapping("/auth/favorite")
    public ResponseEntity<?> AuthFavoriteParkingByID(@NonNull HttpServletRequest request){
        return ResponseEntity.ok().body(parkingService.AuthFavoriteParkingByID(request));
    }

    @GetMapping("/byid/{id}/favorite")
    public ResponseEntity<?> FavoriteParkingByID(@PathVariable("id") Long id , @NonNull HttpServletRequest request){
        return ResponseEntity.ok().body(parkingService.FavoriteParkingByID(id , request));
    }
}

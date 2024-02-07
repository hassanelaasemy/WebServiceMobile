package com.smart.parking.client.controller;

import com.smart.parking.client.entity.CarUser;
import com.smart.parking.client.services.CarService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v2/car")
public class CarController {
    private CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }


    @PostMapping("/add")
    public ResponseEntity<CarUser> addCar(@RequestBody CarUser car , @NonNull HttpServletRequest request) {
        CarUser addedCar = carService.addCar(car , request);
        return new ResponseEntity<>(addedCar, HttpStatus.CREATED);
    }

    @GetMapping("/getcar")
    public ResponseEntity<CarUser> getCarByUser(@NonNull HttpServletRequest request) {
        return new ResponseEntity<>(carService.getCarByUser(request), HttpStatus.OK);
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<CarUser> getCarById(@PathVariable Long id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }*/


}

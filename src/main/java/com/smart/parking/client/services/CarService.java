package com.smart.parking.client.services;

import com.smart.parking.client.entity.Auth;
import com.smart.parking.client.entity.CarUser;
import com.smart.parking.client.repository.AuthRepository;
import com.smart.parking.client.repository.CarRepository;
import com.smart.parking.client.secuirity.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CarService {
    private CarRepository carRepository;
    private AuthRepository authRepository;
    private final JWTUtil jwtUtil ;


    public CarService(CarRepository carRepository , AuthRepository authRepository, JWTUtil jwtUtil) {
        this.carRepository = carRepository;
        this.authRepository = authRepository;
        this.jwtUtil = jwtUtil;
    }

    public CarUser addCar(CarUser car , HttpServletRequest request) {
        String AuthHeader =request.getHeader("Authorization");
        String Token =AuthHeader.substring(7);
        String username = jwtUtil.extractUsername(Token);
        Auth auth = authRepository.findAuthByEmail(username).orElseThrow();
        car.setAuth(auth);
        return carRepository.save(car);
    }

    public CarUser getCarByUser(HttpServletRequest request) {
        String AuthHeader =request.getHeader("Authorization");
        String Token =AuthHeader.substring(7);
        String username = jwtUtil.extractUsername(Token);
        System.out.println(username);
        Auth auth = authRepository.findAuthByEmail(username).orElseThrow();
        System.out.println(auth.getId());
        ArrayList<CarUser> carUser = carRepository.GetCarUserByAuth(auth.getId());
        System.out.println(carUser.size());
        return carUser.size() != 0 ? carUser.get(carUser.size() - 1) : null;

    }

    public CarUser getCarById(Long car, HttpServletRequest request) {
        Optional<CarUser> carUser = carRepository.findById(car);
        return carUser.map(value -> value)
                .orElseThrow(() -> new UsernameNotFoundException("Not Found"));
    }
}

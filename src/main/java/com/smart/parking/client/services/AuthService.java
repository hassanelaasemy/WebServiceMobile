package com.smart.parking.client.services;

import com.smart.parking.client.beans.User;
import com.smart.parking.client.entity.Auth;
import com.smart.parking.client.exception.ApiRequestException;
import com.smart.parking.client.repository.AuthRepository;
import com.smart.parking.client.request.GeneralRequest;
import com.smart.parking.client.response.GeneralResponse;
import com.smart.parking.client.response.LoginResponse;
import com.smart.parking.client.secuirity.JWTUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final  JWTUtil jwtUtil ;
    private final AuthenticationManager authenticationManager;
    public AuthService(AuthRepository authRepository, PasswordEncoder passwordEncoder, JWTUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    public GeneralResponse Register(GeneralRequest request){
        Optional<Auth> auth= authRepository.findAuthByEmail(request.getRegister().getEmail());
        if(auth.isPresent()){
            throw new ApiRequestException("Email Already Exists ");
        }
        Auth user = Auth.builder()
                .firstName(request.getRegister().getFirstName())
                .lastName(request.getRegister().getLastName())
                .email(request.getRegister().getEmail())
                .pwd(passwordEncoder.encode(request.getRegister().getPassword()))
                .build();
        authRepository.save(user);
        return GeneralResponse.builder().message("success").build();
    }


    public LoginResponse Login(GeneralRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin().getEmail(),
                        request.getLogin().getPassword()
                )
        );

        Auth auth = authRepository.findAuthByEmail(request.getLogin().getEmail()).orElseThrow(
                ()-> new ApiRequestException("Username Or password incorecct")
        );


        String jwtToken = jwtUtil.generateToken(auth , "ACCESS-TOKEN");
        String refreshToken = jwtUtil.generateToken(auth , "REFRESH-TOKEN");

        return LoginResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).user(User.builder().username(auth.getUsername()).avatar(auth.getAvatar()).firstName(auth.getFirstName()).lastName(auth.getLastName()).build()).build();
    }



}

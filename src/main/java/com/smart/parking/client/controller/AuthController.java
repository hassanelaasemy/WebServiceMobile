package com.smart.parking.client.controller;

import com.smart.parking.client.request.GeneralRequest;
import com.smart.parking.client.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @GetMapping("/user")
    public ResponseEntity<?> userresponse (){
        return  ResponseEntity.ok().body("ok success");
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerResponse(@Valid @RequestBody GeneralRequest generalRequest){
        System.out.println(generalRequest.getRegister().getPassword());
        return ResponseEntity.ok().body(authService.Register(generalRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginResponse(@Valid @RequestBody GeneralRequest generalRequest){
        return ResponseEntity.ok().body(authService.Login(generalRequest));
    }

}

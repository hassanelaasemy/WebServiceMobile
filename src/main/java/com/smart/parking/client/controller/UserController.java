package com.smart.parking.client.controller;


import com.smart.parking.client.request.GeneralRequest;
import com.smart.parking.client.services.AuthService;
import com.smart.parking.client.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("info")
    public ResponseEntity<?> getUserinfo(@NonNull HttpServletRequest request){
       return ResponseEntity.ok().body(userService.getUserinfo(request));
    }

    @PostMapping("update/info")
    public ResponseEntity<?> updateInfo(@RequestBody GeneralRequest generalRequest, @NonNull HttpServletRequest request){
        return ResponseEntity.ok().body(userService.updateInfo(generalRequest , request));
    }

    @PostMapping("update/avatar")
    public ResponseEntity<?> updateAvatar(@RequestBody GeneralRequest generalRequest, @NonNull HttpServletRequest request){
        return ResponseEntity.ok().body(userService.updateAvatar(generalRequest , request));
    }

}

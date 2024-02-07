package com.smart.parking.client.request.bean;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class LogoutRequest {
    @NotBlank(message = "Refresh Token is required")
    private String refreshToken;
}

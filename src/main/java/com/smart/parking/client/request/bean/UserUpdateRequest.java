package com.smart.parking.client.request.bean;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateRequest {
    @NotBlank(message = "Login field is required")
    private String firstName;
    @NotBlank(message = "Login field is required")
    private String lastName;
    @NotBlank(message = "Login field is required")
    @Pattern(regexp = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$", message = "Invalid email format")
    private String email ;

}

package com.smart.parking.client.request.bean;

import com.smart.parking.client.interfaces.IBean;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest{
    @NotBlank(message = "Login field is required")
    private String firstName;
    @NotBlank(message = "Login field is required")
    private String lastName;
    @NotBlank(message = "Login field is required")
    @Pattern(regexp = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$", message = "Invalid email format")
    private String email ;
    @Size(min = 8, message = "Password length must be more than 8 characters")
    @NotNull(message = "Password field is required")
    @NotBlank(message = "Password cannot be blank")
    private String password;
}

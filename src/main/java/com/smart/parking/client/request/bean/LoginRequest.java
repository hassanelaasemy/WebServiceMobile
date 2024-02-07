package com.smart.parking.client.request.bean;

import com.smart.parking.client.interfaces.IBean;
import lombok.*;
import jakarta.validation.constraints.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest implements IBean {
    @NotBlank(message = "Login field is required")
    @Pattern(regexp = "^[\\w\\.-]+@[\\w\\.-]+\\.\\w+$", message = "Invalid email format")
    private String email ;
    @Size(min = 8, message = "Password length must be more than 8 characters")
    @NotNull(message = "Password field is required")
    @NotBlank(message = "Password cannot be blank")
    private String password;
}

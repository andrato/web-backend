package com.shop.project.payload.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.constraints.*;

@Getter
@Setter
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    private Set<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @Max(50)
    private String      firstName;

    @Max(50)
    private String      lastName;

    @Max(50)
    private String      city;;

    @Max(50)
    private String      country;

    private LocalDate birth_date;
}

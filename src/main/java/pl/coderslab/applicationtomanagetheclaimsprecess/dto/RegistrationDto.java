package pl.coderslab.applicationtomanagetheclaimsprecess.dto;

import lombok.Data;

@Data
public class RegistrationDto {

    private Long id;
    private String login;
    private String email;
    private String password;
}


package pl.coderslab.applicationtomanagetheclaimsprecess.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class LoginController {
    @GetMapping(path = "/login", produces = "text/plain;charset=utf-8")
    public String loginPage() {
        return "login";
    }
}
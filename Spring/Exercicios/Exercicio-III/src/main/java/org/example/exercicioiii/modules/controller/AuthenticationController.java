package org.example.exercicioiii.modules.controller;

import org.example.exercicioiii.modules.security.AuthenticationService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public String authenticate(Authentication authentication){
        return authenticationService.authenticate(authentication);
    }
}

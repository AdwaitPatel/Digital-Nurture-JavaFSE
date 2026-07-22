package com.cognizant.jwt_security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/authenticate")
    public String authenticate() {

        LOGGER.info("START");
        LOGGER.info("END");

        return "Authenticated Successfully";
    }
}
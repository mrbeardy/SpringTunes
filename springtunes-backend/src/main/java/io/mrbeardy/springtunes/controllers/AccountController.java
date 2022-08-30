package io.mrbeardy.springtunes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AccountController.EndpointPath)
public class AccountController {
    public static final String EndpointPath = "/api/account";

    @GetMapping()
    public String index() {
        return "Account area";
    }

}

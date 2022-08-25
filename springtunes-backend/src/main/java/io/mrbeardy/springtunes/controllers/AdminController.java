package io.mrbeardy.springtunes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AdminController.EndpointPath)
public class AdminController {
    public static final String EndpointPath = "/api/admin";

    @GetMapping("")
    public String index() {
        return "Admin area";
    }

}

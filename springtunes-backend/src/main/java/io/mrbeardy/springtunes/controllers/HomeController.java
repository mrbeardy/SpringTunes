package io.mrbeardy.springtunes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(HomeController.EndpointPath)
public class HomeController {
        public static final String EndpointPath = "/api/home";

    @GetMapping("")
    public String index() {
        return "Hello World";
    }

}

package cz.tomaskopulety.bookstore.controller;

import cz.tomaskopulety.bookstore.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainPageController {
    private final Service service;

    @Autowired
    public MainPageController(Service service) {
        this.service = service;
    }

    @GetMapping
    public String getWelcomeMessage() {
        return service.getWelcomeMessage();
    }
}

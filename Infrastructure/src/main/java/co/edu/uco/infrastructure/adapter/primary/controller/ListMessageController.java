package co.edu.uco.infrastructure.adapter.primary.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class ListMessageController {

    @GetMapping
    public void execute() {

    }
}

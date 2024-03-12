package com.springBoot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/service-health")
    public String serviceHealth(){
        return "MicroService2 is up";
    }
}

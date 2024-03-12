package com.springBoot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Controller {
    @GetMapping("/service-health")
    public String serviceHealth(){
        return "MicroService1 is up";
    }

    @GetMapping("/getfromservice2")
    public String getfromservice2(){
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> call= template.getForEntity("http://microservice2:8020/service-health",String.class);
        return call.getBody();
    }
}
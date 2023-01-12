package com.ericsson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    @GetMapping("/provider")
    public String test(){
        return "{'nanme': 'tom', 'age': '20'}";
    }
}

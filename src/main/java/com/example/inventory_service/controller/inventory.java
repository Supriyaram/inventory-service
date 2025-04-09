package com.example.inventory_service.controller;


import com.example.inventory_service.models.Version;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class inventory {

    @GetMapping("/v1/inventory-service")
    public Version getV1(){
        return new Version("v1","inventory-service") ;
    }

    @GetMapping("v2/inventory-service")
    public Version getV2(){
        return new Version("v2", "inventory-service") ;
    }
}

package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import com.example.demo.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    Service service;

    @GetMapping("/teste200")
    public Cliente teste200(){
        return service.buscar200();
    }

    @GetMapping("/teste500")
    public Cliente teste500(){
        return service.buscar500();
    }
}

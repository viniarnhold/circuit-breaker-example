package com.example.demo.service;

import com.example.demo.domain.Cliente;
import com.example.demo.feign.ClienteFeign;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Service {
    @Autowired
    ClienteFeign clienteFeign;

    Integer count = 1;

    @CircuitBreaker(name="demo", fallbackMethod = "fallback")
    public Cliente buscar200(){
        return clienteFeign.buscar200();
    }

    @CircuitBreaker(name="demoCB", fallbackMethod = "fallback")
    public Cliente buscar500(){
        log.info("Tentativa {}", count);
        count++;
        return clienteFeign.buscar500();
    }

    public Cliente fallback(Exception e){
        log.info("CIRCUITO FECHADO!");
        return new Cliente("Joaozinho tá aprontando no sistema", 99999, 8);
    }
}

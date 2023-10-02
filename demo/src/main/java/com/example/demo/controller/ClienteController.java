package com.example.demo.controller;

import com.example.demo.domain.Cliente;
import com.example.demo.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/buscar-cliente-ok")
    @ResponseStatus(HttpStatus.OK)
    public Cliente buscarClienteOk() throws Exception {
        return clienteService.buscarCliente();
    }

    @GetMapping("/erro")
    public Cliente buscarClienteComFalha() throws Exception {
        return clienteService.buscarClienteErroTentativas();
    }
}

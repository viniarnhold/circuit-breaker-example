package com.example.demo.service;

import com.example.demo.domain.Cliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClienteService {
    private Integer count500 = 0;
    public Cliente buscarCliente() throws Exception {
        Cliente cliente = new Cliente("Joaquim", 12345, 20);
        count500 = 0;
        log.info("500 - Contador zerado");
        return cliente;
    }

    public Cliente buscarClienteErroTentativas() throws Exception {
        Cliente cliente = new Cliente("Olivia", 54321, 30);
        if(count500 < 5){
            log.info("500 - Tentativa {}", count500);
            count500++;
            return cliente;
        } else {
            throw new Exception("Busca retornou um erro");
        }
    }
}

package com.example.demo.feign;

import com.example.demo.domain.Cliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "BuscaStatus", url = "localhost:8081")
public interface ClienteFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/buscar-cliente-ok")
    Cliente buscar200();

    @RequestMapping(method = RequestMethod.GET, value = "/erro")
    Cliente buscar500();
}

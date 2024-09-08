package com.example.banco.controller;

import com.example.banco.model.Banco;
import com.example.banco.service.BancoService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/banco")
public class BancoController {

    @Autowired
    private BancoService service;

    @PostMapping
    public ResponseEntity<Banco> createBanco(@RequestBody Banco banco){
        banco = service.createBanco(banco);
        System.out.println("oiiiiiii");
        return ResponseEntity.ok().body(banco);
    }
}

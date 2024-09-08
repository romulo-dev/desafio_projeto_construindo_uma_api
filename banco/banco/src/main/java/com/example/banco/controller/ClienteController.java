package com.example.banco.controller;

import com.example.banco.model.Cliente;
import com.example.banco.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    @CrossOrigin("*")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        cliente = service.createCliente(cliente);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> verDados(@PathVariable Long id){
        Optional<Cliente> cliente = service.verExtrato(id);

        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/deposito/{id}")
    public ResponseEntity<String> depositar(Double valor, @PathVariable Long id){
        String mensagem = service.depositarConta(valor, id);

        return ResponseEntity.ok().body(mensagem);
    }
}

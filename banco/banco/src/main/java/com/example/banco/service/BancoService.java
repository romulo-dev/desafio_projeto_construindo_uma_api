package com.example.banco.service;

import com.example.banco.model.Banco;
import com.example.banco.repository.BancoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BancoService {

    @Autowired
    private BancoRepository repository;

    public Banco createBanco(Banco banco){
        return repository.save(banco);
    }
}

package com.example.banco.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String CPF;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Conta> contasCliente = new HashSet<>();

    public Cliente() {
    }

    public Cliente(String nome, String CPF, Set<Conta> contasCliente) {
        this.nome = nome;
        this.CPF = CPF;
        this.contasCliente = contasCliente;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Set<Conta> getContasCliente() {
        return contasCliente;
    }

    public void setContasCliente(Set<Conta> contasCliente) {
        this.contasCliente = contasCliente;
    }
}

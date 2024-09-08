package com.example.banco.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Banco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "banco", cascade = CascadeType.ALL)
    private Set<Agencia> agencias = new HashSet<>();

    public Banco() {
    }

    public Banco(String nome) {
        this.nome = nome;
    }

    public Banco(Long id, String nome, Set<Agencia> agencias) {
        this.id = id;
        this.nome = nome;
        this.agencias = agencias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(Set<Agencia> agencias) {
        this.agencias = agencias;
    }


}

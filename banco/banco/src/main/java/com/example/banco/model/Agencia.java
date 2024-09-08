package com.example.banco.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Agencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long codigo_agencia;
    private String cidade;
    private String bairro;
    private String rua;
    private long numero;


    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL)
    private Set<Conta> contas = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "banco_id")
    private Banco banco;

    public Agencia() {
    }

    public Agencia(long id, long codigo_agencia, String cidade, String bairro, String rua, long numero, Set<Conta> contas, Banco banco) {
        this.id = id;
        this.codigo_agencia = codigo_agencia;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.contas = contas;
        this.banco = banco;
    }

    public Agencia(long codigo_agencia, String cidade, String bairro, String rua, long numero, Banco banco) {
        this.codigo_agencia = codigo_agencia;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.banco = banco;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCodigo_agencia() {
        return codigo_agencia;
    }

    public void setCodigo_agencia(long codigo_agencia) {
        this.codigo_agencia = codigo_agencia;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Set<Conta> getContas() {
        return contas;
    }

    public void setContas(Set<Conta> contas) {
        this.contas = contas;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public static Agencia obterDadosAgencia(Agencia agencia){
        return new Agencia(
                agencia.getCodigo_agencia(),
                agencia.getCidade(),
                agencia.getBairro(),
                agencia.getRua(),
                agencia.getNumero(),
                new Banco(agencia.getBanco().getNome()));
    }
}

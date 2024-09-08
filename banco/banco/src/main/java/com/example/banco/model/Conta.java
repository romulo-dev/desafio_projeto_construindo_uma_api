package com.example.banco.model;

import jakarta.persistence.*;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double valor = 0.00;

    private String tipo_conta;

    private String numeroConta;

    @ManyToOne
    @JoinColumn(name = "agencia_id")
    private Agencia agencia;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    public Conta() {
    }

    public Conta(long id, double valor, String tipo_conta, String numeroConta, Agencia agencia, Cliente cliente) {
        this.id = id;
        this.valor = valor;
        this.tipo_conta = tipo_conta;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.cliente = cliente;
    }

    public Conta(long id, double valor, String tipo_conta, String numeroConta, Agencia agencia) {
        this.id = id;
        this.valor = valor;
        this.tipo_conta = tipo_conta;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
    }

    public Conta(long id, double valor, Cliente cliente, Agencia agencia, String numeroConta, String tipo_conta) {
        this.id = id;
        this.valor = valor;
        this.cliente = cliente;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.tipo_conta = tipo_conta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo_conta() {
        return tipo_conta;
    }

    public void setTipo_conta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void depositar(Double valor){
        this.valor += valor;
    }
}

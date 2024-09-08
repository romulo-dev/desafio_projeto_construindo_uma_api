package com.example.banco.service;

import com.example.banco.model.Agencia;
import com.example.banco.model.Cliente;
import com.example.banco.model.Conta;
import com.example.banco.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente createCliente(Cliente cliente){
        return repository.save(cliente);
    }

    @Transactional()
    public Optional<Cliente> verExtrato(Long id){

        Optional<Cliente> cliente = repository.findById(id);
        Set<Conta> contasTemp = new HashSet<>();

        for(Conta conta: cliente.get().getContasCliente()){
            contasTemp.add(new Conta(
                    conta.getId(),
                    conta.getValor(),
                    conta.getTipo_conta(),
                    conta.getNumeroConta(),
                    Agencia.obterDadosAgencia(conta.getAgencia())
            ));
        }

        cliente = Optional.of(new Cliente(
                cliente.get().getId(),
                cliente.get().getNome(),
                cliente.get().getCPF(),
                contasTemp));
        return cliente;
    }

    public String depositarConta(Double valor, Long id) {
        Optional<Cliente> cliente = repository.findById(id);

        if (cliente.isPresent() && valor > 0.00) {
            // Converter o Set de contas em uma lista
            List<Conta> contasList = new ArrayList<>(cliente.get().getContasCliente());

            // Agora você pode acessar pelo índice
            Conta conta = contasList.get(id.intValue());
            conta.depositar(valor);

            return "Depósito realizado com sucesso";
        }
        else{
            return "Ocorreu um erro";
        }

    }

    public String sacar(Double valor, Long id){
        Optional<Cliente> cliente = repository.findById(id);

        if (cliente.isPresent() && valor > 0.00 ) {
            List<Conta> contasList = new ArrayList<>(cliente.get().getContasCliente());

            Conta conta = contasList.get(id.intValue());
            if(valor >= conta.getValor()){
                conta.setValor(conta.getValor() - valor);
                return "Saque realizado com sucesso";
            }
            else{
                return "Saque inválido o valor do saque é maior que o saldo da conta";
            }
        }
        else{
            return "Ocorreu um erro";
        }
    }


}

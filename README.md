# Desafio de projeto da DIO: Publicando Sua API REST na Nuvem Usando Spring Boot 3, Java 17 e Railway

Eu comecei criar um sistema bancário com as classes Banco, Agencia, Conta e Cliente. O Banco possui os atributos id, nome e um conjunto (Set<T>) de agências; a classe Agencia possui os atributos id, codigo_agencia, cidade, bairro, rua, numero e um conjunto de contas; a entidade Cliente possui também um conjunto de contas, nome e CPF; a entidade Conta possui valor, tipo_conta, numeroConta e também possui atributos de relacionamento com Cliente e Agencia. Foram criados relacionamentos OneToMany e ManyToOne entres as entidades. Foi implementado os pacotes repository, service, model e controller respeitando o padrão arquitetural MVC. O sistema possui funções para criar um Banco e Cliente também. Em clienteService foram criados me´todos para depositar, ver extrato e sacar.

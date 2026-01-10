package br.com.banco;

import br.com.banco.model.Cliente;
import br.com.banco.model.Conta;
import br.com.banco.service.BancoService;

public class Main {
    public static void main(String[] args) {

    	BancoService banco = new BancoService();

    	Cliente pedro = new Cliente("Pedro", "123");
    	Conta c1 = banco.criarContaCorrente(pedro);
    	Conta c2 = banco.criarContaPoupanca(new Cliente("Maria", "456"));

    	c1.depositar(1000);
    	banco.transferir(c1.getNumero(), c2.getNumero(), 300);

    	System.out.println("Saldo Pedro: " + c1.getSaldo());
    	System.out.println("Saldo Maria: " + c2.getSaldo());
    }
}
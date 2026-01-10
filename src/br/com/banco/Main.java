package br.com.banco;

import br.com.banco.model.*;
import br.com.banco.exception.SaldoInsuficienteException;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Pedro", "123.456.789-00");
        Conta conta = new ContaCorrente(1, cliente);

        conta.depositar(10000);

        try {
            conta.sacar(50);
        } catch (SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        System.out.println("Saldo atual: " + conta.getSaldo());
    }
}

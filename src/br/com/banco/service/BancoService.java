package br.com.banco.service;

import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.*;

public class BancoService {
	
	private List<Conta> contas = new ArrayList<>();
	private int proximoNumero = 1;
	
	//Cria conta corrente
	public Conta criarContaCorrente(Cliente cliente) {
		Conta conta = new ContaCorrente(proximoNumero++, cliente);
		contas.add(conta);
		return conta;
	}
	
	//Cira conta poupanca
	public Conta criarContaPoupanca(Cliente cliente) {
		Conta conta = new ContaPoupanca(proximoNumero++, cliente);
		contas.add(conta);
		return conta;
	}
	
	public Conta buscarConta(int numero) {
		for (Conta conta : contas) {
			if (conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}
	
}

package br.com.banco.service;

import java.util.ArrayList;
import java.util.List;

import br.com.banco.model.*;

public class BancoService {
	
	private List<Conta> contas = new ArrayList<>();
	private int proximoNumero = 1;
	
	public Conta criarContaCorrente(Cliente cliente) {
		Conta conta = new ContaCorrente(proximoNumero++, cliente);
		contas.add(conta);
		return conta;
	}
	
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
	
	public void transferir(int origem, int destino, double valor) {
		Conta contaOrigem = buscarConta(origem);
		Conta contaDestino = buscarConta(destino);
		
		if (contaOrigem == null || contaDestino == null) {
			throw new RuntimeException("Conta não encontrada");
		}
		contaOrigem.sacar(valor);
		contaDestino.depositar(valor);
	}
	//Lista todas as contas (pra teste)
	public List<Conta> listarContas(){
		return contas;
	}
}

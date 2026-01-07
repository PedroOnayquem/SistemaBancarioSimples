package br.com.banco.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected List<Transacao> transacoes = new ArrayList<>();
	
	public Conta(int numero, Cliente cliente ) {
		this.numero = numero;
		this.cliente = cliente;
		this.saldo = 0.0;
	}
	
	public abstract void sacar(double valor);
	
	public void depositar(double valor) {
		saldo += valor;
		transacoes.add(new Transacao(TipoTransacao.DEPOSITO, valor));
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public List<Transacao> getTransacoes(){
		return transacoes;
	}
}

package br.com.banco.model;

import br.com.banco.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta {
	public ContaCorrente(int numero, Cliente cliente) {
		super(numero, cliente);
	}
	
	@Override
	public void sacar(double valor) {
		if (valor > saldo) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
		saldo -= valor;
		transacoes.add(new Transacao(TipoTransacao.SAQUE, valor));
	}
}

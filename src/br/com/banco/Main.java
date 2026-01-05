package br.com.banco;

import br.com.banco.model.*;

public class Main {
	public static void main(String[] args) {
		Cliente cliente = new Cliente("Pedro", "123.123.123-44");
		
		System.out.println(cliente.getNome());
		System.out.println(cliente.getCpf());
	}
}

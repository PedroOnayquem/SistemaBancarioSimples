package br.com.banco;

import java.util.Scanner;

import br.com.banco.model.Cliente;
import br.com.banco.model.Conta;
import br.com.banco.service.BancoService;

public class Main {

    public static void main(String[] args) {

        BancoService banco = new BancoService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== BANCO =====");
            System.out.println("1 - Criar conta corrente");
            System.out.println("2 - Criar conta poupança");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sacar");
            System.out.println("5 - Transferir");
            System.out.println("6 - Listar contas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            try {
                switch (opcao) {
                    case 1:
                        System.out.print("Nome: ");
                        String nomeCC = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpfCC = sc.nextLine();

                        Conta cc = banco.criarContaCorrente(new Cliente(nomeCC, cpfCC));
                        System.out.println("Conta criada: " + cc.getNumero());
                        break;

                    case 2:
                        System.out.print("Nome: ");
                        String nomeCP = sc.nextLine();
                        System.out.print("CPF: ");
                        String cpfCP = sc.nextLine();

                        Conta cp = banco.criarContaPoupanca(new Cliente(nomeCP, cpfCP));
                        System.out.println("Conta criada: " + cp.getNumero());
                        break;

                    case 3:
                        System.out.print("Conta: ");
                        int contaDep = sc.nextInt();
                        System.out.print("Valor: ");
                        double valorDep = sc.nextDouble();

                        Conta contaDeposito = banco.buscarConta(contaDep);

                        if (contaDeposito == null) {
                            System.out.println("Conta não encontrada.");
                            break;
                        }

                        contaDeposito.depositar(valorDep);
                        System.out.println("Depósito realizado.");
                        System.out.println("Saldo atual: " + contaDeposito.getSaldo());
                        break;

                    case 4:
                        System.out.print("Conta: ");
                        int contaSaq = sc.nextInt();
                        System.out.print("Valor: ");
                        double valorSaq = sc.nextDouble();

                        Conta contaSaque = banco.buscarConta(contaSaq);

                        if (contaSaque == null) {
                            System.out.println("Conta não encontrada.");
                            break;
                        }

                        contaSaque.sacar(valorSaq);
                        System.out.println("Saque realizado.");
                        System.out.println("Saldo atual: " + contaSaque.getSaldo());
                        break;


                    case 5:
                        System.out.print("Conta origem: ");
                        int origem = sc.nextInt();
                        System.out.print("Conta destino: ");
                        int destino = sc.nextInt();
                        System.out.print("Valor: ");
                        double valor = sc.nextDouble();

                        Conta cOrigem = banco.buscarConta(origem);
                        Conta cDestino = banco.buscarConta(destino);

                        if (cOrigem == null || cDestino == null) {
                            System.out.println("Conta origem ou destino não encontrada.");
                            break;
                        }

                        banco.transferir(origem, destino, valor);

                        System.out.println("Transferência realizada.");
                        System.out.println("Saldo origem: " + cOrigem.getSaldo());
                        System.out.println("Saldo destino: " + cDestino.getSaldo());
                        break;


                    case 6:
                        for (Conta c : banco.listarContas()) {
                            System.out.println("Conta " + c.getNumero() +
                                    " | Cliente: " + c.getClass().getName() +
                                    " | Saldo: " + c.getSaldo());
                        }
                        break;

                    case 0:
                        System.out.println("Encerrando...");
                        sc.close();
                        return;

                    default:
                        System.out.println("Opção inválida");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}

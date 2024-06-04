package BancoDIgital;

import java.util.ArrayList;
import java.util.List;

class Banco {
    private List<Cliente> clientes;
    private int proximoNumeroConta;

    public Banco() {
        this.clientes = new ArrayList<>();
        this.proximoNumeroConta = 1;
    }

    public void criarContaCorrente(Cliente cliente, double limiteChequeEspecial) {
        ContaCorrente conta = new ContaCorrente(proximoNumeroConta++, cliente, limiteChequeEspecial);
        cliente.adicionarConta(conta);
        clientes.add(cliente);
        System.out.println("Conta corrente criada com sucesso! Número da conta: " + conta.getNumero());
    }

    public void criarContaPoupanca(Cliente cliente, double rendimentoMensal) {
        ContaPoupanca conta = new ContaPoupanca(proximoNumeroConta++, cliente, rendimentoMensal);
        cliente.adicionarConta(conta);
        clientes.add(cliente);
        System.out.println("Conta poupança criada com sucesso! Número da conta: " + conta.getNumero());
    }

    public void depositar(int numeroConta, double valor) {
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta.getNumero() == numeroConta) {
                    conta.depositar(valor);
                    return;
                }
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void sacar(int numeroConta, double valor) {
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta.getNumero() == numeroConta) {
                    conta.sacar(valor);
                    return;
                }
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        Conta contaOrigem = null;
        Conta contaDestino = null;

        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta.getNumero() == numeroContaOrigem) {
                    contaOrigem = conta;
                }
                if (conta.getNumero() == numeroContaDestino) {
                    contaDestino = conta;
                }
            }
        }

        if (contaOrigem != null && contaDestino != null) {
            contaOrigem.transferir(contaDestino, valor);
        } else {
            System.out.println("Uma ou ambas as contas não foram encontradas.");
        }
    }

    public void extrato(int numeroConta) {
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta.getNumero() == numeroConta) {
                    conta.extrato();
                    return;
                }
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void pagarConta(int numeroConta, ContaPagar contaPagar) {
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta.getNumero() == numeroConta) {
                    contaPagar.pagar(conta);
                    return;
                }
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void investir(int numeroConta, Investimento investimento) {
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta.getNumero() == numeroConta) {
                    if (conta.sacar(investimento.getValorInvestido())) {
                        System.out.println("Investimento realizado com sucesso!");
                    } else {
                        System.out.println("Saldo insuficiente para realizar o investimento.");
                    }
                    return;
                }
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void solicitarEmprestimo(int numeroConta, double valorEmprestado, double taxaJuros, int prazoMeses) {
        for (Cliente cliente : clientes) {
            for (Conta conta : cliente.getContas()) {
                if (conta.getNumero() == numeroConta) {
                    Emprestimo emprestimo = new Emprestimo(valorEmprestado, taxaJuros, prazoMeses, conta);
                    emprestimo.solicitarEmprestimo();
                    return;
                }
            }
        }
        System.out.println("Conta não encontrada.");
    }
}

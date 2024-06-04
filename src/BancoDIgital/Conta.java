package BancoDIgital;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
     protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected List<Transacao> transacoes;

    public Conta(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = 0;
        this.transacoes = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            transacoes.add(new Transacao(new Date(numero), "Depósito", valor, this, null));
            System.out.println("Depósito realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    @SuppressWarnings("deprecation")
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            transacoes.add(new Transacao(new Date(numero, numero, numero), "Saque", valor, this, null));
            System.out.println("Saque realizado com sucesso!");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
            return false;
        }
    }

    public void transferir(Conta contaDestino, double valor) {
        if (valor > 0 && sacar(valor)) {
            contaDestino.depositar(valor);
            transacoes.add(new Transacao(new Date(numero), "Transferência", valor, this, contaDestino));
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }

    public void extrato() {
        System.out.println("Extrato da Conta " + numero + " - Cliente: " + cliente.getNome());
        System.out.println("Saldo: R$ " + saldo);
        System.out.println("Transações:");
        for (Transacao transacao : transacoes) {
            System.out.println(transacao);
        }
    }

    protected abstract void pagar(Conta conta);
}
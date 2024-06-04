package BancoDIgital;

import java.sql.Date;

class ContaPoupanca extends Conta {
    // ... outros atributos e métodos

    @Override
    protected void pagar(Conta conta) {
        // TODO Auto-generated method stub
        
    }

    public ContaPoupanca(int numero, Cliente cliente) {
        super(numero, cliente);
        //TODO Auto-generated constructor stub
    }
    // Construtor da classe ContaPoupanca
    public ContaPoupanca(int numero, Cliente cliente, double rendimentoMensal) {
        super(numero, cliente); // Chama o construtor da classe pai (Conta)
    }

    @Override
    public boolean sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            transacoes.add(new Transacao(new Date(numero), "Saque", valor, this, null));
            System.out.println("Saque realizado com sucesso!");
            return true;
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
            return false;
        }
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (valor > 0 && sacar(valor)) {
            contaDestino.depositar(valor);
            transacoes.add(new Transacao(new Date(numero), "Transferência", valor, this, contaDestino));
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }

    @Override
    public String toString() {
        return "ContaPoupanca []";
    }
}
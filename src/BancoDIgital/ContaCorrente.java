package BancoDIgital;

import java.sql.Date;

class ContaCorrente extends Conta {
    private double limiteChequeEspecial; // Atributo da classe

    // Construtor da classe ContaCorrente
    public ContaCorrente(int numero, Cliente cliente, double limiteChequeEspecial) {
        super(numero, cliente); 
        this.limiteChequeEspecial = limiteChequeEspecial; // Inicializa o atributo
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= 0 || valor > (saldo + limiteChequeEspecial)) {
            System.out.println("Saldo insuficiente ou valor inválido para saque.");
            return false;
        } else {
            saldo -= valor;
            transacoes.add(new Transacao(new Date(System.currentTimeMillis()), "Saque", valor, this, null)); // Usa System.currentTimeMillis() para obter a data atual
            System.out.println("Saque realizado com sucesso!");
            return true;
        }
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (valor > 0 && sacar(valor)) {
            contaDestino.depositar(valor);
            transacoes.add(new Transacao(new Date(System.currentTimeMillis()), "Transferência", valor, this, contaDestino));
            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido para transferência.");
        }
    }

    @Override
    public String toString() {
        return "ContaCorrente [limiteChequeEspecial=" + limiteChequeEspecial + "]";
    }

    @Override
    protected void pagar(Conta conta) {
        // TODO: Implementar a lógica de pagamento de contas da conta corrente
    }
}
package BancoDIgital;

public class ContaPagar {
    private String nome;
    private double valor;
    public void pagar(Conta conta) {
        if (conta.sacar(this.valor)) { // Tenta sacar o valor da conta
            System.out.println("Conta " + this.nome + " paga com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para pagar a conta " + this.nome);
        }
    }
}
import java.sql.Date;

import BancoDIgital.Conta;

public class ContaPagar {
    private String nome;
    private double valor;
    private Date dataVencimento;
    private boolean paga;

    public ContaPagar(String nome, double valor, Date dataVencimento) {
        this.nome = nome;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.paga = false;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public boolean isPaga() {
        return paga;
    }

    public void pagar(Conta conta) {
        if (conta.sacar(valor)) {
            paga = true;
            System.out.println("Conta " + nome + " paga com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para pagar a conta " + nome);
        }
    }
}



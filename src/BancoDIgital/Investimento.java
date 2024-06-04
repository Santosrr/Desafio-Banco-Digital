package BancoDIgital;

public class Investimento {
    protected double valorInvestido;
    protected double rendimento;

    public Investimento(double valorInvestido, double rendimento) {
        this.valorInvestido = valorInvestido;
        this.rendimento = rendimento;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public double getRendimento() {
        return rendimento;
    }

    public double calcularRendimento() {
        return 0;
    }

}

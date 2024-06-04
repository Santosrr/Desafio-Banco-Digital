package BancoDIgital;

class RendaFixa extends Investimento {
    public RendaFixa(double valorInvestido, double rendimento) {
        super(valorInvestido, rendimento);
    }

    @Override
    public double calcularRendimento() {
        return valorInvestido * rendimento;
    }
}

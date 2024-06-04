package BancoDIgital;

class Emprestimo {
    private double valorEmprestado;
    private double taxaJuros;
    private int prazoMeses;
    private double valorParcela;
    private Conta contaDestino;

    public Emprestimo(double valorEmprestado, double taxaJuros, int prazoMeses, Conta contaDestino) {
        this.valorEmprestado = valorEmprestado;
        this.taxaJuros = taxaJuros;
        this.prazoMeses = prazoMeses;
        this.contaDestino = contaDestino;
        this.valorParcela = calcularValorParcela();
    }

    public double getValorEmprestado() {
        return valorEmprestado;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public int getPrazoMeses() {
        return prazoMeses;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    private double calcularValorParcela() {
        double jurosMensal = taxaJuros / 12;
        return (valorEmprestado * jurosMensal * Math.pow(1 + jurosMensal, prazoMeses)) /
               (Math.pow(1 + jurosMensal, prazoMeses) - 1);
    }

    public void solicitarEmprestimo() {
        if (contaDestino.sacar(valorParcela)) {
            System.out.println("Empréstimo solicitado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para pagar a primeira parcela do empréstimo.");
        }
    }
}
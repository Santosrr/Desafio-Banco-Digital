package BancoDIgital;

import java.sql.Date;

class Transacao {
    private Date data;
    private String tipo;
    private double valor;
    private Conta contaOrigem;
    private Conta contaDestino;

    public Transacao(java.util.Date date, String tipo, double valor, Conta contaOrigem, Conta contaDestino) {
        this.data = (Date) date;
        this.tipo = tipo;
        this.valor = valor;
        this.contaOrigem = contaOrigem;
        this.contaDestino = contaDestino;
    }

    @Override
    public String toString() {
        return "Data: " + data + ", Tipo: " + tipo + ", Valor: R$ " + valor +
               ", Conta Origem: " + (contaOrigem != null ? contaOrigem.getNumero() : "N/A") +
               ", Conta Destino: " + (contaDestino != null ? contaDestino.getNumero() : "N/A");
    }
}
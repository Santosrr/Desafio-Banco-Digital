package BancoDIgital;

import java.util.ArrayList;
import java.util.List;

class Cliente {
    private String nome;
    private List<Conta> contas;

    public Cliente(String nome, String cpf, String endereco) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public List<Conta> getContas() {
        return contas;
    }
}




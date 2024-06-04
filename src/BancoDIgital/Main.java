package BancoDIgital;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Criação de clientes
        Cliente cliente1 = new Cliente("João da Silva", "123.456.789-00", "Rua A, 123");
        Cliente cliente2 = new Cliente("Maria Souza", "987.654.321-00", "Rua B, 456");

        // Criação de contas
        banco.criarContaCorrente(cliente1, 1000);
        banco.criarContaPoupanca(cliente2, 0.01);

        // Operações bancárias
        banco.depositar(1, 1000);
        banco.sacar(1, 500);
        banco.transferir(1, 2, 200);
        banco.extrato(1);
        banco.extrato(2);

        // Pagamento de conta
        ContaPagar contaPagar = new ContaPagar();
        banco.pagarConta(1, contaPagar);

        // Investimento
        RendaFixa investimento = new RendaFixa(500, 0.05);
        banco.investir(1, investimento);

        // Solicitação de empréstimo
        banco.solicitarEmprestimo(1, 5000, 0.1, 12);
    }
}
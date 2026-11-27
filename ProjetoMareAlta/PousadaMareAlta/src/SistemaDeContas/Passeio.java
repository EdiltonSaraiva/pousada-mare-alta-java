package SistemaDeContas;

public class Passeio implements Cobravel{
    private String destino;
    private double precoPorPessoa;
    private int pessoas;

    public Passeio(String destino, double precoPorPessoa) {
        this(destino, precoPorPessoa, 1);
    }

    public Passeio(String destino, double precoPorPessoa, int pessoas) {
        this.destino = destino;
        this.precoPorPessoa = precoPorPessoa;
        this.pessoas = pessoas;
    }

    @Override
    public String descricao() {
        return "Passeio " + this.destino + " (pessoas: " + this.pessoas + ")";
    }

    @Override
    public double calcularValor() {
        return this.precoPorPessoa * this.pessoas;
    }
}

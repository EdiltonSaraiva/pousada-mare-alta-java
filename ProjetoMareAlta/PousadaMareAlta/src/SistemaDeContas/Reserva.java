package SistemaDeContas;

public class Reserva implements Cobravel{
    private Quarto quarto;
    private int noites;

    public Reserva(Quarto quarto, int noites) {
        this.quarto = quarto;
        this.noites = noites;
    }

    @Override
    public String descricao() {
        return "Reserva do quarto " + this.quarto.numero + " (noites: " + this.noites + ")";
    }

    @Override
    public double calcularValor() {
        return this.quarto.calcularDiaria() * this.noites;
    }
}

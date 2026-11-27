package SistemaDeContas;

public class Translado implements Cobravel{
    private String trajeto;
    private double distanciaKm;
    private double precoPorKm;

    public Translado(String trajeto, double distanciaKm, double precoPorKm) {
        this.trajeto = trajeto;
        this.distanciaKm = distanciaKm;
        this.precoPorKm = precoPorKm;
    }

    @Override
    public String descricao() {
        return "Translado " + this.trajeto + " (" + this.distanciaKm + " km)";
    }

    @Override
    public double calcularValor() {
        return this.distanciaKm * this.precoPorKm;
    }
}

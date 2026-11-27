package SistemaDeContas;

public class Quarto {
    protected int numero;
    protected double diariaBase;

    public Quarto(int numero, double diariaBase) {
        this.numero = numero;
        this.diariaBase = diariaBase;
    }

    public double calcularDiaria() {
        return this.diariaBase;
    }

    public void exibir() {
        System.out.println("Quarto " + this.numero + ": R$ " + this.calcularDiaria() + " por noite");
    }
}

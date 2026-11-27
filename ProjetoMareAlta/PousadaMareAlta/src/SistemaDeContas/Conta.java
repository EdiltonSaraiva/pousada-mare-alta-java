package SistemaDeContas;

public class Conta {
    private String hospede;
    private Cobravel[] itens;

    public Conta(String hospede, Cobravel[] itens) {
        this.hospede = hospede;
        this.itens = itens;
    }

    public double calcularTotal() {
        double total = 0;
        for (Cobravel item : this.itens) {
            total += item.calcularValor();
        }
        return total;
    }

    public double calcularTotal(double descontoPercentual) {
        double total = this.calcularTotal();
        double desconto = total * descontoPercentual / 100;
        return total - desconto;
    }

    public void imprimirExtrato() {
        String linhaDupla = "==========================================================";
        String linhaSimples = "----------------------------------------------------------";

        System.out.println();
        System.out.println(linhaDupla);
        System.out.println("                    POUSADA MARE ALTA                     ");
        System.out.println("                 COMPROVANTE DE FECHAMENTO                ");
        System.out.println(linhaDupla);
        System.out.printf(" HOSPEDE: %-47s%n", this.hospede.toUpperCase());
        System.out.println(linhaSimples);
        System.out.printf(" %-4s %-38s %12s%n", "ITEM", "DESCRICAO", "VALOR (R$)");
        System.out.println(linhaSimples);

        int numeroItem = 1;
        for (Cobravel item : this.itens) {
            System.out.printf(" %02d   %-38s %12.2f%n", numeroItem, item.descricao(), item.calcularValor());
            numeroItem++;
        }

        System.out.println(linhaSimples);
        System.out.printf(" %-43s R$ %9.2f%n", "SUBTOTAL", this.calcularTotal());
        System.out.println(linhaDupla);
    }
}

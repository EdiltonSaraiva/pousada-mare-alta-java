package SistemaDeContas;

public class MainPadrao {
    public static void main(String[] args) {
        // 1. Um vetor da mae, objetos de varias filhas
        Quarto[] quartos = {
                new Quarto(101, 180),
                new QuartoLuxo(201, 300, 60),
                new Chale(301, 250, 2)
        };
        for (Quarto q : quartos) {
            q.exibir();
        }
        // 2. Itens de tipos diferentes, um contrato so
        Cobravel[] itens = {
                new Reserva(quartos[1], 3),
                new Passeio("Lencois Maranhenses", 150, 2),
                new Passeio("Rio Preguicas", 90),
                new Translado("Aeroporto - Pousada", 35, 4.0)
        };
        // 3. A conta soma tudo sem perguntar o tipo de cada item
        Conta conta = new Conta("Bruno Costa", itens);
        conta.imprimirExtrato();
        System.out.println("Com cupom de 10%: R$ " + conta.calcularTotal(10));
    }
}

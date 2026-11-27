package SistemaDeContas;

import java.util.Scanner;

public class MainMareAlta {
    public static void main(String[] args) {
        Scanner recebeDadosCliente = new Scanner(System.in);

        Quarto[] quartos = {
                new Quarto(101, 180),
                new QuartoLuxo(201, 300, 60),
                new Chale(301, 250, 2)
        };

        System.out.println("==========================================================");
        System.out.println("          BEM-VINDO AO SISTEMA POUSADA MARE ALTA          ");
        System.out.println("==========================================================");

        System.out.print("Informe o nome do hospede: ");
        String nomeHospede = recebeDadosCliente.nextLine();

        Cobravel[] carrinho = new Cobravel[50];
        int quantidadeItens = 0;

        int opcao;

        do {
            System.out.println("\n+--------------------------------------------------------+");
            System.out.println("|                    MENU DE SERVICOS                    |");
            System.out.println("+--------------------------------------------------------+");
            System.out.println("| 1 - Adicionar Reserva de Quarto                        |");
            System.out.println("| 2 - Adicionar Passeio                                  |");
            System.out.println("| 3 - Adicionar Translado                                |");
            System.out.println("| 4 - Fechar Conta e Imprimir Extrato                    |");
            System.out.println("+--------------------------------------------------------+");
            System.out.print("Escolha uma opcao: ");
            opcao = recebeDadosCliente.nextInt();
            recebeDadosCliente.nextLine();

            if (opcao == 1) {
                System.out.println("\n--- ACOMODACOES DISPONIVEIS ---");
                for (int i = 0; i < quartos.length; i++) {
                    System.out.print("[" + (i + 1) + "] ");
                    quartos[i].exibir();
                }
                System.out.print("Escolha o numero da opcao do quarto (1 a " + quartos.length + "): ");
                int indiceQuarto = recebeDadosCliente.nextInt() - 1;
                System.out.print("Quantidade de noites: ");
                int noites = recebeDadosCliente.nextInt();
                recebeDadosCliente.nextLine();

                if (indiceQuarto >= 0 && indiceQuarto < quartos.length && noites > 0) {
                    carrinho[quantidadeItens] = new Reserva(quartos[indiceQuarto], noites);
                    quantidadeItens++;
                    System.out.println(">> Reserva adicionada com sucesso!");
                } else {
                    System.out.println(">> Opcao de quarto ou noites invalida.");
                }

            } else if (opcao == 2) {
                System.out.println("\n--- ADICIONAR PASSEIO ---");
                System.out.print("Destino do passeio: ");
                String destino = recebeDadosCliente.nextLine();
                System.out.print("Preco por pessoa (R$): ");
                double preco = recebeDadosCliente.nextDouble();
                System.out.print("Quantidade de pessoas (digite 0 para padrao de 1 pessoa): ");
                int pessoas = recebeDadosCliente.nextInt();
                recebeDadosCliente.nextLine();

                if (pessoas <= 0) {
                    carrinho[quantidadeItens] = new Passeio(destino, preco);
                } else {
                    carrinho[quantidadeItens] = new Passeio(destino, preco, pessoas);
                }
                quantidadeItens++;
                System.out.println(">> Passeio adicionado com sucesso!");

            } else if (opcao == 3) {
                System.out.println("\n--- ADICIONAR TRANSLADO ---");
                System.out.print("Trajeto (ex: Aeroporto - Pousada): ");
                String trajeto = recebeDadosCliente.nextLine();
                System.out.print("Distancia em km: ");
                double distancia = recebeDadosCliente.nextDouble();
                System.out.print("Preco por km (R$): ");
                double precoKm = recebeDadosCliente.nextDouble();
                recebeDadosCliente.nextLine();

                carrinho[quantidadeItens] = new Translado(trajeto, distancia, precoKm);
                quantidadeItens++;
                System.out.println(">> Translado adicionado com sucesso!");

            } else if (opcao != 4) {
                System.out.println(">> Opcao invalida. Tente novamente.");
            }

        } while (opcao != 4);

        Cobravel[] itensFinais = new Cobravel[quantidadeItens];
        for (int i = 0; i < quantidadeItens; i++) {
            itensFinais[i] = carrinho[i];
        }

        System.out.print("\nPossui cupom de desconto? Informe o percentual (0 se nao tiver): ");
        double desconto = recebeDadosCliente.nextDouble();

        Conta conta = new Conta(nomeHospede, itensFinais);
        conta.imprimirExtrato();

        if (desconto > 0) {
            double totalComDesconto = conta.calcularTotal(desconto);
            double valorDescontado = conta.calcularTotal() - totalComDesconto;
            System.out.printf(" DESCONTO (%.1f%%)%27s -R$ %9.2f%n", desconto, "", valorDescontado);
            System.out.printf(" %-43s R$ %9.2f%n", "TOTAL A PAGAR", totalComDesconto);
            System.out.println("==========================================================");
        }

        System.out.println(" OBRIGADO PELA PREFERENCIA E QUE A MARE TE TRAGA DE VOLTA!");
        System.out.println("==========================================================");
    }
}
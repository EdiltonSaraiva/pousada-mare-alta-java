# Sistema de Contas - Pousada Mare Alta

Projeto pratico de Programacao Orientada a Objetos em Java (2o TDE - Programacao Backend / CEST).

## Organização dos Diretórios
```text
pousada-mare-alta/
├── src/                                # Código-fonte em Java (um arquivo por classe)
│   ├── Quarto.java                     # Classe base de acomodação
│   ├── QuartoLuxo.java                 # Subclasse de Quarto (diária + taxa de luxo)
│   ├── Chale.java                      # Subclasse de Quarto (diária + hóspedes extras)
│   ├── Cobravel.java                   # Interface de contrato para itens da conta
│   ├── Reserva.java                    # Implementa Cobravel (associação com Quarto)
│   ├── Passeio.java                    # Implementa Cobravel (sobrecarga de construtores)
│   ├── Translado.java                  # Classe de extensão (implementa Cobravel)
│   ├── Conta.java                      # Fechamento da conta, extrato e descontos
│   ├── Main.java                       # Roteiro oficial de testes do TDE
│   └── MainInterativa.java             # Versão extra com menu interativo via Scanner
├── docs/                               # Entregáveis em PDF
│   └── diagrama-e-justificativa.pdf    # Diagrama, Tabela de Justificativa e Print do Console
├── .gitignore                          # Arquivos e pastas ignorados pelo Git
└── README.md                           # Documentação do projeto
```

## Conceitos aplicados
- Heranca (`QuartoLuxo` e `Chale` estendem `Quarto`)
- Sobrescrita de metodos (`@Override`) e uso de `super`
- Construtores e sobrecarga (`Passeio` com `this(...)` e `Conta.calcularTotal`)
- Interfaces e polimorfismo (`Cobravel` implementada por `Reserva`, `Passeio` e `Translado`)

## Classe de extensao
- `Translado`: implementa `Cobravel`, recebendo trajeto, distancia em km e preco por km (`distanciaKm * precoPorKm`).

## Como executar
No terminal, dentro da pasta dos arquivos `.java`:

```bash
javac *.java
java Main
```
Ou a versão interativa com menu:

`java MainMaraAlta`

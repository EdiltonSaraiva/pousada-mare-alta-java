# Sistema de Contas - Pousada Mare Alta

Projeto pratico de Programacao Orientada a Objetos em Java (2o TDE - Programacao Backend / CEST).

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

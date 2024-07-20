# Exercício Intermediário I

Você deve implementar um sistema de gerenciamento de contas bancárias. O sistema deve permitir a criação de contas, depósito de dinheiro, saque de dinheiro e verificação de saldo. Além disso, deve incluir uma funcionalidade para transferir dinheiro entre contas.

## Requisitos

### Classe `ContaBancaria`

#### Atributos:
- `String titular`
- `int numeroConta`
- `double saldo`

#### Métodos:
- Construtor: `public ContaBancaria(String titular, int numeroConta)`
- `void depositar(double valor)`
- `void sacar(double valor)`
- `double verificarSaldo()`
- `void transferir(ContaBancaria contaDestino, double valor)`

### Classe `Banco`

#### Atributos:
- `ArrayList<ContaBancaria> contas`

#### Métodos:
- `void adicionarConta(ContaBancaria conta)`
- `ContaBancaria buscarConta(int numeroConta)`
- `void listarContas()`

### Método `Main`

No método `main`, crie uma instância da classe `Banco`. Adicione algumas contas ao banco. Realize operações de depósito, saque e transferência entre contas. Imprima o saldo de algumas contas para verificar se as operações foram realizadas corretamente.

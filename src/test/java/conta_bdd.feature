@tag
Feature: Cliente faz saque de dinheiro Com um Cliente, eu gostaria de sacar dinheiro em caixa eletronico,
     para que eu nao tenha que esperar numa fila de banco.

  @tag1
  Scenario: Cliente especial com saldo negativo
    Given Um cliente especial com saldo atual de -200 reais
    When for solicitado um saque no valor de 100 reais
    Then deve efutuar o saque e atualizar o saldo da conta para -200 reais

	@tag2
	Scenario: Cliente comum com saldo negativo
    Given Um cliente comum com saldo atual de -300 reais
    When solicitar um saque no valor de 200 reais
    Then nao deve efutuar o saque e deve retornar a mensagem Saldo Insuficiente
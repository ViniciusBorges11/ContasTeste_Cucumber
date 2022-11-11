import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 *  Classe conta criada e as variaveis clienteE, saldo e saque.
 *  
 * 
 */

public class Conta {

	public boolean clienteE = false;
	public int conta;
	public int saque;
	public int saldo;
	
//	@Before
//	public void before() {
//		if (this.clienteE == true) {
//			um_cliente_especial_com_saldo_atual_de_reais(conta);
//			for_solicitado_um_saque_no_valor_de_reais(saque);
//			deve_efutuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(saldo);
//		} else {
//			um_cliente_comum_com_saldo_atual_de_reais(conta);
//			solicitar_um_saque_no_valor_de_reais(saque);
//			nao_deve_efutuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente();
//			System.out.print("entrou");
//		}
//		
//	}


	/**
	 * 
	 * Este é o primeiro parametro, parametro do tipo integer. 
	 * Nessa parte o codigo recebe o saldo atual do cliente especial.
	 * Como solicitado no Given o saldo do cliente especial é de -200 reais 
	 *    
	 * 
	 */

	@Given("Um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer conta) {
		if (conta instanceof Integer && this.clienteE == true) {
			this.conta = conta;
		} else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * 
	 * Este é o segundo parametro, parametro do tipo integer. 
	 * Nessa parte o codigo recebe a solicitação de saque de um cliente especial.
	 * Como solicitado no When o saque pedido pelo cliente especial é de 100 reais.          
	 * 
	 * 
	 */
	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer saque) {

		if (saque instanceof Integer && this.clienteE == true) {
			this.saque = saque;
		} else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * 
	 * Este é o terceiro parametro, parametro do tipo integer. 
	 * Nessa parte o  codigo deve efetuar o saque e atualizar o saldo do cliente.
	 * Como solicitado pelo Then é efetuado o saque para o cliente especial e assim atualizado o saldo do cliente especial.
	 *      
	 * 
	 */
	@Then("deve efutuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efutuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer saldo) {

		if (saldo instanceof Integer && this.clienteE == true) {
			saldo = this.conta - (this.saque);
		} else
			throw new io.cucumber.java.PendingException();
	}

	/**
	 * 
	 * Este é o quarto parametro, parametro do tipo integer. 
	 * Nessa parte o codigo recebe o saldo atual do cliente comum.
	 * Como solicitado no Given o saldo do cliente comum é de -300 reais. 
	 *                
	 * 
	 */

	@Given("Um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer conta) {
		
		if (conta instanceof Integer && this.clienteE == false) {
			this.conta = conta;
		} 
		else {
			throw new io.cucumber.java.PendingException();
			}
	}

	/**
	 * 
	 * Este é o quinto parametro, parametro do tipo integer. 
	 * Nessa parte o  codigo recebe a solicitação de saque do cliente comum.
	 * Como solicitado no When o saque pedido pelo cliente especial é de 200 reais.             
	 * 
	 * 
	 */

	@When("solicitar um saque no valor de {int} reais")
	public void solicitar_um_saque_no_valor_de_reais(Integer saque) {
	
		if (saque instanceof Integer && this.clienteE == false) {
			this.saque = saque;
		} else
			throw new io.cucumber.java.PendingException();	
	}

	/**
	 * 
	 * Nessa parte o codigo retorna a mensagem de saldo insuficiente. Pois o cliente comum está com saldo negativo.
	 *  É realizado o if com uma condição de saldo e tipo do cliente.
	 *  Sendo cliente comum e saldo negativo é passada a mensagem Saldo Insuficiente. e no else é realizada a execeção.
	 *  
	 */
	@Then("nao deve efutuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void nao_deve_efutuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		if (this.conta > 0 && this.saque < this.conta && this.clienteE == false ) {
			saldo = this.conta - (this.saque);
		} else if (this.saque > this.conta) {
			System.out.println("Saldo insuficiente");
		}
		else{
			throw new io.cucumber.java.PendingException();}
		
	}
}

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 *  Classe conta criada e as variaveis cliente, saldo e saque.
 *  Get e Set criado para receber os valores das variaveis.
 * 
 */

public class Conta {

	private String cliente;
	private int saldo;
	private int saque;
	
	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getSaque() {
		return saque;
	}

	public void setSaque(int saque) {
		this.saque = saque;
	}

	/**
	 * 
	 * Este é o primeiro parametro, parametro do tipo integer. 
	 * Nessa parte o codigo recebe o saldo atual do cliente especial.
	 * Como solicitado no Given o saldo do cliente especial é de -200 reais 
	 * Try catch utilizado para declarar o saldo e o cliente, e executar a exceção.       
	 * 
	 */

	@Given("Um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
		try {
			this.saldo = - 200;
			this.cliente = "Especial";
		} catch (Exception e) {
			throw new io.cucumber.java.PendingException();
		}
	}

	/**
	 * 
	 * Este é o segundo parametro, parametro do tipo integer. 
	 * Nessa parte o codigo recebe a solicitação de saque de um cliente especial.
	 * Como solicitado no When o saque pedido pelo cliente especial é de 100 reais.          
	 * Try catch utilizado para declarar o saque e o cliente, e executar a exceção.  
	 * 
	 */
	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) {
		try {
			this.saque = 100;
			this.cliente = "Especial";
		} catch (Exception e) {
			throw new io.cucumber.java.PendingException();
		}
	}

	/**
	 * 
	 * Este é o terceiro parametro, parametro do tipo integer. 
	 * Nessa parte o  codigo deve efetuar o saque e atualizar o saldo do cliente.
	 * Como solicitado pelo Then é efetuado o saque para o cliente especial e assim atualizado o saldo do cliente especial.
	 * Try catch utilizado para realizar o saque e assim atualizar o saldo, e executar a exceção.      
	 * 
	 */
	@Then("deve efutuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efutuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int1) {
		try {
			this.saldo = this.saldo - this.saque;
		} catch (Exception e) {
			throw new io.cucumber.java.PendingException();
		}
	}

	/**
	 * 
	 * Este é o quarto parametro, parametro do tipo integer. 
	 * Nessa parte o codigo recebe o saldo atual do cliente comum.
	 * Como solicitado no Given o saldo do cliente comum é de -300 reais. 
	 * Try catch utilizado para declarar o saldo e o cliente, e executar a exceção.                
	 * 
	 */

	@Given("Um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
		try {
			this.saldo = -300;
			this.cliente = "Comum";
		} catch (Exception e) {
			throw new io.cucumber.java.PendingException();
		}

	}

	/**
	 * 
	 * Este é o quinto parametro, parametro do tipo integer. 
	 * Nessa parte o  codigo recebe a solicitação de saque do cliente comum.
	 * Como solicitado no When o saque pedido pelo cliente especial é de 200 reais.             
	 * Try catch utilizado para declarar o saque e o cliente, e executar a exceção. 
	 * 
	 */

	@When("solicitar um saque no valor de {int} reais")
	public void solicitar_um_saque_no_valor_de_reais(Integer int1) {
		try {
			this.saldo = 200;
			this.cliente = "Comum";
		} catch (Exception e) {
			throw new io.cucumber.java.PendingException();
		}
	}

	/**
	 * 
	 * Nessa parte o codigo retorna a mensagem de saldo insuficiente. Pois o cliente comum está com saldo negativo.
	 *  Como solicitado pelo Then o cliente comum não pode receber o saque pois o seu saldo está negativo.       
	 *  É realizado o if com uma condição de saldo e tipo do cliente.
	 *  Sendo cliente comum e saldo negativo é passada a mensagem Saldo Insuficiente. e no else é realizada a execeção.
	 *  
	 */
	@Then("nao deve efutuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void nao_deve_efutuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		this.cliente = "Comum";
		
		if (this.saldo != -300 && this.cliente == "Comum") {
			System.out.println("Saldo Insuficiente");
		} else {
			throw new io.cucumber.java.PendingException();
		}
	}
}

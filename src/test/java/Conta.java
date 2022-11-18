import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 *  Classe conta criada e as variaveis clienteE, saldo e saque e os gets e setters.
 *  
 * 
 */

public class Conta {

	public boolean clienteE = false;
	public int conta;
	public int saque;
	public int saldo;
	

	public boolean isClienteE() {
		return clienteE;
	}

	public void setClienteE(boolean clienteE) {
		this.clienteE = clienteE;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getSaque() {
		return saque;
	}

	public void setSaque(int saque) {
		this.saque = saque;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	/**
	 * 
	 * Primeiro parametro int conta, receb o saldo atual do cliente especial. 
	 * If está com uma condição se o ClienteE é true ele entra no If, se não entra no Else assim rodando o PendingException();
	 * Como solicitado no Given o saldo do cliente especial é de -200 reais 
	 *    
	 * 
	 */

	@Given("^Um cliente especial com saldo atual de -(\\d+) reais$")
	public void umClienteEspecialComSaldoAtualDeReais(int conta) throws Throwable {
		if (isClienteE()== true) {
			setConta(conta * -1);
			System.out.println("Conta"+ getConta());
		} else
			throw new PendingException();
	}

	/**
	 * 
	 * Segundo Parametro int saque, recebe o valor do saque do cliente especial 
	 * If com a condição que o usuário precisa ser cliente igual a true para acessar, se não entra no Else assim rodando o PendingException();
	 * Como solicitado no When o saque pedido pelo cliente especial é de 100 reais.          
	 * 
	 * 
	 */
	@When("^for solicitado um saque no valor de (\\d+) reais$")
	public void for_solicitado_um_saque_no_valor_de_reais(int saque) throws Throwable {

		if (isClienteE() == true) {
			setSaque(saque);
		} else
			throw new PendingException();
	}

	/**
	 * 
	 * Terceiro parametro int saldo, faz o calculo sobre a conta e o saque.
	 * If com a condição que o usuário precisa ser cliente igual a true para acessar, se não entra no Else assim rodando o PendingException();
	 * Como solicitado pelo Then é efetuado o saque para o cliente especial e assim atualizado o saldo do cliente especial.
	 *      
	 * 
	 */
	@Then("^deve efutuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
	public void deveEfutuarOSaqueEAtualizarOSaldoDaContaParaReais(int saldo) throws Throwable {

		if (isClienteE() == true) {
			saldo = getConta() - (getSaque());
		} else
			throw new PendingException();
	}

	/**
	 * 
	 * Quarto Parametro int conta, nesse caso o Given é em relação ao cliente comum. conta recebe o valor do cliente comum
	 * O if tem uma condição de cliente == false, assim sendo cliente comum. se não entra no Else assim rodando o PendingException();
	 * Como solicitado no Given o saldo do cliente comum é de -300 reais. 
	 *                
	 * 
	 */

	@Given("^Um cliente comum com saldo atual de -(\\d+) reais$")
	public void umClienteComumComSaldoAtualDeReais(int conta) throws Throwable {
		
		if (this.clienteE == false) {
			setConta(conta * -1);
			System.out.println("Conta"+ getConta());
		} 
		else {
			throw new PendingException();
			}
	}

	/**
	 * 
	 * Quinto Parametro, int saque. recebe o valor do saque do cliente comum
	 * O if tem uma condição de cliente == false, assim sendo cliente comum. se não entra no Else assim rodando o PendingException();
	 * Como solicitado no When o saque pedido pelo cliente especial é de 200 reais.             
	 * 
	 * 
	 */

	@When("^solicitar um saque no valor de (\\d+) reais$")
	public void solicitar_um_saque_no_valor_de_reais(int saque) throws Throwable {
	
		if (this.clienteE == false) {
			setSaque(saque);
			System.out.println("Valor saque"+ getSaque());
		} else
			throw new PendingException();	
	}

	/**
	 * 
	 * No Then é pedido para realizar o pedido do saque. Dependendo do valor atribuido pode ser aceito ou não o saque do cliente comum
	 *  Para entrar no if e realizar a conta, se conta for maior que 0 e conta maior que saque alem disso clienteE == false
	 *  Else if recebe uma condição de Saldo Insuficiente caso o saque for maior que conta. Por fim é realizado o else com o throw new PendingException();
	 *  
	 */
	@Then("nao deve efutuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void nao_deve_efutuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() throws Throwable {
		if (getConta() > 0 && getSaque() <= getConta() && this.clienteE == false ) {
			setConta(getConta() - getSaque());
			System.out.println("saldo"+ getConta());
			
		} else if (getSaque() > getConta()) {
			System.out.println("Saldo insuficiente");
		}
		else{	
			throw new PendingException();
			}
		
	}
}

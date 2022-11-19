# ContasTeste_Junit
---

<body>
<h2> Descrição </h2>
<div style="border-bottom: 1px solid grey"></div>
Projeto para a relização do teste de software simulando contas de banco de dois clientes. Cliente Especial e Cliente Comum.
Para o projeto foi utilizado o jdk 1.80_202.
DryRun e Strict inicializado como, dryrun = false e strict = true, para a verificações das etapas.

<h2> Funcionalidades </h2>
<div style="border-bottom: 1px solid grey"></div>
<span>
  <h3> Cliente Comum </h3>
Runner rodando com o cliente declarado como Cliente Especial false(Assim a variavel se tornando Cliente Comum).
  Para a declaração do valor negativo é preciso mudar na conta.java, pois o parametro está em decimal. assim também é preciso mudar o Given para  -(\\d+) reais$ quando for pedido um valor negativo.
   <br>
  <br>
  <img src=https://media.discordapp.net/attachments/843937538409889795/1043312937743425576/image.png?width=871&height=395></img>
  <br>
  <h4> Conta.bdd feature com o Given negativo do cliente comum </h4>
  <img src=https://media.discordapp.net/attachments/843937538409889795/1043315116936019968/image.png></img>
  <br>
   <h4> Given com parametro em decimal é preciso realizar o calculo de * -1 para o codigo entender que é um valor negativo. Precisei também modificar a string do Given para -(\\d+) reais$ quando for pedido um valor negativo, quando o valor for positivo é preciso retirar o calcualo e modificar a String para (\\d+) reais$ quando for pedido um valor negativo sem o valor de negativo ao lado do valor decimal. Só assim foi executado o DryRun e o strict pedido pela tarefa. </h4>
   <img src=https://media.discordapp.net/attachments/843937538409889795/1043321358131679323/image.png></img>
  <br>
   <h3>Cliente Especial</h3>
  Runner rodando com o cliente declarado como Cliente Especial true(Assim a variavel se tornando Cliente Especial). Realizado o teste com valores negativos para o Cliente Especial, o Cliente Especial pode realizar o saque mesmo com os valores negativos.
  <img src=https://media.discordapp.net/attachments/843937538409889795/1043319658838765599/image.png?width=878&height=395></img>
   <br>
  <h4> Conta.bdd feature com o Given negativo do cliente especial. </h4>
  <img src=https://media.discordapp.net/attachments/843937538409889795/1043315116936019968/image.png></img>
  <h4> Given negativo do cliente especial teve que realizar o mesmo procedimento do given do cliente comum, pois a string pede a troca de parametros quando o vaor for negativo ou positivo </h4>
  <img src=https://media.discordapp.net/attachments/843937538409889795/1043317177127804998/image.png></img>
  <h4>Exemplo do Cliente Especial com valores positivos no conta.bdd_feature. assim é preciso alterar o Given.</h4>
   <img src=https://media.discordapp.net/attachments/843937538409889795/1043323995593908284/image.png?width=900&height=395></img>
</span>

 
<h2>DryRun e Strict</h2>
<div style="border-bottom: 1px solid grey"></div>
<span>
  Strict: No momento que o strict foi inicializado como False, o projeto sempre será executado. Assim a execução do cucumber não irá falhar
  DryRun: A partir do momento que o Dry Run é inicializado o Cucumber só ira fazer a verificação da etapa defenida.
  <h5> DryRun inicialzado como true  e o Strict como false, o código roda sem nenhuma etapa verificada.</h5>
  <img src=https://media.discordapp.net/attachments/843937538409889795/1043325011777290341/image.png?width=1005&height=389></img>
   <br>
   <h5> DryRun inicializado como true  e o Strict como true, os cenários não são definidos, assim não acontece as verificações.</h5>
  <img src=https://media.discordapp.net/attachments/843937538409889795/1043325731658272908/image.png?width=874&height=395></img>
     <br>
   <h5> DryRun inicializado como false e o Strict como false, só um cenário é inicializado seria o cenario que está inicializado pelo metodo boolean no conta.java, no caso do exemplo (public boolean clienteE = true;) assim só foi feito o cenário cliente especial.</h5>
  <img src=https://media.discordapp.net/attachments/843937538409889795/1043326278071222365/image.png?width=947&height=395></img>
</span>

</body>
<footer>
<h2> Última Atualização 18/11/2022 </h2>
<div style="border-bottom: 1px solid grey"></div>
</footer>
 

 >autor: Vinícius Borges Rodrigues

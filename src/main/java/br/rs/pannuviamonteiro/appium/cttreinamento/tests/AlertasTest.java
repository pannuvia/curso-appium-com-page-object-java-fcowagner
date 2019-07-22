package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.page.AlertasPage;
import br.rs.pannuviamonteiro.appium.cttreinamento.page.MenuPage;

public class AlertasTest extends BaseTest {

	private MenuPage menuPage;
	private AlertasPage alertasPage;
	
	public AlertasTest() {
		 this.menuPage = new MenuPage();
		 this.alertasPage = new AlertasPage();
	}
		
	@Before
	public void setUp() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//acessar menu Alertas
		this.menuPage.acessarAlertas();
	}
	
	@Test
	public void deveConfirmarAlertaSimples() {
		
		//clicar em Alert Simples
		this.alertasPage.clicarEmAlertaSimples();
		
		//validar se o titulo Info apareceu
		assertEquals("Info", this.alertasPage.capturarTituloDoAlerta());
		
		//validar se a mensagem Pode clicar no OK ou fora da caixa para sair apareceu
		assertEquals("Pode clicar no OK ou fora da caixa para sair", this.alertasPage.capturarMensagemDoAlerta());
		
		//clicar na coordenada fora da caixa
		this.alertasPage.clicarNaCoordenada();
		
		//validar se texto Alerta Simples apareceu
		assertEquals("ALERTA SIMPLES", this.alertasPage.capturarTipoDeAlerta("ALERTA SIMPLES"));
	}

	@Test
	public void deveConfirmarAlertaConfirm() {
		
		//clicar em Alerta Confirm
		this.alertasPage.clicarEmAlertaConfirm();
		
		//validar se o titulo Info apareceu
		assertEquals("Info", this.alertasPage.capturarTituloDoAlerta());
		
		//validar se a mensagem Confirma a operação? apareceu
		assertEquals("Confirma a operação?", this.alertasPage.capturarMensagemDoAlerta());
		
		//clicar em confirmar
		this.alertasPage.clicarEmConfirmar();
		
		//validar se a mensagem Confirmado apareceu
		assertEquals("Confirmado", this.alertasPage.capturarMensagemDoAlerta());
		
		//clicar em sair
		this.alertasPage.clicarEmSair();
	}

	
	@Test
	public void deveConfirmarAlertaRestritivo() {

		//clicar em Alerta Restritivo
		this.alertasPage.clicarEmAlertaRestritivo();
		
		//validar se o titulo Info apareceu
		assertEquals("Info", this.alertasPage.capturarTituloDoAlerta());
		
		//validar se a mensagem Não pode clicar fora, apenas no SAIR apareceu
		assertEquals("Não pode clicar fora, apenas no SAIR", this.alertasPage.capturarMensagemDoAlerta());
			
		//clicar em sair
		this.alertasPage.clicarEmSair();
		
		//validar se texto Alerta Restritivo apareceu
		assertEquals("ALERTA RESTRITIVO", this.alertasPage.capturarTipoDeAlerta("ALERTA RESTRITIVO"));
	}
	
}

package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.page.AlertasPage;
import br.rs.pannuviamonteiro.appium.cttreinamento.page.MenuPage;

public class AlertasTest extends BaseTest {

	private MenuPage menuPage;
	private AlertasPage alertPage;
	
	public AlertasTest() {
		 this.menuPage = new MenuPage();
		 this.alertPage = new AlertasPage();
	}
		
	@Test
	public void deveConfirmarAlertaSimples() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//acessar menu Alertas
		this.menuPage.acessarAlertas();
		
		//clicar em Alert Simples
		this.alertPage.clicarEmAlertaSimples();
		
		//validar se o titulo Info apareceu
		assertEquals("Info", this.alertPage.capturarTituloDoAlerta());
		
		//validar se a mensagem Pode clicar no OK ou fora da caixa para sair apareceu
		assertEquals("Pode clicar no OK ou fora da caixa para sair", this.alertPage.capturarMensagemDoAlerta());
		
		//clicar em OK
		this.alertPage.clicarEmOK();
		
		//validar se texto Alerta Simples apareceu
		assertEquals("ALERTA SIMPLES", this.alertPage.capturarTipoDeAlerta("ALERTA SIMPLES"));
	}
	
	@Test
	public void deveConfirmarAlertaConfirm() {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//acessar menu Alertas
		this.menuPage.acessarAlertas();
		
		//clicar em Alerta Confirm
		this.alertPage.clicarEmAlertaConfirm();
		
		//validar se o titulo Info apareceu
		assertEquals("Info", this.alertPage.capturarTituloDoAlerta());
		
		//validar se a mensagem Confirma a operação? apareceu
		assertEquals("Confirma a operação?", this.alertPage.capturarMensagemDoAlerta());
		
		//clicar em confirmar
		this.alertPage.clicarEmConfirmar();
		
		//validar se a mensagem Confirmado apareceu
		assertEquals("Confirmado", this.alertPage.capturarMensagemDoAlerta());
		
		//clicar em sair
		this.alertPage.clicarEmSair();
	}

	
	@Test
	public void deveConfirmarAlertaRestritivo() {
		
		//acessar menu Alertas
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.menuPage.acessarAlertas();
		
		//clicar em Alerta Restritivo
		this.alertPage.clicarEmAlertaRestritivo();
		
		//validar se o titulo Info apareceu
		assertEquals("Info", this.alertPage.capturarTituloDoAlerta());
		
		//validar se a mensagem Não pode clicar fora, apenas no SAIR apareceu
		assertEquals("Não pode clicar fora, apenas no SAIR", this.alertPage.capturarMensagemDoAlerta());
			
		//clicar em sair
		this.alertPage.clicarEmSair();
		
		//validar se texto Alerta Restritivo apareceu
		assertEquals("ALERTA RESTRITIVO", this.alertPage.capturarTipoDeAlerta("ALERTA RESTRITIVO"));
	}
	
}

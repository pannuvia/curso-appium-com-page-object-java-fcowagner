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
	public void deveConfirmarAlertConfirm() {
		
		//acessar menu Alertas
		this.menuPage.acessarAlertas();
		
		//clicar em Alert Confirm
		this.alertPage.clicarEmAlertConfirm();
		
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
	
}

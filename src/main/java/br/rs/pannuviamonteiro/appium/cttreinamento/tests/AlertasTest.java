package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;
import br.rs.pannuviamonteiro.appium.cttreinamento.pages.MenuPage;

public class AlertasTest extends BaseTest {

	private MenuPage menuPage;
	private BasePage basePage;
	
	public AlertasTest() {	
		 this.basePage = new BasePage();
		 this.menuPage = new MenuPage();
	}
		
	@Before
	public void setUp() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//acessar menu Alertas

	}
	
	@Test
	public void deveConfirmarAlertaSimples() {
		
		this.menuPage.acessarAlertas();
		//clicar em Alert Simples
		this.basePage.clicarNoTexto("ALERTA SIMPLES");
		
		//validar se o titulo Info apareceu
		assertEquals("Info", this.basePage.capturarTituloDoAlerta());
		
		//validar se a mensagem Pode clicar no OK ou fora da caixa para sair apareceu
		assertEquals("Pode clicar no OK ou fora da caixa para sair", this.basePage.capturarMensagemDoAlerta());
		
		//clicar na coordenada fora da caixa
		this.basePage.clicarNumaCoordenada(100, 150);
		
		//validar se texto Alerta Simples apareceu
		assertEquals("ALERTA SIMPLES", this.basePage.capturarTipoDeAlerta("ALERTA SIMPLES"));
	}

	@Test
	public void deveConfirmarAlertaConfirm() {
		
		this.menuPage.acessarAlertas();
		//clicar em Alerta Confirm
		this.basePage.clicarNoTexto("ALERTA CONFIRM");
		
		//validar se o titulo Info apareceu
		assertEquals("Info", this.basePage.capturarTituloDoAlerta());
		
		//validar se a mensagem Confirma a operação? apareceu
		assertEquals("Confirma a operação?", this.basePage.capturarMensagemDoAlerta());
		
		//clicar em confirmar
		this.basePage.clicarNoTexto("CONFIRMAR");
		
		//validar se a mensagem Confirmado apareceu
		assertEquals("Confirmado", this.basePage.capturarMensagemDoAlerta());
		
		//clicar em sair
		this.basePage.clicarNoTexto("SAIR");
	}

	
	@Test
	public void deveConfirmarAlertaRestritivo() {

		this.menuPage.acessarAlertas();
		//clicar em Alerta Restritivo
		this.basePage.clicarNoTexto("ALERTA RESTRITIVO");
		
		//validar se o titulo Info apareceu
		assertEquals("Info", this.basePage.capturarTituloDoAlerta());
		
		//validar se a mensagem Não pode clicar fora, apenas no SAIR apareceu
		assertEquals("Não pode clicar fora, apenas no SAIR", this.basePage.capturarMensagemDoAlerta());
			
		//clicar em sair
		this.basePage.clicarNoTexto("SAIR");
		
		//validar se texto Alerta Restritivo apareceu
		assertEquals("ALERTA RESTRITIVO", this.basePage.capturarTipoDeAlerta("ALERTA RESTRITIVO"));
	}
	
}

package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;

public class AlertasTest extends BaseTest {

	private BasePage basePage;
	
	public AlertasTest() {	
		 this.basePage = new BasePage();
	}
		
	@Before
	public void setUp() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//acessar menu Alertas
		this.basePage.clicarNoTextoDoElementoPorXpath("Alertas");
	}
	
	@Test
	public void deveConfirmarAlertaSimples() {
		
		//clicar em Alert Simples
		this.basePage.clicarNoTextoDoElementoPorXpath("ALERTA SIMPLES");
		
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
		
		//clicar em Alerta Confirm
		this.basePage.clicarNoTextoDoElementoPorXpath("ALERTA CONFIRM");
		
		//validar se o titulo Info apareceu
		assertEquals("Info", this.basePage.capturarTituloDoAlerta());
		
		//validar se a mensagem Confirma a operação? apareceu
		assertEquals("Confirma a operação?", this.basePage.capturarMensagemDoAlerta());
		
		//clicar em confirmar
		this.basePage.clicarNoTextoDoElementoPorXpath("CONFIRMAR");
		
		//validar se a mensagem Confirmado apareceu
		assertEquals("Confirmado", this.basePage.capturarMensagemDoAlerta());
		
		//clicar em sair
		this.basePage.clicarNoTextoDoElementoPorXpath("SAIR");
	}

	@Test
	public void deveConfirmarAlertaRestritivo() {

		//clicar em Alerta Restritivo
		this.basePage.clicarNoTextoDoElementoPorXpath("ALERTA RESTRITIVO");
		
		//validar se o titulo Info apareceu
		assertEquals("Info", this.basePage.capturarTituloDoAlerta());
		
		//validar se a mensagem Não pode clicar fora, apenas no SAIR apareceu
		assertEquals("Não pode clicar fora, apenas no SAIR", this.basePage.capturarMensagemDoAlerta());
			
		//clicar em sair
		this.basePage.clicarNoTextoDoElementoPorXpath("SAIR");
		
		//validar se texto Alerta Restritivo apareceu
		assertEquals("ALERTA RESTRITIVO", this.basePage.capturarTipoDeAlerta("ALERTA RESTRITIVO"));
	}
	
}

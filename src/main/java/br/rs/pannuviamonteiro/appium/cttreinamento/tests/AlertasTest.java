package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import org.junit.Before;
import org.junit.Test;

public class AlertasTest extends BaseTest {

	@Before
	public void setUp() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//acessar menu Alertas
		clicarNoElementoPorXPathComTexto("Alertas");
	}
	
	@Test
	public void deveConfirmarAlertaSimples() {
		
		//clicar em Alert Simples
		clicarNoElementoPorXPathComTexto("ALERTA SIMPLES");
		
		//validar se o titulo Info apareceu
		validarSeExisteElementoPorXpathComOTexto("Info");
		
		//validar se a mensagem Pode clicar no OK ou fora da caixa para sair apareceu
		validarSeExisteElementoPorXpathComOTexto("Pode clicar no OK ou fora da caixa para sair");
		
		//clicar na coordenada fora da caixa
		clicarNumaCoordenadaDoElemento(100, 150);
		
		//validar se texto Alerta Simples apareceu
		validarSeExisteElementoPorXpathComOTexto("ALERTA SIMPLES");
	}

	@Test
	public void deveConfirmarAlertaConfirm() {
		
		//clicar em Alerta Confirm
		clicarNoElementoPorXPathComTexto("ALERTA CONFIRM");
		
		//validar se o titulo Info apareceu
		validarSeExisteElementoPorXpathComOTexto("Info");
		
		//validar se a mensagem Confirma a operação? apareceu
		validarSeExisteElementoPorXpathComOTexto("Confirma a operação?");
		
		//clicar em confirmar
		clicarNoElementoPorXPathComTexto("CONFIRMAR");
		
		//validar se a mensagem Confirmado apareceu
		validarSeExisteElementoPorXpathComOTexto("Confirmado");
		
		//clicar em sair
		clicarNoElementoPorXPathComTexto("SAIR");
	}

	@Test
	public void deveConfirmarAlertaRestritivo() {

		//clicar em Alerta Restritivo
		clicarNoElementoPorXPathComTexto("ALERTA RESTRITIVO");
		
		//validar se o titulo Info apareceu
		validarSeExisteElementoPorXpathComOTexto("Info");
		
		//validar se a mensagem Não pode clicar fora, apenas no SAIR apareceu
		validarSeExisteElementoPorXpathComOTexto("Não pode clicar fora, apenas no SAIR");
			
		//clicar em sair
		clicarNoElementoPorXPathComTexto("SAIR");
		
		//validar se texto Alerta Restritivo apareceu
		validarSeExisteElementoPorXpathComOTexto("ALERTA RESTRITIVO");
	}
	
}

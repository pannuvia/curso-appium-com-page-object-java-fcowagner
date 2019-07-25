package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import org.junit.Test;

public class AbasTest extends BaseTest {

	@Test
	public void deveNavegarEntreAbas() {
		
		//acessar menu Abas
		clicarNoElementoPorXPathComTexto("Abas");
		
		//validar se texto Este é o conteúdo da Aba 1 está aparecendo
		validarSeExisteElementoPorXpathComOTexto(("Este é o conteúdo da Aba 1"));
		
		//clicar em ABA 2
		clicarNoElementoPorXPathComTexto("ABA 2");
		
		//validar se texto Este é o conteúdo da Aba 2 está aparecendo
		validarSeExisteElementoPorXpathComOTexto("Este é o conteúdo da Aba 2");
	}
	
}

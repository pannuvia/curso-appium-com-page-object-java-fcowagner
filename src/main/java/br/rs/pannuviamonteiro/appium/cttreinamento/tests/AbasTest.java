package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import org.junit.Test;

public class AbasTest extends BaseTest {

	@Test
	public void deveNavegarEntreAbas() {
		
		//acessar menu Abas
		clicarNoElementoPorXPathComTexto("Abas");
		
		//validar se texto Este � o conte�do da Aba 1 est� aparecendo
		validarSeExisteElementoPorXpathComOTexto(("Este � o conte�do da Aba 1"));
		
		//clicar em ABA 2
		clicarNoElementoPorXPathComTexto("ABA 2");
		
		//validar se texto Este � o conte�do da Aba 2 est� aparecendo
		validarSeExisteElementoPorXpathComOTexto("Este � o conte�do da Aba 2");
	}
	
}

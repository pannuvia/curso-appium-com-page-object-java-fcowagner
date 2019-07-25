package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import org.junit.Test;

public class AccordionTest extends BaseTest {

	@Test
	public void deveInteragirComAccordions() {

		//acessar menu Accordion
		clicarNoElementoPorXPathComTexto("Accordion");
		
		//clicar na Op��o 1
		clicarNoElementoPorXPathComTexto("Op��o 1");
		
		//validar se est� na Op��o 1
		validarSeExisteElementoPorXpathComOTexto("Esta � a descri��o da op��o 1");
		
		//clicar na Op��o 3
		clicarNoElementoPorXPathComTexto("Op��o 3");
		
		//validar se est� na Op��o 3
		validarSeExisteElementoPorXpathComOTexto("Esta � a descri��o da op��o 3. Que pode, inclusive ter mais que uma linha");
	}
}

package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import org.junit.Test;

public class AccordionTest extends BaseTest {

	@Test
	public void deveInteragirComAccordions() {

		//acessar menu Accordion
		clicarNoElementoPorXPathComTexto("Accordion");
		
		//clicar na Opção 1
		clicarNoElementoPorXPathComTexto("Opção 1");
		
		//validar se está na Opção 1
		validarSeExisteElementoPorXpathComOTexto("Esta é a descrição da opção 1");
		
		//clicar na Opção 3
		clicarNoElementoPorXPathComTexto("Opção 3");
		
		//validar se está na Opção 3
		validarSeExisteElementoPorXpathComOTexto("Esta é a descrição da opção 3. Que pode, inclusive ter mais que uma linha");
	}
}

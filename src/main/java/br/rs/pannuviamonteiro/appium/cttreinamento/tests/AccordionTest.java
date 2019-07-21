package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.page.AccordionPage;
import br.rs.pannuviamonteiro.appium.cttreinamento.page.MenuPage;

public class AccordionTest extends BaseTest {

	private MenuPage menuPage;
	private AccordionPage accordionPage;

	public AccordionTest() {
		this.menuPage = new MenuPage();
		this.accordionPage = new AccordionPage();
	}

	@Test
	public void deveInteragirComAccordion() {

		// acessar menu Accordion
		this.menuPage.acessarAccordion();
		
		//clicar na Opção 1
		this.accordionPage.clicarNaOpcao1();
		
		//verificar se está na Opção 1
		this.accordionPage.verificarSeEstaNaOpcao1();
		
		//clicar na Opção 3
		this.accordionPage.clicarNaOpcao3();
		
		//verificar se está na Opção 3
		this.accordionPage.verificarSeEstaNaOpcao2();
	}
}

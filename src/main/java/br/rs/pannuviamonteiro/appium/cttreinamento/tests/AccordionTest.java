package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.AccordionPage;
import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;

public class AccordionTest extends BaseTest {

	private BasePage basePage;
	private AccordionPage accordionPage;

	public AccordionTest() {
		this.basePage = new BasePage();
		this.accordionPage = new AccordionPage();
	}

	@Test
	public void deveInteragirComAccordion() {

		//acessar menu Accordion
		this.basePage.clicarNoTextoDoElementoPorXpath("Accordion");
		
		//clicar na Op��o 1
		this.accordionPage.clicarNaOpcao1();
		
		//validar se est� na Op��o 1
		assertTrue("Esta � a descri��o da op��o 1", this.accordionPage.verificarSeEstaNaOpcao1());
		
		//clicar na Op��o 3
		this.accordionPage.clicarNaOpcao3();
		
		//validar se est� na Op��o 3
		assertTrue("Esta � a descri��o da op��o 3. Que pode, inclusive ter mais que uma linha", this.accordionPage.verificarSeEstaNaOpcao3());
	}
}

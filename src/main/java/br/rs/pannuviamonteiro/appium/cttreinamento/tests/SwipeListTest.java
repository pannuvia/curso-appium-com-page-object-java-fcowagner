package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;

public class SwipeListTest extends BaseTest{

	private BasePage basepage;
	
	public SwipeListTest() {
		basepage = new BasePage();
	}
	
	@Test
	public void deveRealizarSwipeList() {
		
		//realizar scroll up para acessar o menu Swipe List
		this.basepage.realizarScrollUpPelaJanela(0.90, 0.10);
		
		//acessar o menu Swipe List
		this.basepage.clicarNoTextoDoElementoPorXpath("Swipe List");
		
		//fazer swipeLeft na "Opção 1" para esquerda
		this.basepage.realizarSwipeLeftPeloElementoDeCimaComTexto("Opção 1", 0.90, 0.10);
		
		//clicar em (+)
		this.basepage.clicarNumaCoordenadaDoElementoComTexto("(+)", -50, 0);
		
		//validar se texto "Opção 1 (+)" está aparecendo
		assertTrue(this.basepage.validarSeExisteElementoPorXpathComOTexto("Opção 1 (+)"));
		
		//fazer swipeRight na "Opção 5 (-)" para direita
		this.basepage.realizarSwipeRightPeloElementoDeCimaComTexto("Opção 5 (-)", 0.10, 0.90);
		
		//validar se "Opção 5" está aparecendo
		assertTrue(this.basepage.validarSeExisteElementoPorXpathComOTexto("Opção 5"));
	}

	
}

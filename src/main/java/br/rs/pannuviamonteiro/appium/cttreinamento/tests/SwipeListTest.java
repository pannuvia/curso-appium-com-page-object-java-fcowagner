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
		
		//fazer swipeLeft na "Op��o 1" para esquerda
		this.basepage.realizarSwipeLeftPeloElementoDeCimaComTexto("Op��o 1", 0.90, 0.10);
		
		//clicar em (+)
		this.basepage.clicarNumaCoordenadaDoElementoComTexto("(+)", -50, 0);
		
		//validar se texto "Op��o 1 (+)" est� aparecendo
		assertTrue(this.basepage.validarSeExisteElementoPorXpathComOTexto("Op��o 1 (+)"));
		
		//fazer swipeRight na "Op��o 5 (-)" para direita
		this.basepage.realizarSwipeRightPeloElementoDeCimaComTexto("Op��o 5 (-)", 0.10, 0.90);
		
		//validar se "Op��o 5" est� aparecendo
		assertTrue(this.basepage.validarSeExisteElementoPorXpathComOTexto("Op��o 5"));
	}

	
}

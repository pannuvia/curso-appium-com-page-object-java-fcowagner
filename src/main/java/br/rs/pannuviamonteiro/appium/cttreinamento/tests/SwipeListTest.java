package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;

public class SwipeListTest extends BaseTest{

	private BasePage basePage;
	
	public SwipeListTest() {
		basePage = new BasePage();
	}
	
	@Test
	public void deveRealizarSwipeList() {
		
		//realizar scroll up para acessar o menu Swipe List
		this.basePage.realizarScrollUpPelaJanela(0.90, 0.10);
		
		//acessar o menu Swipe List
		clicarNoElementoPorXPathComTexto("Swipe List");
		
		//fazer swipeLeft na "Op��o 1" para esquerda
		this.basePage.realizarSwipeLeftPeloElementoDeCimaComTexto("Op��o 1", 0.90, 0.10);
		
		//clicar em (+)
		clicarNumaCoordenadaDoElementoComTexto("(+)", -50, 0);
		
		//validar se texto "Op��o 1 (+)" est� aparecendo
		validarSeExisteElementoPorXpathComOTexto("Op��o 1 (+)");
		
		//fazer swipeRight na "Op��o 5 (-)" para direita
		this.basePage.realizarSwipeRightPeloElementoDeCimaComTexto("Op��o 5 (-)", 0.10, 0.90);
		
		//validar se "Op��o 5" est� aparecendo
		validarSeExisteElementoPorXpathComOTexto("Op��o 5");
	}

	
}

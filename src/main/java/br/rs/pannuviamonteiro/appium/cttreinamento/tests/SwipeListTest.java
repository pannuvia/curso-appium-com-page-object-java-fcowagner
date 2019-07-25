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
		
		//fazer swipeLeft na "Opção 1" para esquerda
		this.basePage.realizarSwipeLeftPeloElementoDeCimaComTexto("Opção 1", 0.90, 0.10);
		
		//clicar em (+)
		clicarNumaCoordenadaDoElementoComTexto("(+)", -50, 0);
		
		//validar se texto "Opção 1 (+)" está aparecendo
		validarSeExisteElementoPorXpathComOTexto("Opção 1 (+)");
		
		//fazer swipeRight na "Opção 5 (-)" para direita
		this.basePage.realizarSwipeRightPeloElementoDeCimaComTexto("Opção 5 (-)", 0.10, 0.90);
		
		//validar se "Opção 5" está aparecendo
		validarSeExisteElementoPorXpathComOTexto("Opção 5");
	}

	
}

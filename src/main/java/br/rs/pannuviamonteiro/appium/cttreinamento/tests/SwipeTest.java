package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;

public class SwipeTest extends BaseTest {

	private BasePage basePage;

	public SwipeTest() {
		this.basePage = new BasePage();
	}

	@Test
	public void deveRealizarSwipeLeftRight() {
		
		//realizar scroll up para acessar o menu Swipe
		this.basePage.realizarScrollUpPelaJanela(0.9, 0.1);
		
		//clicar no menu Swipe
		clicarNoElementoPorXPathComTexto("Swipe");

		//validar se o texto "a esquerda" aparece
		validarSeExisteElementoPorXpathComOTexto("a esquerda");
		
		//realizar swipe para esquerda
		this.basePage.realizarSwipeLeftPelaJanela(0.9, 0.1);

		//validar se o texto "E veja se" aparece
		validarSeExisteElementoPorXpathComOTexto("E veja se");

		//clicar botão para direita
		clicarNoElementoPorXPathComTexto("›");
		
		//validar se o texto "Chegar até o fim!" aparece
		validarSeExisteElementoPorXpathComOTexto("Chegar até o fim!");
		
		//clicar botão para esquerda
		clicarNoElementoPorXPathComTexto("‹");
		
		//validar se o texto "E veja se" aparece
		validarSeExisteElementoPorXpathComOTexto("E veja se");
		
		//realizar swipe para direita
		this.basePage.realizarSwipeRightPelaJanela(0.1, 0.9);
		
		//validar se o texto "a esquerda" aparece
		validarSeExisteElementoPorXpathComOTexto("a esquerda");
	}
}
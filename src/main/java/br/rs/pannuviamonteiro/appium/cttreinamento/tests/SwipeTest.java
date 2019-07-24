package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;

public class SwipeTest extends BaseTest {

	private BasePage basePage;

	public SwipeTest() {
		this.basePage = new BasePage();
	}

	@Test
	public void deveRealizarSwipeLeftRight() {
		
		//realziar scroll up para acessar o menu Swipe
		this.basePage.realizarScrollUpPelaJanela(0.9, 0.1);
		
		//clicar no menu Swipe
		this.basePage.clicarNoTextoDoElementoPorXpath("Swipe");

		//validar se o texto "a esquerda" aparece
		assertTrue(this.basePage.validarSeExisteElementoPorXpathComOTexto("a esquerda"));
		
		//realizar swipe para esquerda
		this.basePage.realizarSwipeLeftPelaJanela(0.9, 0.1);

		//validar se o texto "E veja se" aparece
		this.basePage.validarSeExisteElementoPorXpathComOTexto("E veja se");

		//clicar botão para direita
		this.basePage.clicarNoTextoDoElementoPorXpath("›");
		
		//validar se o texto "Chegar até o fim!" aparece
		this.basePage.validarSeExisteElementoPorXpathComOTexto("Chegar até o fim!");
		
		//clicar botão para esquerda
		this.basePage.clicarNoTextoDoElementoPorXpath("‹");
		
		//validar se o texto "E veja se" aparece
		this.basePage.validarSeExisteElementoPorXpathComOTexto("E veja se");
		
		//realizar swipe para direita
		this.basePage.realizarSwipeRightPelaJanela(0.1, 0.9);
		
		//validar se o texto "a esquerda" aparece
		assertTrue(this.basePage.validarSeExisteElementoPorXpathComOTexto("a esquerda"));
	}
}
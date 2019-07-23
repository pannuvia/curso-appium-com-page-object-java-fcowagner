package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.AbasPage;
import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;

public class AbasTest extends BaseTest {

	private BasePage basePage;
	private AbasPage abasPage;
	
	public AbasTest() {
		this.basePage = new BasePage();
		this.abasPage = new AbasPage();
	}
	
	@Test
	public void deveNavegarEntreAbas() {
		
		//acessar menu Abas
		this.basePage.clicarNoTextoDoElementoPorXpath("Abas");
		
		//validar se texto Este é o conteúdo da Aba 1 está aparecendo
		assertTrue("Este é o conteúdo da Aba 1", this.abasPage.verificarSeEstaNaAba1());
		
		//clicar em ABA 2
		this.abasPage.clicarEmAba2();
		
		//validar se texto Este é o conteúdo da Aba 2 está aparecendo
		assertTrue("Este é o conteúdo da Aba 2", this.abasPage.verificarSeEstaNaAba2());
	}
	
}

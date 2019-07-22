package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.AbasPage;
import br.rs.pannuviamonteiro.appium.cttreinamento.pages.MenuPage;

public class AbasTest extends BaseTest {

	private MenuPage menuPage;
	private AbasPage abasPage;
	
	public AbasTest() {
		this.menuPage = new MenuPage();
		this.abasPage = new AbasPage();
	}
	
	@Test
	public void deveNavegarEntreAbas() {
		
		//acessar menu Abas
		this.menuPage.acessarAbas();
		
		//validar se texto Este é o conteúdo da Aba 1 está aparecendo
		assertTrue("Este é o conteúdo da Aba 1", this.abasPage.verificarSeEstaNaAba1());
		
		//clicar em ABA 2
		this.abasPage.clicarEmAba2();
		
		//validar se texto Este é o conteúdo da Aba 2 está aparecendo
		assertTrue("Este é o conteúdo da Aba 2", this.abasPage.verificarSeEstaNaAba2());
	}
	
}

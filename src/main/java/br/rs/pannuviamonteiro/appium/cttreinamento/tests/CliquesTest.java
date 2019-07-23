package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.CliquesPage;
import br.rs.pannuviamonteiro.appium.cttreinamento.pages.MenuPage;

public class CliquesTest extends BaseTest {

	private MenuPage menuPage;
	private CliquesPage cliquesPage;
	
	public CliquesTest() {
		this.menuPage = new MenuPage();
		this.cliquesPage = new CliquesPage();
	}
	
	@Test
	public void deveRealizarCliqueLongo() {
		menuPage.acessarCliques();
		
		cliquesPage.clicarEmCliqueLongo();
		
		assertEquals("Clique Longo", cliquesPage.capturarTextoAposClicar());
	}
}

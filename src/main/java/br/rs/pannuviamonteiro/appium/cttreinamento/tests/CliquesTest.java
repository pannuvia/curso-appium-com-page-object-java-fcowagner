package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
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
	
	@Before
	public void setUp() {
		menuPage.acessarCliques();
	}
	
	@Test
	public void deveRealizarCliqueLongo() {
				
		cliquesPage.clicarEmCliqueLongo();
		
		assertEquals("Clique Longo", cliquesPage.capturarTextoAposClicar());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
				
		menuPage.clicarPorTexto("Clique duplo");
		menuPage.clicarPorTexto("Clique duplo");
		
		assertEquals("Duplo Clique", cliquesPage.capturarTextoAposClicar());
	}
}

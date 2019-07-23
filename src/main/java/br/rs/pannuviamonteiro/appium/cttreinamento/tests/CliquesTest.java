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
		
		//clicar no Clique Longo
		cliquesPage.clicarEmCliqueLongo();
		
		//validar se apareceu o texto Clique Longo
		assertEquals("Clique Longo", cliquesPage.capturarTextoAposClicar());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
				
		//clicar duas vezes no Clique duplo
		menuPage.clicarNoTexto("Clique duplo");
		menuPage.clicarNoTexto("Clique duplo");
		
		//validar se apareceu o texto Duplo Clique
		assertEquals("Duplo Clique", cliquesPage.capturarTextoAposClicar());
	}
}

package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;
import br.rs.pannuviamonteiro.appium.cttreinamento.pages.CliquesPage;

public class CliquesTest extends BaseTest {

	private BasePage basePage;
	private CliquesPage cliquesPage;
	
	public CliquesTest() {
		this.basePage = new BasePage();
		this.cliquesPage = new CliquesPage();
	}
	
	@Before
	public void setUp() {
		basePage.clicarNoTextoDoElementoPorXpath("Cliques");
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
		basePage.clicarNoTextoDoElementoPorXpath("Clique duplo");
		basePage.clicarNoTextoDoElementoPorXpath("Clique duplo");
		
		//validar se apareceu o texto Duplo Clique
		assertEquals("Duplo Clique", cliquesPage.capturarTextoAposClicar());
	}
}

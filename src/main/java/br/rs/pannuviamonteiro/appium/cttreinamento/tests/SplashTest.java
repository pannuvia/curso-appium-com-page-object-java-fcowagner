package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.page.MenuPage;
import br.rs.pannuviamonteiro.appium.cttreinamento.page.SplashBase;

public class SplashTest extends BaseTest {

	private MenuPage menuPage;
	private SplashBase splashBase;
	
	public SplashTest() {
		 this.menuPage = new MenuPage();
		 this.splashBase = new SplashBase();
	}

	@Test
	public void deveAguardarSplashDesaparecer() {
		menuPage.acessarSplash();
		splashBase.splashEstaVisivel();
		splashBase.aguardarSplashDesaparecer();
		assertTrue(menuPage.existeElementoPorTexto("Formulário"));
	}

}

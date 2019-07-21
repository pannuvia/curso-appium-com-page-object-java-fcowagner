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
		
		//acessar Menu Splash
		this.menuPage.acessarSplash();
		
		//verificar se Splash está visivel
		this.splashBase.splashEstaVisivel();
		
		//aguardar Splash desaparecer
		this.splashBase.aguardarSplashDesaparecer();
		
		//validar se aparece texto Formulário
		assertTrue(this.menuPage.existeElementoPorTexto("Formulário"));
	}

}

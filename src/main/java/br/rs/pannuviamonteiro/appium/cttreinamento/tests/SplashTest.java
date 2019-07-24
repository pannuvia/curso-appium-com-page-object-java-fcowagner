package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;
import br.rs.pannuviamonteiro.appium.cttreinamento.pages.SplashBase;

public class SplashTest extends BaseTest {

	private BasePage basePage;
	private SplashBase splashBase;
	
	public SplashTest() {
		 this.basePage = new BasePage();
		 this.splashBase = new SplashBase();
	}

	@Test
	public void deveAguardarSplashDesaparecer() {
		
		//acessar Menu Splash
		this.basePage.clicarNoTextoDoElementoPorXpath("Splash");
		
		//verificar se Splash está visivel
		this.splashBase.verificarSeSplashEstaVisivel();
		
		//aguardar Splash desaparecer
		this.splashBase.aguardarSplashDesaparecer();
		
		//validar se aparece texto Formulário
		assertTrue(this.basePage.validarSeExisteElementoPorXpathComOTexto("Formulário"));
	}

}

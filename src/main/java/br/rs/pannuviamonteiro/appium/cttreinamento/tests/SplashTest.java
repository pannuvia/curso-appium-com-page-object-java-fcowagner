package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory;

public class SplashTest extends BaseTest {

	@Test
	public void deveAguardarSplashDesaparecer() {
		
		//acessar Menu Splash
		clicarNoElementoPorXPathComTexto("Splash");
		
		//verificar se Splash está visivel
		validarSeExisteElementoPorXpathComOTexto("Splash!");
		
		//aguardar Splash desaparecer
		aguardarSplashDesaparecer();
		
		//validar se aparece texto Formulário
		clicarNoElementoPorXPathComTexto("Formulário");
	}
	
	public void aguardarSplashDesaparecer() {
		WebDriverWait espera = new WebDriverWait(DriverFactory.getDriver(), 10);
		espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
	}

}

package br.rs.pannuviamonteiro.appium.cttreinamento.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory;

public class SplashBase extends BasePage {

	public boolean verificarSeSplashEstaVisivel() {
		return validarSeExisteElementoPorXpathComOTexto("Splash!");

	}
	
	public void aguardarSplashDesaparecer() {
		WebDriverWait espera = new WebDriverWait(DriverFactory.getDriver(), 10);
		espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
	}
	
}

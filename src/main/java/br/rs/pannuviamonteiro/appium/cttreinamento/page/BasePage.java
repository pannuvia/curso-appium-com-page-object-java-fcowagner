package br.rs.pannuviamonteiro.appium.cttreinamento.page;

import static br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

public class BasePage {
	
	public void preencherTextField(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}
	
	public String capturarTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+ texto +"']"));
	}

	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='"+ valor +"']")).click();
	}
	
	public boolean isMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
}

package br.rs.pannuviamonteiro.appium.cttreinamento.page;

import static br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

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
	
	public boolean estaMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elementos.size() > 0;
	}
}

package br.rs.pannuviamonteiro.appium.cttreinamento.pages;

import static br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

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
	
	public String capturarTituloDoAlerta() {
		return capturarTexto(By.id("android:id/alertTitle"));
	}
	
	public String capturarTipoDeAlerta(String tipoAlerta) {
		return capturarTexto(By.xpath("//*[@text='"+ tipoAlerta +"']"));
	}
	
	public String capturarMensagemDoAlerta() {
		return capturarTexto(By.id("android:id/message"));
	}

	public void clicarNoTexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));
	}

	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='" + valor + "']")).click();
	}

	public boolean verificarSeEstaMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	public boolean verificarSeExisteElementoComOTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}

	public void clicarNumaCoordenada(int x, int y) {
		new TouchAction(getDriver()).tap(x, y).perform();
	}

	public void realizarScrollGenerico(double pontoInicial, double pontoFinal) {
		Dimension size = getDriver().manage().window().getSize();

		int posicaoX = size.width / 2;

		int posicaoYInicial = (int) (size.height * pontoInicial);
		int posicaoYFinal = (int) (size.height * pontoFinal);

		new TouchAction(getDriver())
			.press(posicaoX, posicaoYInicial)
			.waitAction(Duration.ofMillis(500))
			.moveTo(posicaoX, posicaoYFinal)
			.release()
			.perform();
	}
	
}

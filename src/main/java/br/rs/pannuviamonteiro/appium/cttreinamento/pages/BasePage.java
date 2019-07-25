package br.rs.pannuviamonteiro.appium.cttreinamento.pages;

import static br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BasePage {

//	public void preencherCampoPor(By by, String texto) {
//		getDriver().findElement(by).sendKeys(texto);
//	}

	// refatorado
	public MobileElement campoPor(By by) {
		return getDriver().findElement(by);
	}

//**********************************************************            CLICAR         ****************************************************************************************

//	public void clicar(By by) {
//	getDriver().findElement(by).click();
//}

	// refatorado
	public MobileElement elementoPor(By by) {
		return getDriver().findElement(by);
	}

//	public void clicarNoTextoDoElementoPorXpath(String textoDoElemento) {
//	clicar(By.xpath("//*[@text='" + textoDoElemento + "']"));
//}

	// refatorado
	public MobileElement elementoPorXPathComTexto(String textoDoElemento) {
		return getDriver().findElement(By.xpath("//*[@text='" + textoDoElemento + "']"));
	}

//	public void clicarNumaCoordenadaDoElementoComTexto(String texto, int x, int y) {
//		MobileElement elemento = getDriver().findElement(By.xpath(("//*[@text='" + texto + "']/..")));
//		new TouchAction(getDriver()).tap(elemento, x, y).perform();
//	}

	// refatorado
	public TouchAction coordenadaDoElementoComTexto(String texto, int x, int y) {
		MobileElement elemento = getDriver().findElement(By.xpath(("//*[@text='" + texto + "']/..")));
		return new TouchAction(getDriver()).tap(elemento, x, y);
	}

//	public void clicarNumaCoordenada(int x, int y) {
//		new TouchAction(getDriver()).tap(x, y).perform();
//	}

	// refatorado
	public TouchAction coordenadaDoElemento(int x, int y) {
		return new TouchAction(getDriver()).tap(x, y);
	}

//	public void clicarNoComboComValor(By by, String valor) {
//		getDriver().findElement(by).click();
//		getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='" + valor + "']")).click();
//	}

	// refatorado
	public MobileElement comboPorXPathComValor(By by, String valor) {
		return getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='" + valor + "']"));
	}

//**********************************************************            CAPTURAR         ***************************************************************************************

	
//	public void capturarElementoPorXPathComTexto(String textoElemento) {
//		getDriver().findElement(By.xpath("//*[@text='" + textoElemento + "']"));
//	}

//	public String capturarTexto(By by) {
//		return getDriver().findElement(by).getText();
//	}
	
	// refatorado
	public MobileElement textoPorLocator(By by) {
		return getDriver().findElement(by);
	}

//	public String capturarTituloDoAlertaPorID() {
//		return capturarTexto(By.id("android:id/alertTitle"));
//	}
	
	// refatorado
	public MobileElement tituloDoAlertaPorID() {
		return textoPorLocator(By.id("android:id/alertTitle"));
	}

//	public String capturarTipoDeAlertaPorXpath(String tipoAlerta) {
//		return capturarTexto(By.xpath("//*[@text='" + tipoAlerta + "']"));
//	}
	
	// refatorado
	public MobileElement tipoDeAlertaPorXpath(String tipoAlerta) {
		return textoPorLocator(By.xpath("//*[@text='" + tipoAlerta + "']"));
	}

//	public String capturarMensagemDoAlertaPorID() {
//		return capturarTexto(By.id("android:id/message"));
//	}
	
	public MobileElement mensagemDoAlertaPorID() {
		return textoPorLocator(By.id("android:id/message"));
	}


//**********************************************************       SWIPE GENERICO PELA JANELA        **************************************************************************

	public void realizarSwipeGenericoMedindoPeloTamanhoDaJanela(double pontoInicial, double pontoFinal) {
		Dimension size = getDriver().manage().window().getSize();

		int posicaoY = size.height / 2;

		int posicaoXInicial = (int) (size.width * pontoInicial);
		int posicaoXFinal = (int) (size.width * pontoFinal);

		new TouchAction(getDriver()).press(posicaoXInicial, posicaoY).waitAction(Duration.ofMillis(500))
				.moveTo(posicaoXFinal, posicaoY).release().perform();
	}

//************************************************       SWIPE PELA JANELA COM COORDENADAS X e Y    ***************************************************************************

	public void realizarSwipeRightPelaJanela(double pontoEsquerda, double pontoDireita) {
		realizarScrollGenericoMedindoPeloTamanhoDaJanela(pontoEsquerda, pontoDireita);
	}

	public void realizarSwipeLeftPelaJanela(double pontoDireita, double pontoEsquerda) {
		realizarScrollGenericoMedindoPeloTamanhoDaJanela(pontoDireita, pontoEsquerda);
	}

//**********************************************************     SWIPE GENERICO PELO ELEMENTO     *****************************************************************************

	public void realizarSwipeGenericoMedindoPeloTamanhoDoElemento(MobileElement elemento, double pontoInicial,
			double pontoFinal) {
		int posicaoY = elemento.getLocation().y + (elemento.getSize().height / 2);

		int posicaoXInicial = (int) (elemento.getSize().width * pontoInicial);
		int posicaoXFinal = (int) (elemento.getSize().width * pontoFinal);

		new TouchAction(getDriver()).press(posicaoXInicial, posicaoY).waitAction(Duration.ofMillis(500))
				.moveTo(posicaoXFinal, posicaoY).release().perform();
	}

//**********************************************************    SWIPE PELO ELEMENTO COM COORDENADAS X e Y      ****************************************************************

	public void realizarSwipeRightPeloElemento(MobileElement elemento, double pontoEsquerda, double pontoDireita) {
		realizarSwipeGenericoMedindoPeloTamanhoDoElemento(elemento, pontoEsquerda, pontoDireita);
	}

	public void realizarSwipeLeftPeloElemento(MobileElement elemento, double pontoDireita, double pontoEsquerda) {
		realizarSwipeGenericoMedindoPeloTamanhoDoElemento(elemento, pontoDireita, pontoEsquerda);
	}

//**********************************************************    SWIPE PELO ELEMENTO DE CIMA "/.." COM O TEXTO E COORDENADAS X e Y     ******************************************

	public void realizarSwipeRightPeloElementoDeCimaComTexto(String texto, double pontoEsquerda, double pontoDireita) {
		realizarSwipeLeftPeloElemento(getDriver().findElement(By.xpath("//*[@text='" + texto + "']/..")), pontoEsquerda,
				pontoDireita);
	}

	public void realizarSwipeLeftPeloElementoDeCimaComTexto(String texto, double pontoDireita, double pontoEsquerda) {
		realizarSwipeLeftPeloElemento(getDriver().findElement(By.xpath("//*[@text='" + texto + "']/..")), pontoDireita,
				pontoEsquerda);
	}

//**********************************************************    SWIPE PELO ELEMENTO COM O TEXTO E COORDENADAS X e Y     ******************************************************

	public void realizarSwipeRightPeloElementoComTexto(String texto, double pontoEsquerda, double pontoDireita) {
		realizarSwipeLeftPeloElemento(getDriver().findElement(By.xpath("//*[@text='" + texto + "']")), pontoEsquerda,
				pontoDireita);
	}

	public void realizarSwipeLeftPeloElementoComTexto(String texto, double pontoDireita, double pontoEsquerda) {
		realizarSwipeLeftPeloElemento(getDriver().findElement(By.xpath("//*[@text='" + texto + "']")), pontoDireita,
				pontoEsquerda);
	}

//**********************************************************       SCROLL GENERICO PELA JANELA          **********************************************************************

	public void realizarScrollGenericoMedindoPeloTamanhoDaJanela(double pontoInicial, double pontoFinal) {
		Dimension size = getDriver().manage().window().getSize();

		int posicaoX = size.width / 2;

		int posicaoYInicial = (int) (size.height * pontoInicial);
		int posicaoYFinal = (int) (size.height * pontoFinal);

		new TouchAction(getDriver()).press(posicaoX, posicaoYInicial).waitAction(Duration.ofMillis(500))
				.moveTo(posicaoX, posicaoYFinal).release().perform();
	}

//**********************************************************         SCROLL PELA JANELA COM COORDENADAS X e Y         *********************************************************

	public void realizarScrollUpPelaJanela(double pontoAbaixo, double pontoAcima) {
		realizarScrollGenericoMedindoPeloTamanhoDaJanela(pontoAbaixo, pontoAcima);
	}

	public void realizarScrollDownPelaJanela(double pontoAcima, double pontoAbaixo) {
		realizarScrollGenericoMedindoPeloTamanhoDaJanela(pontoAcima, pontoAbaixo);
	}

//**********************************************************        SCROLL GENERICO PELO ELEMENTO         ********************************************************************

	public void realizarScrollGenericoMedindoPeloTamanhoDoElemento(MobileElement elemento, double pontoInicial,
			double pontoFinal) {
		int posicaoX = elemento.getLocation().x + (elemento.getSize().width / 2);

		int posicaoYInicial = (int) (elemento.getSize().height * pontoInicial);
		int posicaoYFinal = (int) (elemento.getSize().height * pontoFinal);

		new TouchAction(getDriver()).press(posicaoX, posicaoYInicial).waitAction(Duration.ofMillis(500))
				.moveTo(posicaoX, posicaoYFinal).release().perform();
	}

//**********************************************************    SCROLL PELO ELEMENTO COM COORDENADAS X e Y      ****************************************************************

	public void realizarScrollUpPeloElemento(MobileElement elemento, double pontoAbaixo, double pontoAcima) {
		realizarScrollGenericoMedindoPeloTamanhoDoElemento(elemento, pontoAbaixo, pontoAcima);
	}

	public void realizarScrollDownPeloElemento(MobileElement elemento, double pontoAcima, double pontoAbaixo) {
		realizarScrollGenericoMedindoPeloTamanhoDoElemento(elemento, pontoAcima, pontoAbaixo);
	}

//**********************************************************    SCROLL PELO ELEMENTO COM O TEXTO E COORDENADAS X e Y     ******************************************************

	public void realizarScrollUpPeloElementoComTexto(String texto, double pontoAbaixo, double pontoAcima) {
		realizarScrollGenericoMedindoPeloTamanhoDoElemento(
				getDriver().findElement(By.xpath("//*[@text='" + texto + "']")), pontoAbaixo, pontoAcima);
	}

	public void realizarScrollDownPeloElementoComTexto(String texto, double pontoAcima, double pontoAbaixo) {
		realizarSwipeLeftPeloElemento(getDriver().findElement(By.xpath("//*[@text='" + texto + "']")), pontoAcima,
				pontoAbaixo);
	}

}

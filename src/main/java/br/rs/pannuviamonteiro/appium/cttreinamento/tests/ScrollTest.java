package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;

public class ScrollTest extends BaseTest {

	private BasePage basePage;

	public ScrollTest() {
		this.basePage = new BasePage();
	}

	@Test
	public void deveRealizarScrollUpDown() {

		//realizar scroll up para acessar o menu "Op��o bem escondida"
		this.basePage.realizarScrollUp(0.9, 0.1);

		//clicar no menu "Op��o bem escondida"
		this.basePage.clicarNoTextoDoElementoPorXpath("Op��o bem escondida");

		//validar se apareceu a mensagem Voc� achou essa op��o
		assertEquals("Voc� achou essa op��o", this.basePage.capturarMensagemDoAlerta());

		//clicar em OK
		this.basePage.clicarNoTextoDoElementoPorXpath("OK");
		
		//esperar at� o texto "Op��o bem escondida" aparecer
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Op��o bem escondida']")));
		
		//realizar scroll down para visualizar o menu "Formul�rio"
		this.basePage.realizarScrollDown(0.1, 0.9);
		
		//validar se apareceu o menu Formul�rio
		assertTrue(this.basePage.validarSeExisteElementoPorXpathComOTexto("Formul�rio"));
		
	}
}

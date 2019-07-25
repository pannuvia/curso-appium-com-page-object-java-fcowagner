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

		//realizar scroll up para acessar o menu "Opção bem escondida"
		this.basePage.realizarScrollUpPelaJanela(0.9, 0.1);

		//clicar no menu "Opção bem escondida"
		clicarNoElementoPorXPathComTexto("Opção bem escondida");

		//validar se apareceu a mensagem Você achou essa opção
		validarSeExisteElementoPorXpathComOTexto("Você achou essa opção");

		//clicar em OK
		clicarNoElementoPorXPathComTexto("OK");
		
		//esperar até o texto "Opção bem escondida" aparecer
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Opção bem escondida']")));
		
		//realizar scroll down para visualizar o menu "Formulário"
		this.basePage.realizarScrollDownPelaJanela(0.1, 0.9);
		
		//validar se apareceu o menu Formulário
		validarSeExisteElementoPorXpathComOTexto("Formulário");
		
	}
}

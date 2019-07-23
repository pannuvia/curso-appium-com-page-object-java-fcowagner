package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;

public class ScrollTest extends BaseTest{

	private BasePage basePage;
	
	public ScrollTest() {
		this.basePage = new BasePage();
	}
	
	@Test
	public void deveRealizarScrollDown() {
		
		//realizar espera at� o elemento Formul�rio aparecer
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		
		//realizar scroll down
		basePage.realizarScrollGenerico(0.9, 0.1);
		
		//clicar no menu Op��o bem escondida
		basePage.clicarNoTexto("Op��o bem escondida");
		
		//verificar se apareceu a mensagem Voc� achou essa op��o
		assertEquals("Voc� achou essa op��o", basePage.capturarMensagemDoAlerta());
		
		//clicar em OK
		basePage.clicarNoTexto("OK");
	}

}

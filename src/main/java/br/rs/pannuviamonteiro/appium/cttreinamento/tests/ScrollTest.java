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
		
		//realizar espera até o elemento Formulário aparecer
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		
		//realizar scroll down
		basePage.realizarScrollGenerico(0.9, 0.1);
		
		//clicar no menu Opção bem escondida
		basePage.clicarNoTexto("Opção bem escondida");
		
		//verificar se apareceu a mensagem Você achou essa opção
		assertEquals("Você achou essa opção", basePage.capturarMensagemDoAlerta());
		
		//clicar em OK
		basePage.clicarNoTexto("OK");
	}

}

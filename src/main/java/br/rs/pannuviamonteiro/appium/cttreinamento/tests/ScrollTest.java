package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;

public class ScrollTest extends BaseTest {

	private BasePage basePage;

	public ScrollTest() {
		this.basePage = new BasePage();
	}

	@Test
	public void deveRealizarScroll() throws InterruptedException {

//		// esperar at� texto "Formul�rio" aparecer
//		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));

		// realizar scroll down
		this.basePage.realizarScrollDown(0.9, 0.1);

		// clicar no menu Op��o bem escondida
		this.basePage.clicarNoTextoDoElementoPorXpath("Op��o bem escondida");

		// validar se apareceu a mensagem Voc� achou essa op��o
		assertEquals("Voc� achou essa op��o", this.basePage.capturarMensagemDoAlerta());

		// clicar em OK
		this.basePage.clicarNoTextoDoElementoPorXpath("OK");
		
	}
}

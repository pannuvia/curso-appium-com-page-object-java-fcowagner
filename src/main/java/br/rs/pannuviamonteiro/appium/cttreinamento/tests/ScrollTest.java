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

//		// esperar até texto "Formulário" aparecer
//		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));

		// realizar scroll down
		this.basePage.realizarScrollDown(0.9, 0.1);

		// clicar no menu Opção bem escondida
		this.basePage.clicarNoTextoDoElementoPorXpath("Opção bem escondida");

		// validar se apareceu a mensagem Você achou essa opção
		assertEquals("Você achou essa opção", this.basePage.capturarMensagemDoAlerta());

		// clicar em OK
		this.basePage.clicarNoTextoDoElementoPorXpath("OK");
		
	}
}

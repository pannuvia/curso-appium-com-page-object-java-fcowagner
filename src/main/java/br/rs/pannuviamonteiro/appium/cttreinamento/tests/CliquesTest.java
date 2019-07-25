package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory.getDriver;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import io.appium.java_client.TouchAction;

public class CliquesTest extends BaseTest {

	@Before
	public void setUp() {
		clicarNoElementoPorXPathComTexto("Cliques");
	}

	@Test
	public void deveRealizarCliqueLongo() {

		//clicar no Clique Longo
		new TouchAction(getDriver()).longPress(getDriver().findElement(By.xpath("//*[@text='Clique Longo']")))
				.perform();

		//validar se apareceu o texto Clique Longo
		validarSeExisteElementoPorXpathComOTexto("Clique Longo");
	}

	@Test
	public void deveRealizarCliqueDuplo() {

		//clicar duas vezes no Clique duplo
		clicarNoElementoPorXPathComTexto("Clique duplo");
		clicarNoElementoPorXPathComTexto("Clique duplo");

		//validar se apareceu o texto Duplo Clique
		validarSeExisteElementoPorXpathComOTexto("Clique duplo");
	}
	
	@Test
	public void deveRealizarCliqueDuploLento() {

		//clicar no Clique Longo
		new TouchAction(getDriver()).longPress(getDriver().findElement(By.xpath("//*[@text='Clique duplo lento']")))
				.perform();
		
		new TouchAction(getDriver()).longPress(getDriver().findElement(By.xpath("//*[@text='Clique duplo lento']")))
		.perform();

		//validar se apareceu o texto Clique Longo
		validarSeExisteElementoPorXpathComOTexto("Clique duplo lento");
	}
	
}

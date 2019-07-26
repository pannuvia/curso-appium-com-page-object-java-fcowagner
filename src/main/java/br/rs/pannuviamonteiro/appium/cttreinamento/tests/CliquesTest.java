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

	BaseTest baseTest = new BaseTest();
	
	@Test
	public void deveRealizarCliqueLongo() {

		//clicar no Clique Longo
		clicarLongoNoElementoPorLocator(By.xpath("//*[@text='Clique Longo']"));
		
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
		clicarLongoNoElementoPorLocator(By.xpath("//*[@text='Clique duplo lento']"));
		clicarLongoNoElementoPorLocator(By.xpath("//*[@text='Clique duplo lento']"));

		//validar se apareceu o texto Clique Longo
		validarSeExisteElementoPorXpathComOTexto("Clique duplo lento");
	}
	
}

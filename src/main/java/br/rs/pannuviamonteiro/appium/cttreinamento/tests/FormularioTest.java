package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class FormularioTest {

	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();

		// clicar em Formulário
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	}
	
	@Test
	public void preencherFormulario() throws MalformedURLException {
		// preencher textfield
		driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("Pannuvia");

		// clicar na combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		// selecionar a opção desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

		// clicar no checkBox
		driver.findElement(By.className("android.widget.CheckBox")).click();

		// clicar no switch
		driver.findElement(MobileBy.AccessibilityId("switch")).click();

		// salvar
		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();

		// validar textfield
		MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Pannuvia']"));
		assertEquals("Nome: Pannuvia", nome.getText());

		// validar combo
		MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
		assertEquals("Console: switch", combo.getText());

		// validar checkbox
		MobileElement checkbox = driver
				.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
		assertTrue(checkbox.getText().endsWith("Marcado"));

		// validar switch
		MobileElement switchElement = driver
				.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
		assertTrue(switchElement.getText().endsWith("Off"));
	}

	@After
	public void fecharDriver() {
		DriverFactory.destroyDriver();
	}

}

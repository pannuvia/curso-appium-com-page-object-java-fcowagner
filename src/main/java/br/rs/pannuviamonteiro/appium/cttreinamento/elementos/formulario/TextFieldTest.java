package br.rs.pannuviamonteiro.appium.cttreinamento.elementos.formulario;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TextFieldTest {

	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"D:\\DBSERVER\\BACKUP PROJETOS\\eclipse-workspace\\curso-appium-java-fcowagner\\src\\main\\resources\\CTAppium-1-1.apk");

		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// clicar em Formulário
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	}
	
	@Test
	public void preencherTextField() throws MalformedURLException {
//		//Listar elementos da tela para saber quais são e poder usar o método abaixo
//		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
//		for(MobileElement elemento: elementosEncontrados) {
//			System.out.println(elemento.getText());
//		}

//		// clicar em Formulário
//		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
//		elementosEncontrados.get(1).click();

		// preencher textfield nome
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Pannuvia");

		// validar nome preenchido
		String nomePreenchido = campoNome.getText();
		Assert.assertEquals("Pannuvia", nomePreenchido);
	}

	@After
	public void fecharDriver() {
		driver.quit();
	}
}

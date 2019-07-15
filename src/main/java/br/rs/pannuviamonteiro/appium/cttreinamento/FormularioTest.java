package br.rs.pannuviamonteiro.appium.cttreinamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTest {

	@Test
	public void preencherFormulario() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"D:\\DBSERVER\\BACKUP PROJETOS\\eclipse-workspace\\curso-appium-java-fcowagner\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// clicar em Formulário
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();

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
		
		//salvar
		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
		
		// validar textfield
		MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Pannuvia']"));
		assertEquals("Nome: Pannuvia", nome.getText());
		
		//validar combo
		MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
		assertEquals("Console: switch", combo.getText());
		
		//validar checkbox
		MobileElement checkbox = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
		assertTrue(checkbox.getText().endsWith("Marcado"));
		
		//validar switch
		MobileElement switchElement = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
		assertTrue(switchElement.getText().endsWith("Off"));
		
		// fechar driver
		driver.quit();
		
	}
}

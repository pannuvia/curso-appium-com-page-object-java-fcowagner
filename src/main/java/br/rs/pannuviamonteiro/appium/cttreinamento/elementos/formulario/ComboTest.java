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

public class ComboTest {

	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"D:\\DBSERVER\\BACKUP PROJETOS\\eclipse-workspace\\curso-appium-java-fcowagner\\src\\main\\resources\\CTAppium-1-1.apk");

		try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
					desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// clicar em Formulário
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	}
	
	@Test
	public void selecionarCombo(){
//		// clicar em Formulário
//		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

		// clicar na combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();

		// selecionar a opção desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

		// validar opção selecionada
		String opcaoSelecionada = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView"))
				.getText();
		Assert.assertEquals("Nintendo Switch", opcaoSelecionada);
	}

	@After
	public void fecharDriver() {
		driver.quit();
	}
}

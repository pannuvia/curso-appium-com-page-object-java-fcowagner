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

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DataPickerTest {

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
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// clicar em Formulário
		driver.findElement(By.xpath("//*[@text='Formulário']")).click();
	}

	@Test
	public void selecionarData() {
		// clicar na data
		driver.findElement(By.xpath("//android.widget.TextView[@text='01/01/2000']")).click();

		// selecionar o dia
		driver.findElement(By.xpath("//android.view.View[@text='20']")).click();

		// clicar em OK
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		
		// validar data selecionada
		String dataSelecionada = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[@text='20/2/2000']")).getText();
		Assert.assertEquals("20/2/2000", dataSelecionada);
	}


	@After
	public void fecharDriver() {
		driver.quit();
	}

}

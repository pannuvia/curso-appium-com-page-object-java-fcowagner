package br.rs.pannuviamonteiro.appium.cttreinamento;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ElementosFormularioTest {

	@Test
	public void preencherCampoTexto() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"D:\\DBSERVER\\BACKUP PROJETOS\\eclipse-workspace\\curso-appium-java-fcowagner\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		//Listar elementos da tela
//		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
//		for(MobileElement elemento: elementosEncontrados) {
//			System.out.println(elemento.getText());
//		}

		// clicar em Formul�rio
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		elementosEncontrados.get(1).click();

		// escrever nome
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Pannuvia");

		// validar nome preenchido
		String nomePreenchido = campoNome.getText();
		Assert.assertEquals("Pannuvia", nomePreenchido);

		// fechar driver
		driver.quit();
	}

	@Test
	public void selecionarCombo() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"D:\\DBSERVER\\BACKUP PROJETOS\\eclipse-workspace\\curso-appium-java-fcowagner\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// clicar em Formul�rio
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formul�rio']")).click();

		// clicar na combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();

		// selecionar a op��o desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();

		// validar op��o selecionada
		String opcaoSelecionada = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView"))
				.getText();
		Assert.assertEquals("Nintendo Switch", opcaoSelecionada);

		// fechar driver
		driver.quit();
	}

	@Test
	public void interagirComChechBox() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"D:\\DBSERVER\\BACKUP PROJETOS\\eclipse-workspace\\curso-appium-java-fcowagner\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// clicar em Formul�rio
		driver.findElement(By.xpath("//*[@text='Formul�rio']")).click();

		// verificar status do checkbox
		MobileElement checkBox = driver.findElement(By.className("android.widget.CheckBox"));
		Assert.assertTrue(checkBox.getAttribute("checked").equals("false"));

		// clicar no checkBox
		checkBox.click();

		// validar status alterado do checkbox
		Assert.assertTrue(checkBox.getAttribute("checked").equals("true"));
		// Assert.assertFalse(checkBox.getAttribute("checked").equals("false"));

		// fechar driver
		driver.quit();
	}

	@Test
	public void interagirComSwitch() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP,
				"D:\\DBSERVER\\BACKUP PROJETOS\\eclipse-workspace\\curso-appium-java-fcowagner\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// clicar em Formul�rio
		driver.findElement(By.xpath("//*[@text='Formul�rio']")).click();

		// validar status do switch
		MobileElement switchElement = driver.findElement(MobileBy.AccessibilityId("switch"));
		Assert.assertTrue(switchElement.getAttribute("checked").equals("true"));

		// clicar no switch
		switchElement.click();

		// validar status alterado do switch
		Assert.assertTrue(switchElement.getAttribute("checked").equals("false"));
		// Assert.assertFalse(switchElement.getAttribute("checked").equals("true"));

		// fechar driver
		driver.quit();
	}
}

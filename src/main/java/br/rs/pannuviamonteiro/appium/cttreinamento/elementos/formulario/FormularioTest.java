package br.rs.pannuviamonteiro.appium.cttreinamento.elementos.formulario;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

public class FormularioTest {

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
	public void preencherFormulario() {
		
		// preencher textfield
		driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("Pannuvia");

		// clicar na combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		// selecionar a opção desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		//clicar no seekbar
		driver.findElement(MobileBy.AccessibilityId("slid")).click();
		
		// clicar no checkBox
		driver.findElement(By.className("android.widget.CheckBox")).click();

		// clicar no switch
		driver.findElement(MobileBy.AccessibilityId("switch")).click();
		
		// clicar na data
		driver.findElement(By.xpath("//android.widget.TextView[@text='01/01/2000']")).click();

		// selecionar o dia
		driver.findElement(By.xpath("//android.view.View[@text='20']")).click();

		// clicar em OK
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		
		// clicar no horario
		driver.findElement(By.xpath("//android.widget.TextView[@text='06:00']")).click();
		
		//clicar na hora
		driver.findElement(MobileBy.AccessibilityId("16")).click();
		
		// clicar nos minutos
		driver.findElement(MobileBy.AccessibilityId("35")).click();
		
		// clicar em OK
		driver.findElement(By.xpath("//android.widget.Button[@text='OK']")).click();
		
		// salvar
		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();

		// validar textfield
		MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: Pannuvia']"));
		assertEquals("Nome: Pannuvia", nome.getText());

		// validar combo
		MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
		assertEquals("Console: switch", combo.getText());
		
		//validar seekbar
		MobileElement seekbar = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]"));
		assertTrue(seekbar.getText().endsWith("51"));

		// validar checkbox
		MobileElement checkbox = driver
				.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
		assertTrue(checkbox.getText().endsWith("Marcado"));

		// validar switch
		MobileElement switchElement = driver
				.findElement(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
		assertTrue(switchElement.getText().endsWith("Off"));
		
		// validar data selecionada
		String dataSelecionada = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[@text='20/2/2000']")).getText();
		Assert.assertEquals("20/2/2000", dataSelecionada);
		
		// validar horario selecionado
		String horarioSelecionado = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[@text='16:35']")).getText();
		Assert.assertEquals("16:35", horarioSelecionado);
	}

	@After
	public void fecharDriver() {
		driver.quit();
	}

}

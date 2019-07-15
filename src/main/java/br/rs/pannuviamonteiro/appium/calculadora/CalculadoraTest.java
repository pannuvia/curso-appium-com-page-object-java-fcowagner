package br.rs.pannuviamonteiro.appium.calculadora;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalculadoraTest {

	private AndroidDriver<MobileElement> driver;
	
	@Test
	public void deveSomarDoisNumeros() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
		desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		desiredCapabilities.setCapability("noReset", "true");

		driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"),
				desiredCapabilities);

		MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
		el2.click();
		MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
		el3.click();
		MobileElement el4 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");
		
		Assert.assertEquals("4", el4.getText());

		driver.quit();
	}


	
}

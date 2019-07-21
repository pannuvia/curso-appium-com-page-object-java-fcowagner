package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory;

public class BaseTest {

	@Rule
	public TestName testName = new TestName();
	
	@AfterClass
	public static void finalizarDriver() {
		DriverFactory.destroyDriver();
	}
	
	@After
	public void fecharDriver() {
		gerarScreenshot();
		DriverFactory.getDriver().resetApp();
	}

	public void gerarScreenshot() {
		File imagem = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem, new File("target/screenshots/"+testName.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

package br.rs.pannuviamonteiro.appium.cttreinamento.pages;

import static br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class DragAndDropPage extends BasePage {

	public String[] capturarValoresDaLista() {
		List<MobileElement> elementosDaTela = getDriver().findElements(By.className("android.widget.TextView"));
		String[] array = new String[elementosDaTela.size()];
		for(int i = 0; i < elementosDaTela.size(); i++ ) {
			array[i] = elementosDaTela.get(i).getText();
			//System.out.println("\"" + array[i] + "\", ");
		}
		return array;
	}

	public void arrastarOrigemDestino (String origem, String destino) {
		MobileElement inicio = getDriver().findElement(By.xpath("//*[@text='"+ origem +"']"));
		MobileElement fim = getDriver().findElement(By.xpath("//*[@text='"+ destino +"']"));
		
		new TouchAction(getDriver())
			.longPress(inicio)
			.moveTo(fim)
			.release()
			.perform();	
	}
}

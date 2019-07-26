package br.rs.pannuviamonteiro.appium.cttreinamento.pages;

import static br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage {

	public MobileElement campoNome() {
		return campoPorLocator(MobileBy.AccessibilityId("nome"));
	}
	
	public MobileElement campoCombo() {
		return getDriver().findElement(MobileBy.AccessibilityId("console"));
	}
		
	public MobileElement opcaoCombo(String texto) {
			return getDriver().findElement(By.xpath("//android.widget.CheckedTextView[@text='" + texto + "']"));
	}
		
	public MobileElement campoSeekBar(double posicaoClicada) {
		
		int delta = 50;
		
		MobileElement seekbar = getDriver().findElement((MobileBy.AccessibilityId("slid")));
		
		int yInicial = seekbar.getLocation().y + (seekbar.getSize().height / 2);
		System.out.println(yInicial);
		
		int xInicial = (int) ((seekbar.getLocation().x) + delta + ((seekbar.getSize().width - 2 * delta) * posicaoClicada));
		System.out.println(xInicial);
		
		return seekbar;
	}
	
	public MobileElement campoCheckbox() {
		return campoPorLocator(By.className("android.widget.CheckBox"));
	}

	public MobileElement campoSwitch() {
		return campoPorLocator(MobileBy.AccessibilityId("switch"));
	}
	
	public MobileElement campoDataPicker(String data) {
		return elementoPorXPathComTexto(data);
	}
	
	public MobileElement campoTimePicker(String horario) {
		return elementoPorXPathComTexto(horario);
		//return campoPorLocator(By.xpath("//android.widget.TextView[@text='"+ horario +"']"));
	}
	
	public MobileElement campoHora(String hora) {
		return campoPorLocator(MobileBy.AccessibilityId(hora));
	}
	
	public MobileElement campoMinutos(String minutos) {
		return campoPorLocator(MobileBy.AccessibilityId(minutos));
	}

	public MobileElement botaoSalvar() {
		return elementoPorXPathComTexto("SALVAR");
	}
	
	public MobileElement nomeAposSalvar() {
		return campoPorLocator(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}

	public MobileElement comboAposSalvar() {
		return campoPorLocator(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}

	public MobileElement checkboxAposSalvar() {
		return campoPorLocator(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}

	public MobileElement switchAposSalvar() {
		return campoPorLocator(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}

	public MobileElement seekBarAposSalvar() {
		return campoPorLocator(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]"));
	}

	
}
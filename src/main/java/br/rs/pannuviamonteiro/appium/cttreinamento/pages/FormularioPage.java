package br.rs.pannuviamonteiro.appium.cttreinamento.pages;

import static br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage {

	public void preencherTextFieldNome(String nome) {
		preencherTextField(MobileBy.AccessibilityId("nome"), nome);
	}

	public void selecionarValorNoCombo(String combo) {
		selecionarCombo(MobileBy.AccessibilityId("console"), combo);
	}

	public void clicarNoSeekBar(double posicaoClicada) {
		MobileElement seekbar = getDriver().findElement((MobileBy.AccessibilityId("slid")));
		
		int yInicial = seekbar.getLocation().y + (seekbar.getSize().height / 2);
		System.out.println(yInicial);
		
		int xInicial = (int) (seekbar.getLocation().x + (seekbar.getSize().width * posicaoClicada));
		System.out.println(xInicial);
		
		clicarNumaCoordenada(xInicial, yInicial);
	}
	
	public void clicarNoCheckbox() {
		clicar(By.className("android.widget.CheckBox"));
	}

	public void clicarNoSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public void clicarNoDataPicker(String data) {
		clicar(By.xpath("//android.widget.TextView[@text='"+ data +"']"));
	}
	
	public void clicarNoTimePicker(String horario) {
		clicar(By.xpath("//android.widget.TextView[@text='"+ horario +"']"));
	}
	
	public void clicarNaHora(String hora) {
		clicar(MobileBy.AccessibilityId(hora));
	}
	
	public void clicarNosMinutos(String minutos) {
		clicar(MobileBy.AccessibilityId(minutos));
	}

	public boolean verificarSeCheckboxEstaMarcado() {
		return verificarSeEstaMarcado(By.className("android.widget.CheckBox"));
	}

	public boolean verificarSeSwitchEstaMarcado() {
		return verificarSeEstaMarcado(MobileBy.AccessibilityId("switch"));
	}

	public String capturarNomeAposSalvar() {
		return capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}

	public String capturarComboAposSalvar() {
		return capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}

	public String capturarCheckboxAposSalvar() {
		return capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}

	public String capturarSwitchAposSalvar() {
		return capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}
	
	public String capturarSeekBarAposSalvar() {
		return capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Slider:')]"));
	}

	public void clicarEmSalvar() {
		clicarPorTexto("SALVAR");
	}
}

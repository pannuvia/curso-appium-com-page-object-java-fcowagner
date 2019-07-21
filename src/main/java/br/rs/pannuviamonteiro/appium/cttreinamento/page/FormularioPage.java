package br.rs.pannuviamonteiro.appium.cttreinamento.page;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage {

	public void preencherNome(String nome) {
		preencherTextField(MobileBy.AccessibilityId("nome"), nome);
	}

	public String capturarNome() {
		return capturarTexto(MobileBy.AccessibilityId("nome"));
	}

	public void selecionarCombo(String combo) {
		selecionarCombo(MobileBy.AccessibilityId("console"), combo);
	}

	public String capturarCombo() {
		return capturarTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}

	public void clicarNoCheckbox() {
		clicar(By.className("android.widget.CheckBox"));
	}

	public void clicarNoSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}

	public boolean verificarSeCheckboxEstaMarcado() {
		return estaMarcado(By.className("android.widget.CheckBox"));
	}

	public boolean verificarSeSwitchEstaMarcado() {
		return estaMarcado(MobileBy.AccessibilityId("switch"));
	}

	public String capturarNomeCadastrado() {
		return capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}

	public String capturarComboCadastrado() {
		return capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}

	public String capturarCheckboxCadastrado() {
		return capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}

	public String capturarSwitchCadastrado() {
		return capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}

	public void clicarEmSalvar() {
		clicarPorTexto("SALVAR");
	}
}

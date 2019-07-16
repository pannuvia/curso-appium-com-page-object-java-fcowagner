package br.rs.pannuviamonteiro.appium.cttreinamento.page;

import org.openqa.selenium.By;

import br.rs.pannuviamonteiro.appium.cttreinamento.core.DSL;
import io.appium.java_client.MobileBy;

public class FormularioPage {

	private DSL dsl;

	public FormularioPage() {
		this.dsl = new DSL();
	}

	public void preencherNome(String nome) {
		dsl.preencherTextField(MobileBy.AccessibilityId("nome"), nome);
	}

	public String capturarNome() {
		return dsl.capturarTexto(MobileBy.AccessibilityId("nome"));
	}

	public void selecionarCombo(String combo) {
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), combo);
	}

	public String capturarCombo() {
		return dsl.capturarTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}

	public void clicarCheckBox() {
		dsl.clicar(By.className("android.widget.CheckBox"));
	}

	public void clicarSwitch() {
		dsl.clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return dsl.isMarcado(By.className("android.widget.CheckBox"));
	}

	public boolean isSwitchMarcado() {
		return dsl.isMarcado(MobileBy.AccessibilityId("switch"));
	}

	public String capturarNomeCadastrado() {
		return dsl.capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}

	public String capturarComboCadastrado() {
		return dsl.capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}

	public String capturarCheckBoxCadastrado() {
		return dsl.capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}

	public String capturarSwitchCadastrado() {
		return dsl.capturarTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}
	
	public void salvar() {
		dsl.clicarPorTexto("SALVAR");
	}
}

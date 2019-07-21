package br.rs.pannuviamonteiro.appium.cttreinamento.page;

import org.openqa.selenium.By;

public class AlertasPage extends BasePage {

	public void clicarEmAlertConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public String capturarTituloDoAlerta() {
		return capturarTexto(By.id("android:id/alertTitle"));
	}
	
	public String capturarMensagemDoAlerta() {
		return capturarTexto(By.id("android:id/message"));
	}
	
	public void clicarEmConfirmar() {
		clicarPorTexto("CONFIRMAR");
	}

	public void clicarEmSair() {
		clicarPorTexto("SAIR");
		
	}
}

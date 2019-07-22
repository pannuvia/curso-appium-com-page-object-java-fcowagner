package br.rs.pannuviamonteiro.appium.cttreinamento.page;

import org.openqa.selenium.By;

public class AlertasPage extends BasePage {

	public void clicarEmAlertaConfirm() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	
	public void clicarEmAlertaSimples() {
		clicarPorTexto("ALERTA SIMPLES");
	}
	
	public void clicarEmAlertaRestritivo() {
		clicarPorTexto("ALERTA RESTRITIVO");
	}
	
	public String capturarTituloDoAlerta() {
		return capturarTexto(By.id("android:id/alertTitle"));
	}
	
	public String capturarTipoDeAlerta(String tipoAlerta) {
		return capturarTexto(By.xpath("//*[@text='"+ tipoAlerta +"']"));
	}
	
	public String capturarMensagemDoAlerta() {
		return capturarTexto(By.id("android:id/message"));
	}
	
	public void clicarEmConfirmar() {
		clicarPorTexto("CONFIRMAR");
	}
	
	public void clicarNaCoordenada() {
		clicarNumaCoordenada(100, 150);
	}
	
	public void clicarEmSair() {
		clicarPorTexto("SAIR");
	}
}

package br.rs.pannuviamonteiro.appium.cttreinamento.pages;

public class AbasPage extends BasePage {

	public void clicarEmAbas() {
		clicarNoTexto("ABAS");
	}

	public boolean verificarSeEstaNaAba1() {
		return verificarSeExisteElementoComOTexto("Este � o conte�do da Aba 1");
	}

	public void clicarEmAba2() {
		clicarNoTexto("ABA 2");
	}

	public boolean verificarSeEstaNaAba2() {
		 return verificarSeExisteElementoComOTexto("Este � o conte�do da Aba 2");
	}
}

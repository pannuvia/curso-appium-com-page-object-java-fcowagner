package br.rs.pannuviamonteiro.appium.cttreinamento.pages;

public class AbasPage extends BasePage {

	public void clicarEmAbas() {
		clicarNoTextoDoElementoPorXpath("ABAS");
	}

	public boolean verificarSeEstaNaAba1() {
		return validarSeExisteElementoPorXpathComOTexto("Este é o conteúdo da Aba 1");
	}

	public void clicarEmAba2() {
		clicarNoTextoDoElementoPorXpath("ABA 2");
	}

	public boolean verificarSeEstaNaAba2() {
		 return validarSeExisteElementoPorXpathComOTexto("Este é o conteúdo da Aba 2");
	}
}

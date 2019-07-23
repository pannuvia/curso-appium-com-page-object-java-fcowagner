package br.rs.pannuviamonteiro.appium.cttreinamento.pages;

public class AccordionPage extends BasePage {

	public void clicarNaOpcao1() {
		clicarNoTextoDoElementoPorXpath("Opção 1");
	}

	public boolean verificarSeEstaNaOpcao1() {
		return validarSeExisteElementoPorXpathComOTexto("Esta é a descrição da opção 1");
	}
	
	public void clicarNaOpcao3() {
		clicarNoTextoDoElementoPorXpath("Opção 3");
	}

	public boolean verificarSeEstaNaOpcao3() {
		return validarSeExisteElementoPorXpathComOTexto(
				"Esta é a descrição da opção 3. Que pode, inclusive ter mais que uma linha");
	}

}

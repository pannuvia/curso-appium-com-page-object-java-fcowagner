package br.rs.pannuviamonteiro.appium.cttreinamento.pages;

public class AccordionPage extends BasePage {

	public void clicarNaOpcao1() {
		clicarNoTexto("Opção 1");
	}

	public boolean verificarSeEstaNaOpcao1() {
		return verificarSeExisteElementoComOTexto("Esta é a descrição da opção 1");
	}
	
	public void clicarNaOpcao3() {
		clicarNoTexto("Opção 3");
	}

	public boolean verificarSeEstaNaOpcao3() {
		return verificarSeExisteElementoComOTexto(
				"Esta é a descrição da opção 3. Que pode, inclusive ter mais que uma linha");
	}

}

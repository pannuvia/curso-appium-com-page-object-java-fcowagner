package br.rs.pannuviamonteiro.appium.cttreinamento.page;

public class AccordionPage extends BasePage {

	public void clicarNaOpcao1() {
		clicarPorTexto("Opção 1");
	}

	public boolean verificarSeEstaNaOpcao1() {
		return verificarSeExisteElementoComOTexto("Esta é a descrição da opção 1");
	}
	
	public void clicarNaOpcao3() {
		clicarPorTexto("Opção 3");
	}

	public boolean verificarSeEstaNaOpcao3() {
		return verificarSeExisteElementoComOTexto(
				"Esta é a descrição da opção 3. Que pode, inclusive ter mais que uma linha");
	}

}

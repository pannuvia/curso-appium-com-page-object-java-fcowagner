package br.rs.pannuviamonteiro.appium.cttreinamento.page;

public class AccordionPage extends BasePage {

	public void clicarNaOpcao1() {
		clicarPorTexto("Op��o 1");
	}

	public boolean verificarSeEstaNaOpcao1() {
		return verificarSeExisteElementoComOTexto("Esta � a descri��o da op��o 1");
	}
	
	public void clicarNaOpcao3() {
		clicarPorTexto("Op��o 3");
	}

	public boolean verificarSeEstaNaOpcao3() {
		return verificarSeExisteElementoComOTexto(
				"Esta � a descri��o da op��o 3. Que pode, inclusive ter mais que uma linha");
	}

}

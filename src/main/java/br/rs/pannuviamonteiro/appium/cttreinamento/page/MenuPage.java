package br.rs.pannuviamonteiro.appium.cttreinamento.page;

import br.rs.pannuviamonteiro.appium.cttreinamento.core.DSL;

public class MenuPage {

	private DSL dsl;	
	
	public MenuPage() {
		this.dsl = new DSL();
	}

	public void acessarFormulario() {
		dsl.clicarPorTexto("Formulário");
	}

}

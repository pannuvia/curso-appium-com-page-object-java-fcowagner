package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.page.FormularioPage;
import br.rs.pannuviamonteiro.appium.cttreinamento.page.MenuPage;

public class FormularioTest extends BaseTest {

	private MenuPage menuPage;
	private FormularioPage formularioPage;

	public FormularioTest() {
		this.menuPage = new MenuPage();
		this.formularioPage = new FormularioPage();
	}

	@Before
	public void setUp() {
		menuPage.acessarFormulario();
	}

	@Test
	public void devePreencherFormulario() {

		formularioPage.preencherNome("Pannuvia");
		formularioPage.selecionarCombo("Nintendo Switch");
		formularioPage.clicarCheckBox();
		formularioPage.clicarSwitch();

		formularioPage.salvar();

		assertEquals("Nome: Pannuvia", formularioPage.capturarNomeCadastrado());
		assertEquals("Console: switch", formularioPage.capturarComboCadastrado());
		assertTrue(formularioPage.capturarCheckBoxCadastrado().endsWith("Marcado"));
		assertTrue(formularioPage.capturarSwitchCadastrado().endsWith("Off"));
	}

}

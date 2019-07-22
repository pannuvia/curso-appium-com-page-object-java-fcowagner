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
		this.menuPage.acessarFormulario();
	}

	@Test
	public void devePreencherFormulario() {

		//preencher o nome
		this.formularioPage.preencherNome("Pannuvia");
		
		//selecionar o valor do combo
		this.formularioPage.selecionarCombo("Nintendo Switch");
		
		//clicar no checkbox
		this.formularioPage.clicarNoCheckbox();
		
		//clicar no switch
		this.formularioPage.clicarNoSwitch();
		
		//clicar no datapicker
		this.formularioPage.clicarNoDataPicker("01/01/2000");
		
		//selecionar dia
		this.formularioPage.clicarPorTexto("20");
		
		//clicar em OK
		this.formularioPage.clicarPorTexto("OK");
		
		//clicar em salvar
		this.formularioPage.clicarEmSalvar();

		//validar os valores 
		assertEquals("Nome: Pannuvia", this.formularioPage.capturarNomeCadastrado());
		assertEquals("Console: switch", this.formularioPage.capturarComboCadastrado());
		assertTrue(this.formularioPage.capturarCheckboxCadastrado().endsWith("Marcado"));
		assertTrue(this.formularioPage.capturarSwitchCadastrado().endsWith("Off"));
		assertEquals("20/2/2000", this.formularioPage.capturarDataCadastrada());
	}

}

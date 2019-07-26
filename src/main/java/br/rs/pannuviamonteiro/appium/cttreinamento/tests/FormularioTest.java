package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.FormularioPage;

public class FormularioTest extends BaseTest {

	private FormularioPage formularioPage;

	public FormularioTest() {
		this.formularioPage = new FormularioPage();
	}

	@Test
	public void devePreencherFormulario() {

		// acessar menu Formulário
		clicarNoElementoPorXPathComTexto("Formulário");

		// preencher nome
		this.formularioPage.campoNome().sendKeys("Pannuvia");

		// clicar no combo
		this.formularioPage.campoCombo().click();

		// selecionar a opção desejada no combo
		clicarNoElementoPorXPathComTexto("Nintendo Switch");

		// clicar no seekbar
		this.formularioPage.campoSeekBar(0.65).click();

		// clicar no checkbox
		this.formularioPage.campoCheckbox().click();

		// clicar no switch
		this.formularioPage.campoSwitch().click();

		devePreencherData();

		devePreencherHorario();

		// clicar em salvar
		this.formularioPage.botaoSalvar().click();

		// validar nome preenchido
		assertEquals("Nome: Pannuvia", this.formularioPage.nomeAposSalvar().getText());

		// validar valor do combo
		assertEquals("Console: switch", this.formularioPage.comboAposSalvar().getText());

		// validar valor do seekbar
		assertEquals("Slider: 51", this.formularioPage.seekBarAposSalvar().getText());

		// validar se checkbox está marcado
		assertTrue(this.formularioPage.checkboxAposSalvar().getText().endsWith("Marcado"));
		
		// validar se switch foi desligado
		assertTrue(this.formularioPage.switchAposSalvar().getText().endsWith("Off"));

		// validar data preenchida
		validarSeExisteElementoPorXpathComOTexto("20/2/2000");

		// validar horario preenchido
		validarSeExisteElementoPorXpathComOTexto("16:35");
	}

	private void devePreencherHorario() {

		// clicar no timepicker
		this.formularioPage.campoTimePicker("06:00").click();

		// selecionar hora
		this.formularioPage.campoHora("16").click();

		// selecionar minutos
		this.formularioPage.campoMinutos("35").click();

		// clicar em OK
		clicarNoElementoPorXPathComTexto("OK");
	}

	private void devePreencherData() {

		// clicar no datapicker
		this.formularioPage.campoDataPicker("01/01/2000").click();

		// selecionar dia
		clicarNoElementoPorXPathComTexto("20");

		// clicar em OK
		clicarNoElementoPorXPathComTexto("OK");
	}

}

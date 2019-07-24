package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;
import br.rs.pannuviamonteiro.appium.cttreinamento.pages.FormularioPage;

public class FormularioTest extends BaseTest {

	private BasePage basePage;
	private FormularioPage formularioPage;


	public FormularioTest() {
		this.basePage = new BasePage();
		this.formularioPage = new FormularioPage();
	}

	@Test
	public void devePreencherFormulario() {

		//acessar menu Formulário
		this.basePage.clicarNoTextoDoElementoPorXpath("Formulário");
		
		//preencher nome
		this.formularioPage.preencherTextFieldNome("Pannuvia");

		//selecionar o valor do combo
		this.formularioPage.selecionarValorNoCombo("Nintendo Switch");

		//clicar no seekbar
		this.formularioPage.clicarNoSeekBar(0.65);
		
		//clicar no checkbox
		this.formularioPage.clicarNoCheckbox();

		//clicar no switch
		this.formularioPage.clicarNoSwitch();
		
		devePreencherData();
		
		devePreencherHorario();
					
		//clicar em salvar
		this.formularioPage.clicarEmSalvar();
		
		//validar nome preenchido
		assertEquals("Nome: Pannuvia", this.formularioPage.capturarNomeAposSalvar());
		
		//validar valor do combo
		assertEquals("Console: switch", this.formularioPage.capturarComboAposSalvar());
		
		//validar valor do seekbar
<<<<<<< HEAD
		assertEquals("Slider: 67", this.formularioPage.capturarSeekBarAposSalvar());
=======
		assertEquals("Slider: 65", this.formularioPage.capturarSeekBarAposSalvar());
>>>>>>> develop
				
		//validar se checkbox está marcado
		assertTrue(this.formularioPage.capturarCheckboxAposSalvar().endsWith("Marcado"));
		
		//validar se switch foi desligado
		assertTrue(this.formularioPage.capturarSwitchAposSalvar().endsWith("Off"));
			
		//validar data preenchida
		assertTrue(this.formularioPage.validarSeExisteElementoPorXpathComOTexto("20/2/2000"));
		
      	//validar horario preenchido
    	assertTrue(this.formularioPage.validarSeExisteElementoPorXpathComOTexto("16:35"));
	}
	
	private void devePreencherHorario() {
		
		//clicar no timepicker
		this.formularioPage.clicarNoTimePicker("06:00");
		
		//selecionar hora
		this.formularioPage.clicarNaHora("16");
				
		//selecionar minutos
		this.formularioPage.clicarNosMinutos("35");
		
		//clicar em OK
		this.formularioPage.clicarNoTextoDoElementoPorXpath("OK");
	}

	private void devePreencherData() {
		
		//clicar no datapicker
		this.formularioPage.clicarNoDataPicker("01/01/2000");
		
		//selecionar dia
		this.formularioPage.clicarNoTextoDoElementoPorXpath("20");
		
		//clicar em OK
		this.formularioPage.clicarNoTextoDoElementoPorXpath("OK");
	}		
	
}
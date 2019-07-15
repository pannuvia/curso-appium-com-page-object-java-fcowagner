package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.rs.pannuviamonteiro.appium.cttreinamento.core.DSL;
import br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class FormularioTest {

	private DSL dsl = new DSL();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		// clicar em Formulário
		dsl.clicarPorTexto("Formulário");
	}
	
	@Test
	public void preencherFormulario() throws MalformedURLException {
		
		//preencher textfield
		dsl.preencherTextField(MobileBy.AccessibilityId("nome") , "Pannuvia");

		// clicar na combo
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
				
		//verificar status do checkbox
		assertFalse(dsl.isMarcado(By.className("android.widget.CheckBox")));
		
		// clicar no checkBox
		dsl.clicar(By.className("android.widget.CheckBox"));
		
		// verificar status do switch
		assertTrue(dsl.isMarcado(MobileBy.AccessibilityId("switch")));
		
		// clicar no switch
		dsl.clicar(MobileBy.AccessibilityId("switch"));

		// salvar
		dsl.clicarPorTexto("SALVAR");
		
		// validar textfield
		assertEquals("Pannuvia", dsl.obterTexto(MobileBy.AccessibilityId("nome")));

		// validar combo
		String combo = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		assertEquals("Nintendo Switch", combo);
		
		// validar status checkbox alterado
		assertTrue(dsl.isMarcado(By.className("android.widget.CheckBox")));
		
		// validar status switch alterado
		assertFalse(dsl.isMarcado(MobileBy.AccessibilityId("switch")));
	}

	@After
	public void fecharDriver() {
		DriverFactory.destroyDriver();
	}

}

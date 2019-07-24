package br.rs.pannuviamonteiro.appium.cttreinamento.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.rs.pannuviamonteiro.appium.cttreinamento.tests.AbasTest;
import br.rs.pannuviamonteiro.appium.cttreinamento.tests.AccordionTest;
import br.rs.pannuviamonteiro.appium.cttreinamento.tests.AlertasTest;
import br.rs.pannuviamonteiro.appium.cttreinamento.tests.CliquesTest;
import br.rs.pannuviamonteiro.appium.cttreinamento.tests.DragAndDropTest;
import br.rs.pannuviamonteiro.appium.cttreinamento.tests.FormularioTest;
import br.rs.pannuviamonteiro.appium.cttreinamento.tests.ScrollTest;
import br.rs.pannuviamonteiro.appium.cttreinamento.tests.SplashTest;
import br.rs.pannuviamonteiro.appium.cttreinamento.tests.SwipeListTest;
import br.rs.pannuviamonteiro.appium.cttreinamento.tests.SwipeTest;

@RunWith(Suite.class)
@SuiteClasses({ 
	AbasTest.class,
	AccordionTest.class,
	AlertasTest.class,
	CliquesTest.class,
	DragAndDropTest.class,
	FormularioTest.class,
	ScrollTest.class,
	SplashTest.class,
	SwipeTest.class,
	SwipeListTest.class

})
public class RegressionTestSuite {

	@BeforeClass
	public static void setUp() {
		System.out.println("Iniciando execução");
	}

	@AfterClass
	public static void tearDown() {
		System.out.println("Finalizando execução");
	}

}
package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;
import br.rs.pannuviamonteiro.appium.cttreinamento.pages.DragAndDropPage;

public class DragAndDropTest extends BaseTest {

	private BasePage basePage;
	private DragAndDropPage dragAndDropPage;
	
	public DragAndDropTest() {
		this.basePage = new BasePage();
		this.dragAndDropPage = new DragAndDropPage();
	}
	
	private String[] arrayInicial = new String[] {"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo," , "e arraste para", "qualquer local desejado."};
	private String[] arrayIntermediario= new String[] {"é uma lista", "Drag em Drop!", "Faça um clique longo," , "e arraste para", "Esta", "qualquer local desejado."};
	private String[] arrayFinal = new String[] { "Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};
	
	@Test
	public void deveRealizarDragAndDrop() throws InterruptedException {
		
		//realizar scrool up para acessar o menu Drag and drop
		this.basePage.realizarScrollUpPelaJanela(0.9, 0.1);
		
		//clicar no  menu Drag and drop
		this.basePage.clicarNoTextoDoElementoPorXpath("Drag and drop");
		
		//verificar estado inicial dos textos 
		Thread.sleep(2000);
		assertArrayEquals(arrayInicial, this.dragAndDropPage.capturarValoresDaLista());
		
		//clicar e arrastar o texto "Esta" e soltar no lugar do texto "e arraste para"
		this.dragAndDropPage.arrastarOrigemDestino("Esta", "e arraste para");
		
		//verificar estado intermediario dos textos
		assertArrayEquals(arrayIntermediario, this.dragAndDropPage.capturarValoresDaLista());
		
		//clicar e arrastar o texto "Faça um clique longo," e soltar no lugar do texto "é uma lista"
		this.dragAndDropPage.arrastarOrigemDestino("Faça um clique longo,", "é uma lista");
		
		//verificar estado final dos textos
		assertArrayEquals(arrayFinal, this.dragAndDropPage.capturarValoresDaLista());
	}
}

package br.rs.pannuviamonteiro.appium.cttreinamento.tests;

import static br.rs.pannuviamonteiro.appium.cttreinamento.core.DriverFactory.getDriver;
import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;

import br.rs.pannuviamonteiro.appium.cttreinamento.pages.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class DragAndDropTest extends BaseTest {

	private BasePage basePage;
	
	public DragAndDropTest() {
		this.basePage = new BasePage();
	}
	
	private String[] arrayInicial = new String[] {"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo," , "e arraste para", "qualquer local desejado."};
	private String[] arrayIntermediario= new String[] {"é uma lista", "Drag em Drop!", "Faça um clique longo," , "e arraste para", "Esta", "qualquer local desejado."};
	private String[] arrayFinal = new String[] { "Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};
	
	@Test
	public void deveRealizarDragAndDrop() throws InterruptedException {
		
		//realizar scrool up para acessar o menu Drag and drop
		this.basePage.realizarScrollUpPelaJanela(0.9, 0.1);
		
		//clicar no  menu Drag and drop
		clicarNoElementoPorXPathComTexto("Drag and drop");
		
		//verificar estado inicial dos textos 
		Thread.sleep(2000);
		assertArrayEquals(arrayInicial, capturarValoresDaLista());
		
		//clicar e arrastar o texto "Esta" e soltar no lugar do texto "e arraste para"
		arrastarOrigemDestino("Esta", "e arraste para");
		
		//verificar estado intermediario dos textos
		assertArrayEquals(arrayIntermediario, capturarValoresDaLista());
		
		//clicar e arrastar o texto "Faça um clique longo," e soltar no lugar do texto "é uma lista"
		arrastarOrigemDestino("Faça um clique longo,", "é uma lista");
		
		//verificar estado final dos textos
		assertArrayEquals(arrayFinal, capturarValoresDaLista());
	}
	
	
	public String[] capturarValoresDaLista() {
		List<MobileElement> elementosDaTela = getDriver().findElements(By.className("android.widget.TextView"));
		String[] array = new String[elementosDaTela.size()];
		for(int i = 0; i < elementosDaTela.size(); i++ ) {
			array[i] = elementosDaTela.get(i).getText();
			//System.out.println("\"" + array[i] + "\", ");
		}
		return array;
	}
	
	public void arrastarOrigemDestino (String origem, String destino) {
		MobileElement inicio = getDriver().findElement(By.xpath("//*[@text='"+ origem +"']"));
		MobileElement fim = getDriver().findElement(By.xpath("//*[@text='"+ destino +"']"));
		
		new TouchAction(getDriver())
			.longPress(inicio)
			.moveTo(fim)
			.release()
			.perform();	
	}
}

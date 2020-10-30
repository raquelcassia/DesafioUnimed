package testspages;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import sun.net.www.content.audio.x_aiff;
import unimedpages.PageAcessandoGuiaMedico;
import unimedpages.PageBuscaRapida;
import utils.WebDriverUtils;

public class Testes {
	
	private static PageAcessandoGuiaMedico pageAcessandoGuiaMedico;
	private static PageBuscaRapida pageBuscaRapida;
	
	@Before
	public void precondicao() {
		WebDriverUtils.Iniciar();
		
		pageAcessandoGuiaMedico = new PageAcessandoGuiaMedico();
		
		pageBuscaRapida = new PageBuscaRapida();
		
	}
	
	@Test
	public void testeCidadeEspecialidade() throws Throwable{
		String DadoCampoPesquisa = "Cardiologia";
		String DadoCidade = "Rio de Janeiro";
		
		
		pageAcessandoGuiaMedico.botaoGuiaMedico();
		Thread.sleep(1000);
		pageBuscaRapida.campoPesquisa(DadoCampoPesquisa);
		Thread.sleep(1000);
		pageBuscaRapida.botaoPesquisar();
		Thread.sleep(1000);
		pageBuscaRapida.campoEstado();
		Thread.sleep(1000);
		pageBuscaRapida.campoCidade();
		Thread.sleep(1000);
		pageBuscaRapida.selecionarRadionButton();
		Thread.sleep(1000);
		pageBuscaRapida.botaoContinuar();
		Thread.sleep(2000);
		
		
		
		List<WebElement> especialidades = WebDriverUtils.driver.findElements(By.className("DadosPrestador"));
		for (int i = 0; i < especialidades.size(); i++) {
			WebElement x = especialidades.get(i);
			//System.out.println(x.getText());
			
			Assert.assertThat(x.getText(), CoreMatchers.containsString("Rio de Janeiro"));

		}
		
		
		
		
		//Assert.assertEquals(DadoCampoPesquisa, pageBuscaRapida.obterEspecialidade());

	}
	
	
	


	@After
	public void finish() throws Throwable {
		WebDriverUtils.QuitChrome();
	}
	
	


}

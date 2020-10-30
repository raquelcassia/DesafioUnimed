package testspages;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import unimedpages.PageAcessandoGuiaMedico;
import unimedpages.PageBuscaRapida;
import utils.WebDriverUtils;

public class Testes {
	
	private static PageAcessandoGuiaMedico pageAcessandoGuiaMedico;
	private static PageBuscaRapida pageBuscaRapida;
	private static WebDriver drive;
	private static Actions action;
	
	
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
		
		Assert.assertEquals(DadoCampoPesquisa, pageBuscaRapida.obterEspecialidade());
		Assert.assertThat(DadoCidade, CoreMatchers.containsString("Rio de Janeiro"));

	}
	
	
	


	@After
	public void finish() throws Throwable {
		WebDriverUtils.QuitChrome();
	}
	
	


}

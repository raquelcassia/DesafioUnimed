package testspages;

import org.junit.After;
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
		String DadoInseridoCampoPesquisa = "cardiologista";
		String DadoInseridoCampoEstado = "Rio de Janeiro";
		
		pageAcessandoGuiaMedico.botaoGuiaMedico();
		Thread.sleep(2000);
		
		pageBuscaRapida.campoPesquisa(DadoInseridoCampoPesquisa);
		Thread.sleep(8000);
		pageBuscaRapida.botaoPesquisar();
		Thread.sleep(2000);

		pageBuscaRapida.campoEstado(DadoInseridoCampoEstado);
		Thread.sleep(6000);

	}
	
	
	
	
	
	@After
	public void finish() throws Throwable {
		WebDriverUtils.QuitChrome();
	}
	
	


}

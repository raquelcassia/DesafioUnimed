package testspages;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

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
	public void testeCidadeEspecialidade() throws Throwable {
		String DadoCampoPesquisa = "Cardiologia";

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

		List<WebElement> resultadoBusca = WebDriverUtils.driver.findElements(By.className("DadosPrestador"));
		for (int i = 0; i < resultadoBusca.size(); i++) {
			WebElement x = resultadoBusca.get(i);

			Assert.assertThat(x.getText(), containsString("- Rio de Janeiro / RJ -")); //
			Assert.assertThat(x.getText(), containsString("Especialidade(s): Cardiologia"));
		}
	}

	@Test

	public void testeNotSP_SetaPg() throws Throwable {
		String DadoCampoPesquisa = "Otorrinolaringologia";

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

		List<WebElement> resultadoBusca;
		for (int p = 1; p <= 3; p++) {

			resultadoBusca = WebDriverUtils.driver.findElements(By.className("DadosPrestador"));
			for (int i = 0; i < resultadoBusca.size(); i++) {
				WebElement x = resultadoBusca.get(i);

				Assert.assertThat(x.getText(), not(containsString("- São Paulo / SP -")));
			}

			Thread.sleep(1000);
			pageBuscaRapida.botaoSetaProximo();
		}
	}

	@Test

	public void testeNotSP_NumPg() throws Throwable {
		String DadoCampoPesquisa = "Otorrinolaringologia";

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

		List<WebElement> resultadoBusca;
		for (int p = 1; p <= 3; p++) {

			resultadoBusca = WebDriverUtils.driver.findElements(By.className("DadosPrestador"));
			for (int i = 0; i < resultadoBusca.size(); i++) {
				WebElement x = resultadoBusca.get(i);

				Assert.assertThat(x.getText(), not(containsString("- São Paulo / SP -")));
			}

			Thread.sleep(2000);
			WebDriverUtils.scrollView();
			Thread.sleep(2000);
			pageBuscaRapida.numPag(p);
			Thread.sleep(1000);
		}
	}

	@After
	public void finish() throws Throwable {
		WebDriverUtils.QuitChrome();
	}

}

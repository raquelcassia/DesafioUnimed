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
		String DadoCampoPesquisa = "Dermatologia";

		pageAcessandoGuiaMedico.botaoGuiaMedico();
		pageBuscaRapida.campoPesquisa(DadoCampoPesquisa);
		pageBuscaRapida.botaoPesquisar();
		pageBuscaRapida.campoEstado();
		pageBuscaRapida.campoCidade();
		pageBuscaRapida.selecionarRadionButton();
		pageBuscaRapida.botaoContinuar();

		List<WebElement> resultadoBusca = WebDriverUtils.driver.findElements(By.className("DadosPrestador"));
		for (int i = 0; i < resultadoBusca.size(); i++) {
			WebElement x = resultadoBusca.get(i);

			Assert.assertThat(x.getText(), containsString("- Rio de Janeiro / RJ -")); //
			Assert.assertThat(x.getText(), containsString("Especialidade(s): Dermatologia"));
		}
	}

	@Test
	public void testeCidadeEspecialidadeError() throws Throwable {
		String DadoCampoPesquisa = "Angiologia";

		pageAcessandoGuiaMedico.botaoGuiaMedico();
		pageBuscaRapida.campoPesquisa(DadoCampoPesquisa);
		pageBuscaRapida.botaoPesquisar();
		pageBuscaRapida.campoEstado();
		pageBuscaRapida.campoCidade();
		pageBuscaRapida.selecionarRadionButton();
		pageBuscaRapida.botaoContinuar();

		List<WebElement> resultadoBusca = WebDriverUtils.driver.findElements(By.className("DadosPrestador"));
		for (int i = 0; i < resultadoBusca.size(); i++) {
			WebElement x = resultadoBusca.get(i);

			Assert.assertThat(x.getText(), containsString("- Rio de Janeiro / RJ -")); //
			Assert.assertThat(x.getText(), containsString("Especialidade(s): Angiologia"));
		}
	}

	@Test

	public void testeNotSP_SetaPg() throws Throwable {
		String DadoCampoPesquisa = "Otorrinolaringologia";

		pageAcessandoGuiaMedico.botaoGuiaMedico();
		pageBuscaRapida.campoPesquisa(DadoCampoPesquisa);
		pageBuscaRapida.botaoPesquisar();
		pageBuscaRapida.campoEstado();
		pageBuscaRapida.campoCidade();
		pageBuscaRapida.selecionarRadionButton();
		pageBuscaRapida.botaoContinuar();

		List<WebElement> resultadoBusca;
		for (int p = 1; p <= 3; p++) {

			resultadoBusca = WebDriverUtils.driver.findElements(By.className("DadosPrestador"));
			for (int i = 0; i < resultadoBusca.size(); i++) {
				WebElement x = resultadoBusca.get(i);

				Assert.assertThat(x.getText(), not(containsString("- São Paulo / SP -")));
			}

			pageBuscaRapida.botaoSetaProximo();
		}
	}

	@Test

	public void testeNotSP_NumPg() throws Throwable {
		String DadoCampoPesquisa = "Otorrinolaringologia";

		pageAcessandoGuiaMedico.botaoGuiaMedico();
		pageBuscaRapida.campoPesquisa(DadoCampoPesquisa);
		pageBuscaRapida.botaoPesquisar();
		pageBuscaRapida.campoEstado();
		pageBuscaRapida.campoCidade();
		pageBuscaRapida.selecionarRadionButton();
		pageBuscaRapida.botaoContinuar();

		List<WebElement> resultadoBusca;
		for (int p = 1; p <= 3; p++) {

			resultadoBusca = WebDriverUtils.driver.findElements(By.className("DadosPrestador"));
			for (int i = 0; i < resultadoBusca.size(); i++) {
				WebElement x = resultadoBusca.get(i);

				Assert.assertThat(x.getText(), not(containsString("- São Paulo / SP -")));
			}

			WebDriverUtils.scrollView();
			pageBuscaRapida.numPag(p);
		}
	}

	@After
	public void finish() throws Throwable {
		WebDriverUtils.QuitChrome();
	}

}

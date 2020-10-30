package unimedpages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import utils.WebDriverUtils;

public class PageBuscaRapida {
	
	public PageBuscaRapida() {
	}
	
	public void campoPesquisa(String palavraChave) {
		WebDriverUtils.driver.findElement(By.id("campo_pesquisa")).sendKeys(palavraChave);
	}
	
	public void botaoPesquisar(){
		WebDriverUtils.driver.findElement(By.id("btn_pesquisar")).click();
	}
	
	public void selecionarCampoEstado() {
		WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/form/div/div[1]/div/div/div[2]/div/svg")).click();
	}
	
	public void selecionarEstado(String estado) {
		WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/form/div/div[1]/div/div/div[1]/div[1]")).click();
	}
	
	public void limparCampo() {
		WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/form/div/div[1]/div/div/div[2]/div[1]/svg")).click();
	}
	
	public void campoEstado(String estado) {
		limparCampo();
		selecionarCampoEstado();
		selecionarEstado(estado);
	}

}

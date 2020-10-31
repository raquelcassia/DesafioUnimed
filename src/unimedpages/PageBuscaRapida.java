package unimedpages;

import org.openqa.selenium.By;
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
		WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/form/div/div[1]/div/div/div[1]")).click();
	}                                           
	
	public void selecionarEstado() {
		WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/form/div/div[1]/div/div[2]/div/div[19]")).click();
	}
	
	public void campoEstado() throws Throwable {
		selecionarCampoEstado();
		Thread.sleep(1000);
		selecionarEstado();
	}
	
	public void selecionarCampoCidade() {
		WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/form/div/div[2]/div[1]/div/div[1]")).click();
	}
	
	public void selecionarCidade() {
		WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/form/div/div[2]/div/div[2]/div/div[68]")).click();
	}      
	
	public void campoCidade() throws Throwable {
		selecionarCampoCidade();
		Thread.sleep(1000);
		selecionarCidade();
	}
	
	public void selecionarRadionButton() {
		WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div[2]/form/label/div[1]/input")).click();
	}
	
	public void botaoContinuar() {
		WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div[3]/button[2]")).click();
	}
	
	public String obterEspecialidade() {
		String text = WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div[8]/div[1]/div[6]/div/div[2]/div[1]/p[2]/span[2]")).getText();
		return text;
	}
	
	public String obterCidade() {
		String text = WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div[8]/div[1]/div[1]/div/div[2]/div[1]/span/p[2]")).getText();
		return text;
	}
	
	public void botaoSetaProximo() {
		WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div[8]/div[2]/div/ul/li[13]/a/i")).click();
	}


}

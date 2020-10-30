package unimedpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebDriverUtils;

public class PageAcessandoGuiaMedico {

	public PageAcessandoGuiaMedico() {
	}
	
	public PageAcessandoGuiaMedico(WebDriver driver) {
		WebDriverUtils.driver = driver;
	}
	
	public void botaoGuiaMedico() {
		WebDriverUtils.driver.findElement(By.xpath("/html/body/div[6]/header/nav/div/div[2]/ul/li[2]/a")).click();
	}
	
	
	
}

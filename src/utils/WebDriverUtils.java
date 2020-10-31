package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import unimedpages.PageBuscaRapida;

public class WebDriverUtils {

	private static WebDriverUtils webdriverutils = new WebDriverUtils();
	public static WebDriver driver;
	public static Actions action;
	public static PageBuscaRapida pageBuscaRapida = new PageBuscaRapida();

	public static ChromeOptions options = new ChromeOptions();

	public void WebDriverUtils() {
	}

	public static WebDriverUtils getInstance() {
		return webdriverutils;
	}

	public static void IniciandoChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

		options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("start-maximized");
		options.addArguments("--disable-geolocation");

		driver = new ChromeDriver(options);
		action = new Actions(WebDriverUtils.driver);

	}

	public static void IniciandoDriver() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.unimed.coop.br/");
	}

	public static void Iniciar() {
		IniciandoChrome();
		IniciandoDriver();
	}

	public static void QuitChrome() {
		driver.quit();
	}

	public static void scrollView() {
		WebElement element = pageBuscaRapida.botoesPag();
		((JavascriptExecutor) WebDriverUtils.driver).executeScript("arguments[0].scrollIntoView(true);", element);

	}

}

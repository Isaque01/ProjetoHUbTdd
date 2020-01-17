package br.com.rsinet.hub_tdd.Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IniciarDriver {

	static WebDriver driver;

	private IniciarDriver() {
	}

	public static WebDriver inicializarDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.advantageonlineshopping.com/#/");
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void esperaImagem() {
	
    WebDriverWait wait = new WebDriverWait(driver, 30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/section/article/div[3]/footer/div/div/a[2]/img")));
   
}

	
	
	public static void fecharDriver(WebDriver driver) {
		if (driver != null)
			driver.quit();
	}
}

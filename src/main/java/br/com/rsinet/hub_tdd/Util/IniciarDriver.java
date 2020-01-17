package br.com.rsinet.hub_tdd.Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

	public static void fecharDriver(WebDriver driver) {
		if (driver != null)
			driver.quit();
	}
}

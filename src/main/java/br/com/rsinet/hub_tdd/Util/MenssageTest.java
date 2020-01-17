package br.com.rsinet.hub_tdd.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenssageTest {
	static WebDriver driver;
	private static WebElement element;

	public static WebElement registeredUsere(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"registerPage\"]/article/sec-form/div[2]/label[1]"));
		return element;
	}

	public static WebElement productNotFound(WebDriver driver) {
		element = driver.findElement(By.id("searchResultLabel"));
		return element;
	}
}

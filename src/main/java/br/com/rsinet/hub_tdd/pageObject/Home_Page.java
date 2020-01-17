package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_Page {

	private static WebElement element = null;

	public static WebElement btn_Login(WebDriver driver) {
		element = driver.findElement(By.id("menuUserLink"));
		return element;
	}

	public static WebElement btn_CreateNewUser(WebDriver driver) {
		element = driver.findElement(By.linkText("CREATE NEW ACCOUNT"));
		return element;
	}

	public static WebElement img_Speaker(WebDriver driver) {
		element = driver.findElement(By.id("speakersImg"));
		return element;
	}
	
}

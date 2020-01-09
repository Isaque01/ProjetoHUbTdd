package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page {

	private static WebElement element;

	public static WebElement txtbox_User(WebDriver driver) {
		element = driver.findElement(By.name("username"));
		return element;
	}

	public static WebElement txtbox_Password(WebDriver driver) {
		element = driver.findElement(By.name("password"));
		return element;
	}

	public static WebElement btn_Sign(WebDriver driver) {
		element = driver.findElement(By.id("sign_in_btnundefined"));
		return element;
	}

	public static WebElement btn_Create(WebDriver driver) {
		element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		return element;
	}

}

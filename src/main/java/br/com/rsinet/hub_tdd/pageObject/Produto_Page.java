package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Produto_Page {

	public static WebElement element;
	
	public static WebDriver driver;

	public static WebElement lupa(WebDriver driver) {
		element = driver.findElement(By.id("menuSearch"));
		return element;
	}

	public static WebElement AutoComplete(WebDriver driver) {
		element = driver.findElement(By.id("autoComplete"));
		return element;
	}

	public static WebElement Selecionar(WebDriver driver, String laptop) {
		element = driver.findElement(By.id(laptop));
		return element;

	}
	
	public static WebElement Erro(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span"));
		return element;
	}
	
//	public static void esperaImagem() {
//		
//	   
//		WebDriverWait wait = new WebDriverWait(driver, 4);
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"searchPage\"]/div[3]/div/label/span")));
//	   
//	}

	// Pesquisar Produto por Categoria na tela de inicio 

	public static WebElement Pesquisar(WebDriver driver, String categoria) {
		element = driver.findElement(By.id(categoria));
		return element;
	}

	public static WebElement Produto(WebDriver driver, String produto) {
		element = driver.findElement(By.id(produto));
		return element;

	}

}


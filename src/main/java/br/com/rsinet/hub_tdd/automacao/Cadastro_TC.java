package br.com.rsinet.hub_tdd.automacao;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.appModules.Register_Action;

public class Cadastro_TC {
	private static ChromeDriver driver;
	
	@BeforeClass
	public static void iniciarNavegador() {
		
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();

	}
	
	@Test
	public void cadastroValido() {
		
		driver.get("http://advantageonlineshopping.com");
		Register_Action.Execute(driver);
		
	}
	
	@AfterClass
	public static void fecharNavegador(){
	
		driver.quit();
	}
}

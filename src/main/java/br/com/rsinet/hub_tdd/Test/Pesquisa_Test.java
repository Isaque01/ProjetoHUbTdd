package br.com.rsinet.hub_tdd.Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.Excel.Constant;
import br.com.rsinet.hub_tdd.Excel.ExcelUtilsTest;
import br.com.rsinet.hub_tdd.Print.Screenshot;
import br.com.rsinet.hub_tdd.pageObject.Pesquisa_Categoria;

public class Pesquisa_Test {

	static WebDriver driver;
	
	@Test
	public void PesquisaProdutoCategoria() throws Exception {
		
		driver = new ChromeDriver();
		driver.get("http://advantageonlineshopping.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		Pesquisa_Categoria.Pesquisar(driver).click();
		Pesquisa_Categoria.Produto(driver).click();
		
		ExcelUtilsTest.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha3");
		
		Pesquisa_Categoria.Pesquisar(driver).sendKeys(ExcelUtilsTest.getCellData(1, 0));
		
	
		
		Pesquisa_Categoria.Produto(driver).sendKeys(ExcelUtilsTest.getCellData(2, 0));
		
	
	}
	
	@After
	public void finaliza_teste() throws Exception {
		Thread.sleep(4000);
		
		
		Screenshot.printTela(driver);
		
		driver.quit();
	}
}

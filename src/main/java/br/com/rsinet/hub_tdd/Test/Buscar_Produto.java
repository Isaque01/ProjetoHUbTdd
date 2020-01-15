package br.com.rsinet.hub_tdd.Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.rsinet.hub_tdd.Excel.Constant;
import br.com.rsinet.hub_tdd.Excel.ExcelUtilsTest;
import br.com.rsinet.hub_tdd.Print.Screenshot;
import br.com.rsinet.hub_tdd.pageObject.Search_Products;

public class Buscar_Produto {

	static WebDriver driver;

	@Test

	public void BuscarProduto() throws Exception {
		driver = new ChromeDriver();
		
		driver.get("http://advantageonlineshopping.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		

		ExcelUtilsTest.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");

		Search_Products.AutoComplete(driver).sendKeys(ExcelUtilsTest.getCellData(1, 0) + Keys.ENTER);
		
		Search_Products.LaptopHp(driver).click();
		

	}

	@After
	public void finaliza_teste() throws Exception {
		Thread.sleep(4000);
		
		
		Screenshot.printTela(driver);
		
		//driver.quit();
	}

	
}
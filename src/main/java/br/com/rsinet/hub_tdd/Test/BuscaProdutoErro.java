package br.com.rsinet.hub_tdd.Test;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.Util.Constant;
import br.com.rsinet.hub_tdd.Util.ExcelUtilsTest;
import br.com.rsinet.hub_tdd.Util.Generator;
import br.com.rsinet.hub_tdd.Util.IniciarDriver;
import br.com.rsinet.hub_tdd.Util.Screenshot;
import br.com.rsinet.hub_tdd.pageObject.Produto_Page;

public class BuscaProdutoErro {

	static WebDriver driver;
	static WebDriverWait wait;

	@Test

	public void ProdutoErro() throws Exception {
		driver = IniciarDriver.inicializarDriver();

		ExcelUtilsTest.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");

		Produto_Page.AutoComplete(driver).sendKeys(ExcelUtilsTest.getCellData(4, 0) + Keys.ENTER);

		assertEquals(Produto_Page.Erro(driver).getText().contains(ExcelUtilsTest.getCellData(4, 0)), true);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("virtualFooter")));
		assertTrue(driver.getPageSource().contains("No results for"));

		Screenshot.printTela(driver, Generator.dataHorParaArquvio());

	}

	@AfterMethod
	public void finaliza_teste() throws Exception {

		IniciarDriver.fecharDriver(driver);
	}
}

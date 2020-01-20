package br.com.rsinet.hub_tdd.Test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.Util.Constant;
import br.com.rsinet.hub_tdd.Util.ExcelUtilsTest;
import br.com.rsinet.hub_tdd.Util.Generator;
import br.com.rsinet.hub_tdd.Util.IniciarDriver;
import br.com.rsinet.hub_tdd.Util.Screenshot;
import br.com.rsinet.hub_tdd.pageObject.Produto_Page;

public class Produto_CategoriaErro {

	static WebDriver driver;

	@Test
	public void PesquisaProdutoCategoria() throws Exception {

		driver = IniciarDriver.inicializarDriver();

		ExcelUtilsTest.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha3");

		Produto_Page.Pesquisar(driver, ExcelUtilsTest.getCellData(1, 0)).click();

		Produto_Page.Produto(driver, ExcelUtilsTest.getCellData(2, 0)).click();

		Produto_Page.Quantidade(driver).sendKeys("1");

		Produto_Page.Comprar(driver).click();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Vertical scroll - down by 150 pixels
		js.executeScript("window.scrollBy(0,150)");

		Screenshot.printTela(driver, Generator.dataHorParaArquvio());

	}

	@AfterMethod
	public void finaliza_teste() throws Exception {

		 //IniciarDriver.fecharDriver(driver);
	}
}

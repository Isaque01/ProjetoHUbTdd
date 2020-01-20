package br.com.rsinet.hub_tdd.Test;

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

public class BuscaProdutoSucesso {

	static WebDriver driver;

	@Test

	public void ProdutoSucesso() throws Exception {
		driver = IniciarDriver.inicializarDriver();

		ExcelUtilsTest.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha2");

		Produto_Page.AutoComplete(driver).sendKeys(ExcelUtilsTest.getCellData(1, 0) + Keys.ENTER);

		Produto_Page.Selecionar(driver, ExcelUtilsTest.getCellData(2, 0)).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"mainImg\"]")));

		Screenshot.printTela(driver, Generator.dataHorParaArquvio());

	}

	@AfterMethod
	public void finaliza_teste() throws Exception {

		IniciarDriver.fecharDriver(driver);
	}

}

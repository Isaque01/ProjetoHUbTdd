package br.com.rsinet.hub_tdd.Test;

import org.openqa.selenium.By;
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

public class Produto_CategoriaSucessoTest {

	static WebDriver driver;

	@Test
	public void PesquisaProdutoCategoria() throws Exception {

		driver = IniciarDriver.inicializarDriver();

		ExcelUtilsTest.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha3");

		Produto_Page.Pesquisar(driver, ExcelUtilsTest.getCellData(1, 0)).click();

		Produto_Page.Produto(driver, ExcelUtilsTest.getCellData(2, 0)).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("/html/body/div[3]/section/article[2]/h2")));

		Screenshot.printTela(driver, Generator.dataHorParaArquvio());

	}

	@AfterMethod
	public void finaliza_teste() throws Exception {

		IniciarDriver.fecharDriver(driver);
	}
}

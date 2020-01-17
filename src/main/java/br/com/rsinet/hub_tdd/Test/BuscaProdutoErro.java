package br.com.rsinet.hub_tdd.Test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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

//		IniciarDriver.esperaImagem();
		
		//Tentei de todoas as forma de comando de espera só execulta o print no lugar correto com o comando ThreadSleep.
		Thread.sleep(2000);

		Screenshot.printTela(driver, Generator.dataHorParaArquvio());
	}

	@After
	public void finaliza_teste() throws Exception {

		IniciarDriver.fecharDriver(driver);
	}
}


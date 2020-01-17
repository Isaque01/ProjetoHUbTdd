package br.com.rsinet.hub_tdd.Test;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_tdd.Util.Constant;
import br.com.rsinet.hub_tdd.Util.ExcelUtilsTest;
import br.com.rsinet.hub_tdd.Util.Generator;
import br.com.rsinet.hub_tdd.Util.IniciarDriver;
import br.com.rsinet.hub_tdd.Util.Screenshot;
import br.com.rsinet.hub_tdd.pageObject.Produto_Page;

public class Produto_CategoriaTest {

	static WebDriver driver;

	@Test
	public void PesquisaProdutoCategoria() throws Exception {

		driver = IniciarDriver.inicializarDriver();

		ExcelUtilsTest.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha3");

		Produto_Page.Pesquisar(driver, ExcelUtilsTest.getCellData(1, 0)).click();

		Produto_Page.Produto(driver, ExcelUtilsTest.getCellData(2, 0)).click();
		
		//Tentei de todoas as forma de comando de espera só execulta o print no lugar correto com o comando ThreadSleep.
		Thread.sleep(2000);
		
		Screenshot.printTela(driver, Generator.dataHorParaArquvio());
		
	}

	@After
	public void finaliza_teste() throws Exception {

		IniciarDriver.fecharDriver(driver);
	}
}



package br.com.rsinet.hub_tdd.Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

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


//		IniciarDriver.esperaImagem();
		
		//Tentei de todoas as forma de comando de espera só execulta o print no lugar correto com o comando ThreadSleep.
		
		Thread.sleep(2000);
		
		//IniciarDriver.esperaImagem();
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		Screenshot.printTela(driver, Generator.dataHorParaArquvio());

	}

	@After
	public void finaliza_teste() throws Exception {
		
		IniciarDriver.fecharDriver(driver);
	}

}

package br.com.rsinet.hub_tdd.Test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.Util.Constant;
import br.com.rsinet.hub_tdd.Util.ExcelUtilsTest;
import br.com.rsinet.hub_tdd.Util.Generator;
import br.com.rsinet.hub_tdd.Util.IniciarDriver;
import br.com.rsinet.hub_tdd.Util.Screenshot;
import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.pageObject.Register_Page;

public class LoginTesteSucesso {

	private static WebDriver driver;

	@BeforeMethod

	public static void iniciar() {
		driver = IniciarDriver.inicializarDriver();
	}

	@Test
	public void CadastroPossitivo() throws Exception {

		ExcelUtilsTest.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");

		Home_Page.btn_Login(driver).click();
		Home_Page.btn_CreateNewUser(driver).sendKeys(Keys.ENTER);

		Register_Page.txtbox_UserName(driver).sendKeys(ExcelUtilsTest.getCellData(1, 0));
		Register_Page.txtbox_Email(driver).sendKeys(ExcelUtilsTest.getCellData(1, 1));
		Register_Page.txtbox_Password(driver).sendKeys(ExcelUtilsTest.getCellData(1, 2));
		Register_Page.txtbox_ConfirmPassword(driver).sendKeys(ExcelUtilsTest.getCellData(1, 3));
		Register_Page.txtbox_FirstName(driver).sendKeys(ExcelUtilsTest.getCellData(1, 4));
		Register_Page.txtbox_LastName(driver).sendKeys(ExcelUtilsTest.getCellData(1, 5));
		Register_Page.txtbox_Phone(driver).sendKeys(ExcelUtilsTest.getCellData(1, 6));
		Register_Page.listbox_Page(driver).selectByVisibleText(ExcelUtilsTest.getCellData(1, 7));
		Register_Page.txtbox_City(driver).sendKeys(ExcelUtilsTest.getCellData(1, 8));
		Register_Page.txtbox_Addres(driver).sendKeys(ExcelUtilsTest.getCellData(1, 9));
		Register_Page.txtbox_State(driver).sendKeys(ExcelUtilsTest.getCellData(1, 10));
		Register_Page.txtbox_CodePage(driver).sendKeys(ExcelUtilsTest.getCellData(1, 11));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Register_Page.checkbox_Agree(driver)));
		Register_Page.checkbox_Agree(driver).click();
		Register_Page.btn_Fined(driver).click();

		wait.until(ExpectedConditions.visibilityOf(Home_Page.img_Speaker(driver)));

		
		assertEquals("http://www.advantageonlineshopping.com/#/", driver.getCurrentUrl());
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		
		wait.until(ExpectedConditions.elementToBeClickable(Home_Page.btn_Login(driver)));
		
		Screenshot.printTela(driver, Generator.dataHorParaArquvio());

		
	}

	@AfterMethod
	public void finaliza_teste() throws InterruptedException {
		IniciarDriver.fecharDriver(driver);

	}
}



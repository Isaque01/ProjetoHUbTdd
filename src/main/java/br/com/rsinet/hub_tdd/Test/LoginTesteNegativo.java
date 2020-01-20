package br.com.rsinet.hub_tdd.Test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.Util.Constant;
import br.com.rsinet.hub_tdd.Util.ExcelUtilsTest;
import br.com.rsinet.hub_tdd.Util.Generator;
import br.com.rsinet.hub_tdd.Util.IniciarDriver;
import br.com.rsinet.hub_tdd.Util.Screenshot;
import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.pageObject.Register_Page;

public class LoginTesteNegativo {
	private WebDriver driver = new ChromeDriver();

	@Test
	public void ExecuteComErro() throws Exception {

		driver.get("http://advantageonlineshopping.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		ExcelUtilsTest.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Planilha1");

		Home_Page.btn_Login(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Home_Page.btn_CreateNewUser(driver)));

		WebElement element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		Register_Page.txtbox_UserName(driver).sendKeys(ExcelUtilsTest.getCellData(5, 0));
		Register_Page.txtbox_Email(driver).sendKeys(ExcelUtilsTest.getCellData(5, 1));
		Register_Page.txtbox_Password(driver).sendKeys(ExcelUtilsTest.getCellData(5, 2));
		Register_Page.txtbox_ConfirmPassword(driver).sendKeys(ExcelUtilsTest.getCellData(5, 3));
		Screenshot.printTela(driver, Generator.dataHorParaArquvio());
		Register_Page.txtbox_FirstName(driver).sendKeys(ExcelUtilsTest.getCellData(5, 4));
		Register_Page.txtbox_LastName(driver).sendKeys(ExcelUtilsTest.getCellData(5, 5));
		Register_Page.txtbox_Phone(driver).sendKeys(ExcelUtilsTest.getCellData(5, 6));
		Register_Page.listbox_Page(driver).selectByVisibleText(ExcelUtilsTest.getCellData(5, 7));
		Register_Page.txtbox_City(driver).sendKeys(ExcelUtilsTest.getCellData(5, 8));
		Register_Page.txtbox_Addres(driver).sendKeys(ExcelUtilsTest.getCellData(5, 9));
		Register_Page.txtbox_State(driver).sendKeys(ExcelUtilsTest.getCellData(5, 10));
		Register_Page.txtbox_CodePage(driver).sendKeys(ExcelUtilsTest.getCellData(5, 11));
		wait.until(ExpectedConditions.elementToBeClickable(Register_Page.checkbox_Agree(driver)));
		Register_Page.checkbox_Agree(driver).click();
		Register_Page.btn_Fined(driver).click();

		assertEquals("http://advantageonlineshopping.com/#/register", driver.getCurrentUrl());

	}

	@AfterMethod
	public void finaliza_teste() throws InterruptedException {
		IniciarDriver.fecharDriver(driver);
	
	}
}

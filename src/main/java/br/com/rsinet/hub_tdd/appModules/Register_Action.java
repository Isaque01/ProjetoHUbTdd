package br.com.rsinet.hub_tdd.appModules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.hub_tdd.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.pageObject.Login_Page;
import br.com.rsinet.hub_tdd.pageObject.Register_Page;

public class Register_Action {

	public static void Execute(WebDriver driver) {
		Home_Page.btn_Login(driver).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Login_Page.btn_Create(driver)));

		Login_Page.btn_Create(driver).click();
		Register_Page.txtbox_UserName(driver).sendKeys("ISAQUE");
		Register_Page.txtbox_Email(driver).sendKeys("isaque.silva@rsinet.com.br");
		Register_Page.txtbox_Password(driver).sendKeys("Concret0");
		Register_Page.txtbox_ConfirmPassword(driver).sendKeys("Concret0");
		Register_Page.txtbox_FirstName(driver).sendKeys("Isaque");
		Register_Page.txtbox_LastName(driver).sendKeys("Silva");
		Register_Page.txtbox_Phone(driver).sendKeys("11949432415");
		Register_Page.listbox_Page(driver).selectByVisibleText("Brazil");
		Register_Page.txtbox_City(driver).sendKeys("Barueri");
		Register_Page.txtbox_Addres(driver).sendKeys("Rua:Juliana n°60");
		Register_Page.txtbox_State(driver).sendKeys("SP");
		Register_Page.txtbox_CodePage(driver).sendKeys("06436-350");
		Register_Page.checkbox_Agree(driver).click();
		Register_Page.btn_Fined(driver).click();

	}

}

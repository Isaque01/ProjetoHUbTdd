package br.com.rsinet.hub_tdd.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Register_Page {
	private static WebElement element;

	public static WebElement txtbox_UserName(WebDriver driver) {
		element = driver.findElement(By.name("usernameRegisterPage"));
		return element;
	}

	public static WebElement txtbox_Email(WebDriver driver) {
		element = driver.findElement(By.name("emailRegisterPage"));
		return element;
	}

	public static WebElement txtbox_Password(WebDriver driver) {
		element = driver.findElement(By.name("passwordRegisterPage"));
		return element;
	}

	public static WebElement txtbox_ConfirmPassword(WebDriver driver) {
		element = driver.findElement(By.name("confirm_passwordRegisterPage"));
		return element;
	}

	public static WebElement txtbox_FirstName(WebDriver driver) {
		element = driver.findElement(By.name("first_nameRegisterPage"));
		return element;
	}

	public static WebElement txtbox_LastName(WebDriver driver) {
		element = driver.findElement(By.name("last_nameRegisterPage"));
		return element;
	}

	public static WebElement txtbox_Phone(WebDriver driver) {
		element = driver.findElement(By.name("phone_numberRegisterPage"));
		return element;
	}

	public static Select listbox_Page(WebDriver driver) {
		element = driver.findElement(By.name("countryListboxRegisterPage"));
		Select select = new Select(element);
		return select;

	}

	public static WebElement txtbox_City(WebDriver driver) {
		element = driver.findElement(By.name("cityRegisterPage"));
		return element;

	}

	public static WebElement txtbox_Addres(WebDriver driver) {
		element = driver.findElement(By.name("addressRegisterPage"));
		return element;
	}

	public static WebElement txtbox_State(WebDriver driver) {
		element = driver.findElement(By.name("state_/_province_/_regionRegisterPage"));
		return element;
	}

	public static WebElement txtbox_CodePage(WebDriver driver) {
		element = driver.findElement(By.name("postal_codeRegisterPage"));
		return element;
	}

	public static WebElement checkbox_Agree(WebDriver driver) {
		element = driver.findElement(By.name("i_agree"));
		return element;

	}

	public static WebElement btn_Fined(WebDriver driver) {
		element = driver.findElement(By.id("register_btnundefined"));
		return element;
	}

}

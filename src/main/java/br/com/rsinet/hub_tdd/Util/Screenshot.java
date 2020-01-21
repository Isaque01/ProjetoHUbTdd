package br.com.rsinet.hub_tdd.Util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	public static void printTela(WebDriver driver, String arquivo) throws Exception {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(screenshot,
				new File("C:\\Users\\isaque.silva\\Hub-workspace\\ProjetoAvaliacao_TDD\\target\\Print\\"
						+arquivo + ".png"));
		} catch (Exception e) {
			System.out.println("Houveram problemas ao copiar o arquivo para a pasta" + e.getMessage());
		}
	}
}


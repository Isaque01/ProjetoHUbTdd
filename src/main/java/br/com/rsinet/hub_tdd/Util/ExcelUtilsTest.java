package br.com.rsinet.hub_tdd.Util;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilsTest {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;

	// Este m�todo � para definir o caminho do arquivo e para abrir o
	// arquivo do Excel, passe o caminho do Excel e o nome da folha como argumentos
	// para este m�todo
	public static void setExcelFile(String Path, String SheetName) throws Exception {

		try {
			// Abrindo arquivo excel
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Acesse a planilha de dados de teste necess�ria
			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Este m�todo � para ler os dados de teste da c�lula do Excel, neste estamos
	// passando par�metros como Row num e Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {
			return e.getMessage();
		}
	}

	
}
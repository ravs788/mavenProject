package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelIterator {
//	private XSSFWorkbook workBook;
//	private XSSFSheet sheet;
	private FileInputStream excelFileIS;
	private String fileName;
	private int intSheetNumber;
	private int intRowNo;

//	public ExcelIterator(String strExcelFile, int intSheetNo, boolean ignoreHeaderRow){
//		fileName = strExcelFile;
//		intSheetNumber = intSheetNo;
//
//		try {
//			excelFileIS = new FileInputStream(fileName);
//			workBook = new XSSFWorkbook(excelFileIS);
//			sheet = workBook.getSheetAt(intSheetNo);
//			intRowNo = sheet.getPhysicalNumberOfRows();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	//	public String getColumnData(String ColumnHeader){
	//		
	//	}
}

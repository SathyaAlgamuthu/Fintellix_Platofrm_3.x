package Utils;



import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static  XSSFWorkbook workbook;
	static XSSFSheet sheet;
	public ExcelUtils(String ExcelPath, String SheetName)
	{try {
		 workbook = new XSSFWorkbook(ExcelPath);
		 sheet = workbook.getSheet(SheetName);
	}
	catch(Exception e){
		e.printStackTrace();
	}
	}
	public int getRowCount()
	{		
		int rowcount=0;
		try {			
			
			rowcount = sheet.getPhysicalNumberOfRows();
			//System.out.println("Number of rows:"+rowcount);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowcount;
	}
	public int getcolCount()
	{	
		int colcount=0;
		try {			
			
			colcount = sheet.getRow(0).getPhysicalNumberOfCells();
			//System.out.println("Number of rows:"+colcount);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colcount;
	}
	public String getCellData(int rowNum, int colNum)
	
	{	
		String celldata = null;
		
		try {			
		
			celldata =sheet.getRow(rowNum).getCell(colNum).getStringCellValue();			 
			//System.out.println(celldata);
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return celldata;
		
}
}

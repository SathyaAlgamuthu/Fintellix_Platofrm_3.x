package Utils;
public class ExcelDataProvider {
	public Object[][] testdata(String ExcelPath, String SheetName)
	{
	ExcelUtils excel = new ExcelUtils(ExcelPath, SheetName);
	int rowCount = excel.getRowCount();
	int ColCount = excel.getcolCount();
	Object data[][]= new Object[rowCount-1][ColCount];
	
	for (int i =1; i<rowCount; i++)
	{
		for (int j = 0; j<ColCount;j++)
		{
			String celldata = excel.getCellData( i, j);
			//System.out.print(celldata);
			data [i-1][j]=celldata;
		}
		//System.out.println();
		
	}
	return data;
	}

}

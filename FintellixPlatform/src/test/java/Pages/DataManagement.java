package Pages;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class DataManagement {
	public String customFactTableName;
	public String title;
	WebDriver driver;
	WebDriverWait wait;	
	double modifiedValue = 20221231;	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String ScalingMsg_Contains = "uploading data with scaled values";	
	By Data = By.id("mainMenuBtn-Data");
	By AdjustMart = By.xpath("//div[@role='menuitem']//span[text() = 'Adjust (Mart)']");
	By CustomFactTables = By.xpath("//div[@id='accordionContainer']//div[@onclick='openAccordion(this)']//div[text()='CUSTOM FACT TABLES']");
	By ActionAdjDropdown = By.xpath("//div[@id='topDiv']//div[@id='actionAdjDropdown']//button[@id='dropdownMenu1']");
	By OpenUploader = By.xpath("//div[@id='topDiv']//div[@id='actionAdjDropdown']//ul[@id='action']//li[@id='openUploader']");
	By UploadDialogBox = By.xpath("//div[@role='dialog']//div//span[text()='" + title + "']");
	By ScalingMsg = By.xpath("//div[@id='wizarddiv']//div[@id='scalingMessage']");
	By UploadWithoutScaled_No = By.xpath("(//div[@id='wizarddiv']//div[@id='scalingMessage'])//input[@id='UploadWithoutScaled']");
	By UploadWithScaled_Yes = By.xpath("(//div[@id='wizarddiv']//div[@id='scalingMessage'])//input[@id='UploadWithScaled']");
	By UploadFile = By.xpath("//div[@id='wizarddiv']//div[@id='fileUploaderFormDiv']//input[@id='upload']");
	By Btn_Upload = By.xpath("//div[@id='wizarddiv']//div[@id='footerDiv']//button[@id='uploadButton']");
	By AllRows = By.xpath("//div[@id='summaryHeaderContainer']//div[@id='allRows']");
	By ActionDropdown = By.xpath("//div[@id='submitContainer']//button[@id='submitActionDropDown']");
	By SubmitToRpf = By.xpath("//div[@id='submitContainer']//ul[@id='submitAction']//li[@id='submitToRpf']");
	By MSg_Submit = By.xpath("//div[@role='dialog']//div[@class='ui-dialog-buttonset']//button[@id='okSubmitButton']");
	By AdjTable = By.xpath("//div[@id='mainContainer']//div[@id='hotContainer']");
	By AdjTableRowOne = By.xpath("//div[@id='adjstmentTblDiv']//div[@class='wtSpreader']//table[@class='htCore']//tbody//tr[1]");
	By InsertRow = By.xpath("//div[@class='htContextMenu handsontable']//table//tbody//td//div[text()='insert row']");
	By RemoveRow = By.xpath("//div[@class='htContextMenu handsontable']//table//tbody//td//div[text()='Remove this row??']");
	By DownloadToEdit = By.xpath("//div[@id='actionAdjDropdown']//ul[@class='dropdown-menu']//li[@id='downloadBrowsedData']");
	By FristRow =By.xpath("//div[@id ='adjstmentTblDiv']//tbody//tr[1]//td[1][1]");
	By SecondRow =By.xpath("//div[@id ='adjstmentTblDiv']//tbody//tr[2]//td[1][1]");
	By ThirdRow =By.xpath("//div[@id ='adjstmentTblDiv']//tbody//tr[3]//td[1][1]");
	By Delete_successMsg =By.xpath("//div[@role='dialog']//div//span[text()='Success Message']");
	By Delete_successMsg_Yes =By.xpath("//div[@role='dialog']//div//div[@class='ui-dialog-buttonset']//button[text()='Yes']");
	By AdjstDataValidateBtn = By.xpath("//div[@id='topDiv']//div[@id='actionAdjDropdown']//ul[@id='action']//li[@id='adjstDataValidateBtn']");
	By DataValidMsg = By.xpath("//div[@role ='dialog']//div//span[text()='Validation']");
	By DataValidMsg_OK = By.xpath("//div[@role ='dialog']//div[@class='ui-dialog-buttonset']//button[text()='Ok']");
	By RPF_Grid= By.xpath("//div[@id='mainContainer']//div[@id='hotContainer']//div[@class='ht_clone_left handsontable']//tbody//div[@class='relative']//span[@class='rowHeader']");
	By DatePicker = By.xpath("//div[@id='factAdjPopUp']//div[@id='dateContainer']//input[@id='datepicker']");
	By DatePicker_ok=By.xpath("//div[@id='factAdjPopUp']//div[@id='okButtonFactDimCont']//div[@id='okButtonFactDim']");
	public DataManagement(WebDriver driver) {
		this.driver = driver;
	
	}
	public void AdjustMart(String a1) throws Exception 
	{	customFactTableName=a1;
		System.out.println(customFactTableName);
		By FactTable = By.xpath("//div[@id='accordionContainer']//div[@class='entityNamesDiv']//div[@data-entityname='"+ customFactTableName + "']");
		WebElement ele_Data = driver.findElement(Data);
		Actions a = new Actions(driver);
		a.moveToElement(ele_Data).perform();
		Thread.sleep(3000);
		WebElement ele_AdjustMart = driver.findElement(AdjustMart);
		a.moveToElement(ele_AdjustMart).click().perform();
		Thread.sleep(5000);	
		   ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		   int i = tabs.size();
		   System.out.println(i);
		   if (i>=2) 
		{		    
		driver.switchTo().window(tabs.get(1));
	    driver.close();
	    driver.switchTo().window(tabs.get(0));	
		   }
		   
		    Thread.sleep(5000); 
		    wait = new  WebDriverWait(driver, Duration.ofSeconds(20));	
		WebElement ele_CustomFactTables = driver.findElement(CustomFactTables);
		a.moveToElement(ele_CustomFactTables).click().perform();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele_FactTable = driver.findElement(FactTable);
		js.executeScript("arguments[0].scrollIntoView();", ele_FactTable);
		Thread.sleep(2500);
		a.moveToElement(ele_FactTable).click().perform();
		Thread.sleep(3000);	
		driver.findElement(DatePicker).clear();
		Thread.sleep(2000);
		driver.findElement(DatePicker).sendKeys("31/12/2020");
		Thread.sleep(5000);
		WebElement ele_DatePicker_ok = driver.findElement(DatePicker_ok);
		a.moveToElement(ele_DatePicker_ok).click().perform();
	}
	public void DownloadToEdit() throws Exception 
	{
		Actions a = new Actions(driver);
		WebElement ele_ActionAdjDropdown = driver.findElement(ActionAdjDropdown);
		a.moveToElement(ele_ActionAdjDropdown).click().perform();
		Thread.sleep(5000);
		WebElement ele_DownloadToEdit = driver.findElement(DownloadToEdit);
		a.moveToElement(ele_DownloadToEdit).click().perform();
		Thread.sleep(5000);
	}
	public void Read_Write_Excel() throws Exception {
		String downloadDirectory = "C:\\Users\\i36638\\Downloads";
		File[] files = new File(downloadDirectory).listFiles();
		Arrays.sort(files, Comparator.comparingLong(File::lastModified));
		File mostRecentFile = files[files.length - 1];
		FileInputStream file = new FileInputStream(mostRecentFile);		
		try (XSSFWorkbook workbookinput = new XSSFWorkbook(file);
		XSSFWorkbook workbookoutput = workbookinput) {
			FileOutputStream out = new FileOutputStream("C:\\Users\\i36638\\Documents\\TESTING\\Metadata\\ListData\\"+ customFactTableName +".xlsx");
			Sheet sheet = workbookinput.getSheetAt(0);
			 // Find the column index for "serial no"
            int serialnoColumnIndex = -1;
            Row headerRow = sheet.getRow(0);
            for (Cell cell : headerRow) {
                if ("SERIAL NO".equals(cell.getStringCellValue())) {
                    serialnoColumnIndex = cell.getColumnIndex();
                    break;
                }
            }

            if (serialnoColumnIndex == -1) {
                System.out.println("Column 'serialno' not found in the Excel sheet.");
                
            }

            // Find the number of rows in the sheet
            int numRows = sheet.getPhysicalNumberOfRows();

            // Fill the "serial no" column in Excel
            for (int rowIdx = 1; rowIdx < numRows; rowIdx++) {
                Row row = sheet.getRow(rowIdx);
                if (row == null) {
                    row = sheet.createRow(rowIdx);
                }
                row.createCell(serialnoColumnIndex).setCellValue(rowIdx);
            }
            
			int periodColumnIndex = findColumnIndex(sheet, "PERIOD");
			Set<String> uniqueValues = new HashSet<>();
			System.out.println(periodColumnIndex);
            if (periodColumnIndex != -1) {
            	for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
					Row row = sheet.getRow(rowIndex);                
                    Cell periodCell = row.getCell(periodColumnIndex);
                    if (periodCell != null) {                    	
                        String currentValue = periodCell.getStringCellValue();
                        if (!uniqueValues.contains(currentValue)) {
                            uniqueValues.add(currentValue);
                        }
                        
                        periodCell.setCellValue(modifiedValue);                     
                        
                    }
                    
                }
            	
            }
        
			workbookoutput.write(out);
			out.close();
			 for (String uniqueValue : uniqueValues) {
	                System.out.println(uniqueValue);
	            }
		
		
		}
	}

    private static int findColumnIndex(Sheet sheet, String columnName) {
        Row headerRow = sheet.getRow(0);
        if (headerRow != null) {
            for (int i = 0; i < headerRow.getLastCellNum(); i++) {
                Cell cell = headerRow.getCell(i);
                if (cell != null && columnName.equals(cell.getStringCellValue())) {
                    return i;
                }
            }
        }
        return -1;
    } 
	
public void Upload_Submit_Excel(String a1) throws Exception
{	
	customFactTableName=a1;
	System.out.println(customFactTableName);
	String ListTableSavelocation= "C:\\Users\\i36638\\Documents\\TESTING\\Metadata\\ListData\\"+customFactTableName+ ".xlsx";
	Thread.sleep(5000); 
	Actions a = new Actions(driver);
	WebElement ele_ActionAdjDropdown = driver.findElement(ActionAdjDropdown);
	a.moveToElement(ele_ActionAdjDropdown).click().perform();
	Thread.sleep(5000);	
	   ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	   int i = tabs.size();
	   System.out.println(i);
	   if (i>=2) 
	{		    
	driver.switchTo().window(tabs.get(1));
 driver.close();
 driver.switchTo().window(tabs.get(0));	
	   }
	   
	    Thread.sleep(5000); 
	    wait = new  WebDriverWait(driver, Duration.ofSeconds(20));	
	WebElement ele_OpenUploader =  driver.findElement(OpenUploader);
	a.moveToElement(ele_OpenUploader).click().perform(); 
	Thread.sleep(5000);	
	   ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	   int j = tabs.size();
	   System.out.println(i);
	   if (j>=2) 
	{		    
	driver.switchTo().window(tabs1.get(1));
 driver.close();
 driver.switchTo().window(tabs1.get(0));	
	   }
	   
	    Thread.sleep(5000); 
	    wait = new  WebDriverWait(driver, Duration.ofSeconds(20));	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(UploadDialogBox));
	String Val_ScalingMsg = driver.findElement(ScalingMsg).getText();
	Thread.sleep(2000);
	System.out.println(Val_ScalingMsg);
 if (Val_ScalingMsg.contains(ScalingMsg_Contains)) 
 { 
	 WebElement  ele_UploadWithoutScaled_No =driver.findElement(UploadWithoutScaled_No);
	 a.moveToElement(ele_UploadWithoutScaled_No).click().perform();
	 Thread.sleep(2000); 
	 WebElement ele_UploadFile  =driver.findElement(UploadFile);
	 ele_UploadFile.sendKeys(ListTableSavelocation); 
	 Thread.sleep(5000); 
	 WebElement ele_Btn_Upload  =driver.findElement(Btn_Upload);
	 a.moveToElement(ele_Btn_Upload).click().perform(); 
	 wait = new  WebDriverWait(driver, Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(AdjTable));
	 WebElement ele_ActionDropdown =driver.findElement(ActionDropdown);
	 a.moveToElement(ele_ActionDropdown).click().perform(); 
	 Thread.sleep(2000);
	 WebElement ele_SubmitToRpf =driver.findElement(SubmitToRpf);
	 a.moveToElement(ele_SubmitToRpf).click().perform(); 
	 Thread.sleep(5000); 
	 wait  = new WebDriverWait(driver, Duration.ofSeconds(20));
	 wait.until(ExpectedConditions.visibilityOfElementLocated(MSg_Submit));
	 WebElement ele_MSg_Submit =driver.findElement(MSg_Submit);
	 a.moveToElement(ele_MSg_Submit).click().perform();
  } 
 else 
 {
  //driver.findElement(Validation_Msg).click();
  System.out.println("scaling not enabled");
  
  }
 
 }
public void InsertRow_Online() throws Exception
{
	Thread.sleep(5000); 
	Actions a = new Actions(driver);
	WebElement ele_FristRow = driver.findElement(FristRow);
	a.moveToElement(ele_FristRow).click().perform();
	a.keyDown(Keys.SHIFT).sendKeys(Keys.END).perform();
	Thread.sleep(2000);
	a.keyDown(Keys.CONTROL).sendKeys("c").perform();
	Thread.sleep(2000);	
	a.contextClick(ele_FristRow).perform();
	Thread.sleep(2000); 
	WebElement ele_InsertRow = driver.findElement(InsertRow);
	a.moveToElement(ele_InsertRow).click().perform();
	Thread.sleep(2000);
	WebElement ele_SecondRow = driver.findElement(SecondRow);
	a.moveToElement(ele_SecondRow).click().perform();
	Thread.sleep(2000);
	a.moveToElement(ele_SecondRow).click().perform();
	Thread.sleep(2000);
	a.keyDown(Keys.CONTROL).sendKeys("v").perform();
	WebElement ele_ThirdRow = driver.findElement(ThirdRow);
	a.moveToElement(ele_ThirdRow).click().perform();
	Thread.sleep(2000);
	a.contextClick(ele_FristRow).perform();
	Thread.sleep(2000);
	WebElement ele_RemoveRow = driver.findElement(RemoveRow);
	a.moveToElement(ele_RemoveRow).click().perform();
	Thread.sleep(2000);
	WebElement ele_Delete_successMsg_Yes = driver.findElement(Delete_successMsg_Yes);
	a.moveToElement(ele_Delete_successMsg_Yes).click().perform();
	WebElement ele_ActionAdjDropdown = driver.findElement(ActionAdjDropdown);
	a.moveToElement(ele_ActionAdjDropdown).click().perform();
	Thread.sleep(2000);
	WebElement ele_AdjstDataValidateBtn = driver.findElement(AdjstDataValidateBtn);
	if (ele_AdjstDataValidateBtn.isEnabled())
	{
		a.moveToElement(ele_AdjstDataValidateBtn).click().perform();
		Thread.sleep(5000);	
		   ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		   int i = tabs.size();
		   System.out.println(i);
		   if (i>=2) 
		{		    
		driver.switchTo().window(tabs.get(1));
	    driver.close();
	    driver.switchTo().window(tabs.get(0));	
		   }
		   
		    Thread.sleep(5000); 
		    wait = new  WebDriverWait(driver, Duration.ofSeconds(20));	
		wait.until(ExpectedConditions.visibilityOfElementLocated(DataValidMsg));
		WebElement ele_DataValidMsg_OK = driver.findElement(DataValidMsg_OK);
		a.moveToElement(ele_DataValidMsg_OK).click().perform();		
	}
	else
	{
		System.out.println("Validate button not enabled");
	
	}
	wait = new  WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOfElementLocated(RPF_Grid));
	 WebElement ele_ActionDropdown =driver.findElement(ActionDropdown);
	 a.moveToElement(ele_ActionDropdown).click().perform(); 
	 Thread.sleep(2000);
	 WebElement ele_SubmitToRpf =driver.findElement(SubmitToRpf);
	 a.moveToElement(ele_SubmitToRpf).click().perform(); 
		Thread.sleep(5000);	
		   ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		   int i = tabs.size();
		   System.out.println(i);
		   if (i>=2) 
		{		    
		driver.switchTo().window(tabs.get(1));
	    driver.close();
	    driver.switchTo().window(tabs.get(0));	
		   }
		   
		    Thread.sleep(5000); 
		    wait = new  WebDriverWait(driver, Duration.ofSeconds(20));	
	wait.until(ExpectedConditions.visibilityOfElementLocated(MSg_Submit));
	 WebElement ele_MSg_Submit =driver.findElement(MSg_Submit);
	 a.moveToElement(ele_MSg_Submit).click().perform();	
	
}
}





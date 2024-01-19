package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DataManagent_RPF {
	WebDriver driver = null;
	String title = "Metadata04";
	WebDriverWait wait;  
	By RPF = By.xpath("//div[@id='mainMenuBtn-ReviewProcessFlow']");
	By RPFTask = By.xpath("//div[@role='menuitem']//span[text() = 'Rpf Tasks']");
	By SearchByTaskName = By.xpath("//div[@id='gbox_grid']//div[@id='gview_grid']//td//input[@id='gs_rpfInstanceName']");
	By OpenInstance = By.xpath("//div[@id='gbox_grid']//div[@id='gview_grid']//div[@class='ui-jqgrid-bdiv']//tr[@id=1]//td[@title='" + title + "']");
	By claimTask =By.xpath("//div[@id ='startClaim']");
	By approveTask = By.xpath("//div[@id='OpenTasksEditable']//div[@id='approve']");
	By ClickYes= By.xpath("//div[@role='alertdialog']//div[@role='toolbar']//button[@role='button']//span[text()='Yes']");
	
	public DataManagent_RPF(WebDriver driver) {
		this.driver = driver;
	
	}
	public void Maker_RPF() throws Exception{
		Thread.sleep(3000);
		WebElement ele_RPF = driver.findElement(RPF);
		Actions a = new Actions(driver);
		a.moveToElement(ele_RPF ).perform();
		Thread.sleep(3000);
		WebElement ele_RPFTask = driver.findElement(RPFTask);
		a.moveToElement(ele_RPFTask).click().perform();
		Thread.sleep(3000);
		WebElement ele_SearchByTaskName = driver.findElement(SearchByTaskName);
		a.moveToElement(ele_SearchByTaskName).sendKeys(title).sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		WebElement ele_OpenInstance = driver.findElement(OpenInstance);
		a.moveToElement(ele_OpenInstance).click().perform();
		Thread.sleep(3000);
		WebElement ele_claimTask = driver.findElement(claimTask);
		a.moveToElement(ele_claimTask).click().perform();
		Thread.sleep(3000);
		wait = new  WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(approveTask));
		WebElement ele_approveTask = driver.findElement(approveTask);
		a.moveToElement(ele_approveTask).click().perform();
		Thread.sleep(3000);
		WebElement ele_ClickYes = driver.findElement(ClickYes);
		a.moveToElement(ele_ClickYes).click().perform();
		Thread.sleep(3000);
	}

	public void Checker_RPF() throws Exception{
		WebElement ele_RPF = driver.findElement(RPF);
		Actions a = new Actions(driver);
		a.moveToElement(ele_RPF ).perform();
		Thread.sleep(3000);
		WebElement ele_RPFTask = driver.findElement(RPFTask);
		a.moveToElement(ele_RPFTask).click().perform();
		Thread.sleep(3000);
		WebElement ele_SearchByTaskName = driver.findElement(SearchByTaskName);
		a.moveToElement(ele_SearchByTaskName).sendKeys(title).sendKeys(Keys.ENTER).perform();
		Thread.sleep(3000);
		WebElement ele_OpenInstance = driver.findElement(OpenInstance);
		a.moveToElement(ele_OpenInstance).click().perform();
		Thread.sleep(3000);
		WebElement ele_claimTask = driver.findElement(claimTask);
		a.moveToElement(ele_claimTask).click().perform();
		Thread.sleep(3000);
		wait = new  WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(approveTask));
		WebElement ele_approveTask = driver.findElement(approveTask);
		a.moveToElement(ele_approveTask).click().perform();
		Thread.sleep(3000);
		WebElement ele_ClickYes = driver.findElement(ClickYes);
		a.moveToElement(ele_ClickYes).click().perform();
		Thread.sleep(3000);
	}
}

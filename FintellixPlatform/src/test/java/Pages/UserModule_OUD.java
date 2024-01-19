package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserModule_OUD {
	WebDriver driver = null;
	By user = By.id("mainMenuBtn-ManageUsers");
	By OUD = By.xpath("//span[(text() = 'Organization Unit Definition' or . = 'Organization Unit Definition')]");
	By OUDname = By.name("orgUnitName");
	By OUDdesc = By.name("orgUnitDesc");
	By OUDsave = By.xpath("//span[text()='Save']");
	By Validation_Msg = By.xpath("//span[text()='OK']");
	By OUD_Success = By.xpath("//span[@id='component-1003']");
	String SuccessMsg = "Organization Unit Definition saved successfully";
	String FailedMsg = "OrganizationUnitDefinition name already exists";
	By OUDsearch = By.xpath("//input[@placeholder='Search by OUD Name']");
	By OUDsearchButton = By
			.xpath("//div[@class='x-trigger-index-1 x-form-trigger x-form-search-trigger x-form-trigger-last']");
	By search1 = By.xpath("//div[text()='OUDAuto']");

	public UserModule_OUD(WebDriver driver) {
		this.driver = driver;
	}

	public void OUD_add(String name, String Description) throws Exception {
		WebElement ele_user = driver.findElement(user);
		Actions a = new Actions(driver);
		a.moveToElement(ele_user).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		;
		WebElement ele_OUD = driver.findElement(OUD);
		a.moveToElement(ele_OUD).click().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(OUDname).sendKeys(name);
		driver.findElement(OUDdesc).sendKeys(Description);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(OUDsave).click();
		Thread.sleep(2000);
		String val = driver.findElement(OUD_Success).getText();
		if (val.contains(SuccessMsg)) {

			driver.findElement(Validation_Msg).click();
		} else {

			driver.findElement(Validation_Msg).click();
		}
		Thread.sleep(2000);
	}

	public void OUD_search() throws Exception {
		Actions a = new Actions(driver);
		driver.findElement(OUDsearch).sendKeys("OUDAuto");
		WebElement ele_OUDsearchButton = driver.findElement(OUDsearchButton);
		a.moveToElement(ele_OUDsearchButton).click().perform();
		Thread.sleep(2000);
		System.out.println("Page navigated to: " + driver.getTitle());

	}

}

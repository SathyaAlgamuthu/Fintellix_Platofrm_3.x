package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserModule_Audit {
	WebDriver driver = null;
	By users = By.id("mainMenuBtn-ManageUsers");
	By userAudit = By.xpath("//span[text()='User Management Audit']");
	By ChooseCategoryicon = By.xpath("//input[@placeholder='--- Mandatory ---']");
	By ChooseCategory = By.xpath("//li[text()='Privilege Management']");
	By ChooseEntityicon = By
			.xpath("(//div[@class='x-trigger-index-1 x-form-trigger x-form-arrow-trigger x-form-trigger-last'])[1]");
	By ChooseEntity = By.xpath("//li[text()='User/Role Functionality Privileges']");
	By ChooseActionicon = By
			.xpath("(//div[@class='x-trigger-index-1 x-form-trigger x-form-arrow-trigger x-form-trigger-last'])[2]");
	By ChooseAction = By.xpath("//li[text()='Update']");
	By SearchButton = By.xpath("//button//span[text()='Search']");
	By infoicon = By.xpath("//div//img[@class='x-action-col-icon x-action-col-0  ']");
	By row = By.xpath("(//table)[6]/tbody/tr");

	public UserModule_Audit(WebDriver driver) {
		this.driver = driver;
	}

	public void Audit() throws Exception {
		WebElement ele_Users = driver.findElement(users);
		Actions a = new Actions(driver);
		a.moveToElement(ele_Users).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ele_userAudit = driver.findElement(userAudit);
		a.moveToElement(ele_userAudit).click().perform();
		Thread.sleep(3000);
		WebElement ele_ChooseCategoryicon = driver.findElement(ChooseCategoryicon);
		a.moveToElement(ele_ChooseCategoryicon).click().perform();
		Thread.sleep(3000);
		WebElement ele_ChooseCategory = driver.findElement(ChooseCategory);
		a.moveToElement(ele_ChooseCategory).click().perform();
		Thread.sleep(3000);
		WebElement ele_ChooseEntityicon = driver.findElement(ChooseEntityicon);
		a.moveToElement(ele_ChooseEntityicon).click().perform();
		Thread.sleep(3000);
		WebElement ele_ChooseEntity = driver.findElement(ChooseEntity);
		a.moveToElement(ele_ChooseEntity).click().perform();
		Thread.sleep(3000);
		WebElement ele_ChooseActionicon = driver.findElement(ChooseActionicon);
		a.moveToElement(ele_ChooseActionicon).click().perform();
		Thread.sleep(3000);
		WebElement ele_ChooseAction = driver.findElement(ChooseAction);
		a.moveToElement(ele_ChooseAction).click().perform();
		Thread.sleep(3000);
		WebElement ele_SearchButton = driver.findElement(SearchButton);
		a.moveToElement(ele_SearchButton).click().perform();
		Thread.sleep(3000);
		WebElement ele_infoicon = driver.findElement(infoicon);
		a.moveToElement(ele_infoicon).click().perform();

	}

}

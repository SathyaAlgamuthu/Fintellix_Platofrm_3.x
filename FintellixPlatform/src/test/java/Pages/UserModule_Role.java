package Pages;

import java.time.Duration;
import java.time.LocalDateTime;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserModule_Role {
	WebDriver driver = null;
	By users = By.id("mainMenuBtn-ManageUsers");
	By Role = By.xpath("//span[text()='Role']");
	By OUDDropDownicon = By
			.xpath("//div[@class='x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-last']");
	By ChooseRole = By.xpath("//li[text()='OUDAuto']");
	By NoRole_Msg = By.xpath("//span[@class='x-component ext-mb-text x-component-default']");
	By RoleValidation_Msg = By.xpath("(//span[text()='OK'])[last()]");
	By Rolename = By.xpath("//input[@name='roleDefName']");
	By RoleDefinition = By.xpath("//input[@name='roleDefDesc']");
	By SaveButton = By.xpath("//span[text()='Save']");
	By ClickOK = By.xpath("(//button//span[text()='OK'])[last()]");
	By MapSolution = By.xpath("(//div//input[@class='x-form-field x-form-checkbox'])[3]");
	By DefaultSolution = By.xpath("(//div//input[@class='x-form-field x-form-radio'])[3]");
	By SaveRoleFunctionality = By.xpath("(//button//span[text()='Save'])[last()]");
	String NoRoleMsg = "No roles are present";
	String RoleSuccessMsg = "Role created successfully";
	String RoleAlreadyExsist = "Role name already exists";
	String Rname;

	public UserModule_Role(WebDriver driver) {
		this.driver = driver;
	}

	public void Role() throws Exception {
		WebElement ele_users = driver.findElement(users);
		Actions a = new Actions(driver);
		a.moveToElement(ele_users).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ele_Role = driver.findElement(Role);
		a.moveToElement(ele_Role).click().perform();
		Thread.sleep(3000);
		WebElement ele_OUDDropDownicon = driver.findElement(OUDDropDownicon);
		a.moveToElement(ele_OUDDropDownicon).click().perform();
		Thread.sleep(3000);
		WebElement ele_ChooseRole = driver.findElement(ChooseRole);
		a.moveToElement(ele_ChooseRole).click().perform();
		Thread.sleep(5000);
		/*
		 * String val = driver.findElement(NoRole_Msg).getText();
		 * System.out.println(val); if( val.contains(NoRoleMsg)) { Thread.sleep(3000);
		 * driver.findElement(RoleValidation_Msg).click(); } else { Thread.sleep(3000);
		 * driver.findElement(RoleValidation_Msg).click();
		 * System.out.println("Else Failed"); }
		 */
	}

	public void RoleCreation() throws Exception {
		Actions a = new Actions(driver);
		Thread.sleep(2000);
		LocalDateTime today = LocalDateTime.now();
		int minute_E = today.getMinute();
		int second_E = today.getSecond();
		String minute1_E = Integer.toString(minute_E);
		String secondd_E = Integer.toString(second_E);
		Rname = minute1_E + secondd_E;
		driver.findElement(Rolename).sendKeys("RoleAuto" + Rname);
		driver.findElement(RoleDefinition).sendKeys("RoleAutoDefinition");
		WebElement ele_SaveButton = driver.findElement(SaveButton);
		a.moveToElement(ele_SaveButton).click().perform();
		Thread.sleep(2500);
		Thread.sleep(2500);
		driver.findElement(ClickOK).click();
		Thread.sleep(2500);
	}

	public void MapSolution() throws Exception {
		Actions a = new Actions(driver);
		driver.findElement(MapSolution).click();
		Thread.sleep(2500);
		driver.findElement(DefaultSolution).click();
		Thread.sleep(2500);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele_SaveRoleFunctionality = driver.findElement(SaveRoleFunctionality);
		js.executeScript("arguments[0].scrollIntoView();", ele_SaveRoleFunctionality);
		Thread.sleep(2500);
		a.moveToElement(ele_SaveRoleFunctionality).click().perform();
		Thread.sleep(2500);
		Thread.sleep(2500);
		driver.findElement(ClickOK).click();
		System.out.println("Page navigated to: " + driver.getTitle());

	}
}

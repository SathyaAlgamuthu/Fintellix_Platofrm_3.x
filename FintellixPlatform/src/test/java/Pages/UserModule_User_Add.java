package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UserModule_User_Add {
	public WebDriver driver = null;

	By users = By.id("mainMenuBtn-ManageUsers");
	By User = By.xpath("//span[text()='User']");
	By OUDDropDownicon = By
			.xpath("//div[@class='x-trigger-index-0 x-form-trigger x-form-arrow-trigger x-form-trigger-last']");
	By ChooseRole = By.xpath("//li[text()='OUDAuto']");
	By Addusericon = By.xpath("(//div//img[@data-qtip='Add User'])[1]");
	By Username = By.xpath("//div//input[@name='userName']");
	By password = By.xpath("//div//input[@name='Password']");
	By Firstname = By.xpath("//div//input[@name='firstName']");
	By Lastname = By.xpath("//div//input[@name='lastName']");
	By confirmpassword = By.xpath("//div//input[@name='confirmPassword']");
	By save = By.xpath("//button//span[text()='Save']");
	By SaveOK = By.xpath("//div[@role='alertdialog']//button//span[text()='OK']");
	By Cancel = By.xpath("//div[@id='solutionFunctionalityCancelBtn']//button//span[text()='Cancel']");
	By searchUserName = By.xpath("//div//input[@name ='searchUserName']");
	By searchbutton = By.xpath("//button//span[text()='Search']");
	By Deleteicon = By.xpath("//div//img[@data-qtip='Delete']");
	By confirmdelete_popup = By.xpath("//div//span[text()='Confirm Delete']");
	By confirmdelete_yes = By.xpath("//button//span[text()='Yes']");
	By confirmdelete_ok = By.xpath("//div[@role='alertdialog']//button//span[text()='OK']");
	int j;
	String Username_delete, Lastname_val1, Firstname_val1;
	String Username_val = "UserAuto";
	String Password_val = "Welcome1";
	String Firstname_val = "FN_User";
	String Lastname_val = "LN_Auto";
	String dValue2;
	public List<String> str_list = new ArrayList<String>();

	public UserModule_User_Add(WebDriver driver) throws Exception {
		this.driver = driver;

	}

	public void User() throws Exception {
		WebElement ele_users = driver.findElement(users);
		Actions a = new Actions(driver);
		a.moveToElement(ele_users).perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement ele_User = driver.findElement(User);
		a.moveToElement(ele_User).click().perform();
		Thread.sleep(3000);
		WebElement ele_RoleDropDownicon = driver.findElement(OUDDropDownicon);
		a.moveToElement(ele_RoleDropDownicon).click().perform();
		Thread.sleep(3000);
		WebElement ele_ChooseRole = driver.findElement(ChooseRole);
		a.moveToElement(ele_ChooseRole).click().perform();
		Thread.sleep(5000);

	}

	public void Adduser() throws Exception {
		Actions a = new Actions(driver);
		Random rand = new Random();
		for (int i = 1; i <= 2; i++) {
			int resRandom = rand.nextInt((9999 - 100) + 1) + 2;
			Username_delete = Username_val + resRandom;
			// System.out.println(Username_val+resRandom);
			str_list.add(Username_delete);
			// System.out.println(str_list);
		}
		j = str_list.size();
		System.out.println(str_list + "" + j);
		for (int i = 0; i < j; i++) {
			String useradd = str_list.get(i);
			WebElement ele_Addusericon = driver.findElement(Addusericon);
			a.moveToElement(ele_Addusericon).click().perform();
			Thread.sleep(2000);
			driver.findElement(Username).sendKeys(useradd);
			driver.findElement(password).sendKeys(Password_val);
			driver.findElement(confirmpassword).sendKeys(Password_val);
			Firstname_val1 = Firstname_val + dValue2;
			driver.findElement(Firstname).sendKeys(Firstname_val1);
			Lastname_val1 = Lastname_val + dValue2;
			driver.findElement(Lastname).sendKeys(Lastname_val1);
			Thread.sleep(2500);
			WebElement ele_SaveButton = driver.findElement(save);
			a.moveToElement(ele_SaveButton).click().perform();
			Thread.sleep(2500);
			WebElement ele_SaveOK = driver.findElement(SaveOK);
			a.moveToElement(ele_SaveOK).click().perform();
			Thread.sleep(2500);
			WebElement ele_cancel = driver.findElement(Cancel);
			Thread.sleep(2500);
			a.moveToElement(ele_cancel).click().perform();
			Thread.sleep(2500);
		}
	}

	public void Deleteuser() throws Exception {
		Actions a = new Actions(driver);
		System.out.println(str_list);
		for (int i = 0; i < j; i++) {
			String Deleteuser = str_list.get(i);
			driver.findElement(searchUserName).clear();
			driver.findElement(searchUserName).sendKeys(Deleteuser);
			Thread.sleep(2000);
			WebElement ele_searchbutton = driver.findElement(searchbutton);
			a.moveToElement(ele_searchbutton).click().perform();
			Thread.sleep(2000);
			WebElement ele_Deleteicon = driver.findElement(Deleteicon);
			a.moveToElement(ele_Deleteicon).click().perform();
			Thread.sleep(2000);
			WebElement ele_confirmdelete_yes = driver.findElement(confirmdelete_yes);
			a.moveToElement(ele_confirmdelete_yes).click().perform();
			Thread.sleep(2000);
			WebElement ele_confirmdelete_ok = driver.findElement(confirmdelete_ok);
			a.moveToElement(ele_confirmdelete_ok).click().perform();
			Thread.sleep(2000);
		}
	}

}

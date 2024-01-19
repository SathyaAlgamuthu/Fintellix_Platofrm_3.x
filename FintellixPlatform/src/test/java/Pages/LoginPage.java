package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver = null;
	By username = By.name("j_username");
	By password = By.name("j_password");
	By loginbtn = By.name("loginbtn");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void credentials(String username1, String password1) {
		driver.findElement(username).sendKeys(username1);
		driver.findElement(password).sendKeys(password1);
	}

	public void loginbtn() {
		driver.findElement(loginbtn).sendKeys(Keys.RETURN);
	}
}

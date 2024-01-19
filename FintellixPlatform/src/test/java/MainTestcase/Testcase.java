package MainTestcase;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.*;
import Utils.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase {
	WebDriver driver;
public static String s1;
public String s2;
public Testcase()
{
	
}
	@BeforeTest()
	public void Browseropen() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		driver.get("https://apse1app065.fintellix.com/fintellix/login.htm?reload=true");
		
	}

	@AfterTest
	public void setup() throws Exception {

		//DBConnection db = new DBConnection();
		//db.SQLconnection_establish("jdbc:oracle:thin:@apse1orcldb001.fintellix.com:1521:orcl", "CIMS_315SP1_APP","Welcome1");

	}

	@Test(priority = 1, enabled = true)
	public void TestcaseLogin() throws Exception {
		try {
			
			LoginPage login1 = new LoginPage(driver);
			login1.credentials("admin", "Welcome1");
			login1.loginbtn();
		} catch (Exception e) {
			throw (e);
		}
	}

	@Test(priority = 2, enabled = false)
	public void UserModuleAll() throws Exception {
		try {
			UserModule_OUD oud = new UserModule_OUD(driver);
			oud.OUD_add("OUDAuto", "OUDAuto Description");
			oud.OUD_search();
			UserModule_Role role = new UserModule_Role(driver);
			role.Role();
			role.RoleCreation();
			role.MapSolution();
			UserModule_Audit Audit = new UserModule_Audit(driver);
			Audit.Audit();
			UserModule_User_Add user = new UserModule_User_Add(driver);
			user.User();
			user.Adduser();
			//user.Deleteuser();
		} catch (Exception e) {
			throw (e);
		}
	}
	@Test(priority = 3, enabled = true , dataProvider = "testdata")
	public void test(String title1, String title2) throws Exception
	{
		try {
			DataManagement data = new DataManagement(driver);
			s1=title2;
			s2=title1;
			System.out.println("Inside"+ title2 +"  |  " +title1);
			data.AdjustMart(s1);
			/*data.InsertRow_Online();
			Browseropen();			
			LoginPage login1 = new LoginPage(driver);
			login1.credentials("Maker_CIMS", "Welcome1");
			login1.loginbtn();
			DataManagent_RPF rpf= new DataManagent_RPF(driver);
			rpf.Maker_RPF();
			driver.quit();
			Browseropen();			
			LoginPage login2 = new LoginPage(driver);
			login2.credentials("Checker_CIMS", "Welcome1");
			login2.loginbtn();
			DataManagent_RPF rpf1= new DataManagent_RPF(driver);
			rpf1.Maker_RPF();
			driver.quit();
			data.AdjustMart(s1);*/
			data.DownloadToEdit();			
			data.Read_Write_Excel();
			data.Upload_Submit_Excel(s1);
			Browseropen();			
			LoginPage login3 = new LoginPage(driver);
			login3.credentials("Maker_CIMS", "Welcome1");
			login3.loginbtn();
			DataManagent_RPF rpf2= new DataManagent_RPF(driver);
			rpf2.Maker_RPF();
			driver.quit();
			Browseropen();			
			LoginPage login4 = new LoginPage(driver);
			login4.credentials("Checker_CIMS", "Welcome1");
			login4.loginbtn();
			DataManagent_RPF rpf3= new DataManagent_RPF(driver);
			rpf3.Maker_RPF();
			driver.quit();

	
		} catch (Exception e) {
			throw (e);
		}
	}
		
	@DataProvider(name="testdata")
	public Object[][] getdata() throws Exception {
		ExcelDataProvider DP = new ExcelDataProvider();	
		String ExcelPath = "C:\\Users\\i36638\\Documents\\Automation\\FintellixPlatform\\Excel\\DataManagement.xlsx";
		Object data[][] = DP.testdata(ExcelPath, "DataManagement");
		return data;
				
	}

}

package Config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesFile {
	static Properties prop = new Properties();
	//String Propertiesfilelocation = "C:\\Users\\i36638\\Documents\\Automation\\FintellixPlatform\\src\\test\\java\\Config\\Config.properties";
	public static void readPropertiesfile()
	{
		
		try {
			InputStream input = new FileInputStream("C:\\Users\\i36638\\Documents\\Automation\\FintellixPlatform\\src\\test\\java\\Config\\Config.properties");
			prop.load(input);
			prop.getProperty(null);
			
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public static void writePropertiesfile()
	{
		try {
			OutputStream output = new FileOutputStream("C:\\Users\\i36638\\Documents\\Automation\\FintellixPlatform\\src\\test\\java\\Config\\Config.properties");
			prop.setProperty("Browser", "Chrome");
			prop.store(output, null);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}

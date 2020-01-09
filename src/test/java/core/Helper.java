package core;

import org.openqa.selenium.WebDriver;
import br.com.santander.model.BrowserType;
import br.com.santander.utilities.DriverFactory;

public class Helper {

	private static Helper _instance;
	private static WebDriver _driver;
	
	private Helper() {
		
	}
	
	public static Helper getInstance() {
		if(_instance == null) {
			_instance = new Helper();
			_driver = DriverFactory.getInstance().getDriver(BrowserType.Chrome);
		}			
		
		return _instance;
	}
	
	public WebDriver getDriver() {
		return _driver;
	}
}

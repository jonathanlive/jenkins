package core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import br.com.santander.model.BrowserType;
import br.com.santander.utilities.DriverFactory;
import util.Base;

public class Helper {

	private static Helper _instance;
	private static WebDriver _driver;
	
	private Helper() {
		
	}
	
	public static Helper getInstance() {
		if(_instance == null) {
			_instance = new Helper();
			_driver = DriverFactory.getInstance().getDriver(BrowserType.Chrome);
			//_driver = DriverFactory.getInstance().getDriver(BrowserType.Chrome, "http://localhost:4444/wd/hub", Base.getChromeCaps());

		}			
		
		return _instance;
	}
	
	public WebDriver getDriver() {
		return _driver;
	}
}

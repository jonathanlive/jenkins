package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import br.com.santander.utilities.DriverFactory;

public interface PageMaker {
	
	public DriverFactory driverFactory = DriverFactory.getInstance();
	
	public static <T extends PageMaker> T getInstance(Class<T> pageClass, WebDriver driver) {
		try {
			T pageObject = pageClass.newInstance();
			PageFactory.initElements(driver, pageObject);

			return pageObject;
		} catch (Exception e) {
			throw new PageException(e);
		}
	}
}

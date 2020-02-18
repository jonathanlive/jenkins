package util;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {
	
	public static final String homepage = "https://nubank.com.br/";	
	public static DesiredCapabilities cap;
	
	public static DesiredCapabilities getChromeCaps() {
		cap = DesiredCapabilities.chrome();
		cap.setCapability("version", "");
		cap.setCapability("platform", "linux");
		return cap;
	}

}

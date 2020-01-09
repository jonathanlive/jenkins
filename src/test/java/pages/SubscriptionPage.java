package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import core.Helper;
import core.PageMaker;
import util.Base;

public class SubscriptionPage implements PageMaker{
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"widget-nav-toggle-button\"]")
	WebElement btnSubscribe;	
	
	@FindBy(how = How.CSS, using = "#field-name")
	WebElement tboxName;
	
	@FindBy(how = How.CSS, using = "#field-cpf")
	WebElement tboxIdentification;
	
	@FindBy(how = How.CSS, using = "#field-email")
	WebElement tboxEmail;
	
	@FindBy(how = How.CSS, using = "#field-emailConfirmation")
	WebElement tboxEmailConfirmation;	
	
	@FindBy(how = How.CSS, using = "#label-accepted > span.style__Checkmark-b6bfp4-0.deSvJy")
	WebElement ckboxAgreementPolicy;	
	
	@FindBy(how = How.CSS, using = "#widget-panel > form > div.style__FormActions-sc-68njna-2.cTueib > button")
	WebElement btnSendSubscription;	
	
	@FindBy(how = How.CSS, using = "#widget-panel > div.style__Container-sc-11vbf2p-0.jlrlfU > div.style__Head-sc-11vbf2p-2.ffnfLP > p")
	WebElement confirmationMessage;	
	
	public void openHomepage() {
		Helper.getInstance().getDriver().get(Base.homepage);
	}
	
	public void clickBtnSubscribe() {
		driverFactory.click(btnSubscribe);
	}
	
	public void fillSubscriptionForm(String name, String identification, String email) {
		driverFactory.waitForElement(tboxName).sendKeys(name);
		driverFactory.waitForElement(tboxIdentification).sendKeys(identification);
		driverFactory.waitForElement(tboxEmail).sendKeys(email);
		driverFactory.waitForElement(tboxEmailConfirmation).sendKeys(email);
		driverFactory.waitForElement(ckboxAgreementPolicy).click();
	}
	
	public void clickBtnSendSubscription() {
		driverFactory.click(btnSendSubscription);
	}
	
	public String getConfirmationMessage() {
		return driverFactory.waitForElement(confirmationMessage).getAttribute("Value");
	}
}

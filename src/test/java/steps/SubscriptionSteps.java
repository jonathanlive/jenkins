package steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import core.Helper;
import core.PageMaker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SubscriptionPage;

public class SubscriptionSteps {
	
	SubscriptionPage subscriptionPage;
	WebDriver driver;
	
	public SubscriptionSteps() {
		driver = Helper.getInstance().getDriver();
		subscriptionPage = PageMaker.getInstance(SubscriptionPage.class, driver);
	}
 
    @Given("^I have navigated to nubank site$")
    public void i_have_navigated_to_nubank_site() throws Throwable {
    	subscriptionPage.openHomepage();
    }

    @When("^I click on subscribe button$")
    public void i_click_on_subscribe_button() throws Throwable {
    	subscriptionPage.clickBtnSubscribe();
    }

    @Then("^The subscription will be sent sucessful$")
    public void the_subscription_will_be_sent_sucessful() throws Throwable {
    	String validMessage = "Pronto! Agora é só checar seu email.";
    	Assert.assertEquals(validMessage, subscriptionPage.getConfirmationMessage());
    }

    @And("^Fill the form with my name(.+) and identification(.+) and my email(.+)$")
    public void fill_the_form_with_my_name_and_identification_and_my_email(String name, String identification, String email) throws Throwable {
    	subscriptionPage.fillSubscriptionForm(name, identification, email);
    	subscriptionPage.clickBtnSendSubscription();
    }	
}

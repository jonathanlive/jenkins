package runners;

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import core.Helper;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features",
dryRun = false,
glue = "steps",
monochrome = true,
snippets = SnippetType.CAMELCASE,
plugin = {"util.CustomPlugin:./test/java/util"})
public class SubscriptionTest {
	
	@BeforeClass
	public static void setUp() throws Exception {
				
	}
	
	@AfterClass
	public static void tearDown() throws IOException {
		Helper.getInstance().getDriver().quit();
	}
}

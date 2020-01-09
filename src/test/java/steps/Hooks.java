package steps;

import java.io.IOException;
import core.PageMaker;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;

public class Hooks implements PageMaker{
	
	public Hooks() {
		
	}
	
	@BeforeStep
	public void setUp(Scenario scenario) throws Exception {
		
	}
	
	@AfterStep
	public void tearDown(Scenario scenario) throws InterruptedException, IOException {
		
	}
	
 }

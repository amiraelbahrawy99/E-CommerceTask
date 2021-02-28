package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features/CartCheckoutScenario.feature"
,glue= {"StepDefinitions"}
,plugin = {"json:target/cucumber.json"})



public class TestRunner  extends AbstractTestNGCucumberTests {
	
			

}
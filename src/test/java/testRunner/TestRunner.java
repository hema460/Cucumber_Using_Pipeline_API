package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/test/resources/features", glue={"stepDef"},plugin={"pretty","html:target/cucumber-html-report",               // optional basic report
"json:target/cucumber-report/cucumber.json"}, // required for Masterthought
monochrome=true,dryRun=false)
public class TestRunner extends AbstractTestNGCucumberTests{

	@DataProvider(parallel=false)
	public Object[][] scenarios() {
		
		System.setProperty("cucumber.features.rertry", "1");
		return super.scenarios();
        
    }
	
}

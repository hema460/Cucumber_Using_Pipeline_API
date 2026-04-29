package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/test/resources/features", glue={"stepDef"},plugin = {
		 "pretty",
		 "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"		 
		
	}, // required for Masterthought
monochrome=true,dryRun=false)
public class TestRunnerTest  extends AbstractTestNGCucumberTests{


    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}

package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\Features", 
				 glue = {"stepdefenition"},
				 tags = "@Sanity",
				 dryRun = false,
				 monochrome = true,
				 plugin = {"pretty", "json:target/cucumber.json",
		                  "junit:target/cucumber-html-report"})

public class Runner extends AbstractTestNGCucumberTests{
	
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }

}

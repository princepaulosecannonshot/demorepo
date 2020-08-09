package TestRunners;

	import org.junit.runner.RunWith;

import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
	 
	@RunWith(Cucumber.class) 
	@CucumberOptions(features="src/test/resources/Features"
	,glue={"StepDefs"}
	,plugin= {"io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"}
	) 
	public class Runner1
	{
		
		
	}


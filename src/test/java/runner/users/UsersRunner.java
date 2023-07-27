package runner.users;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


/**
 * This Class takes care of Execution.
 * @author Pavan
 *
 */
@CucumberOptions(
		features = {"./src/test/java/feature_client"},
		glue= {"step_definition.user","hook"},
		dryRun = false,
		tags="@smokeTest",
		monochrome = true,
		plugin = {"pretty",
				"html:target/cucumberReport.html",
				"json:target/cucumberjson.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				//"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
		}
		)



public class UsersRunner extends AbstractTestNGCucumberTests
{
	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() 
	{
		return super.scenarios();
	}
}

package Runner_C;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features =".\\src\\test\\resources\\API1", glue="Step_D",
plugin = {"pretty","html:target/report.html"},tags="@api")
public class Runner_C1 extends AbstractTestNGCucumberTests{
	
}

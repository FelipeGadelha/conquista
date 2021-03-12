package br.com.cyber.funcional.conquista.execute.runners;

import static br.com.cyber.funcional.conquista.core.utils.Utilitarios.*;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		extraGlue = { "br.com.cyber.funcional.conquista.execute" },
		tags =  "@tag" ,
		plugin = { 	"pretty",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
					"json:target/evidencias/json/report.json",
					"timeline:test-output-thread/"
		},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		publish = true,
		dryRun = false
		)

public class RunnerTest {
	
//	private TestNGCucumberRunner testNGCucumberRunner;
//
//	@BeforeClass(alwaysRun = true)
//    public void setUpClass() throws Exception {
//        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
//    }
//	
//	 @DataProvider
//	    public Object[][] features() {
////	        return testNGCucumberRunner.provideFeatures();
//	        return testNGCucumberRunner.provideScenarios();
//	    }
//
//	    @AfterClass(alwaysRun = true)
//	    public void tearDownClass() throws Exception {
//	        testNGCucumberRunner.finish();
//	    }
	@BeforeClass
	public static void screenshotFileCheck() {
		screenshotsCriarFiles();
		deletandoScreenshotsFile();
	}
	
}
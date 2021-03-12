package br.com.cyber.funcional.conquista.execute.runners;

import static br.com.cyber.funcional.conquista.core.utils.Utilitarios.deletandoScreenshotsFile;
import static br.com.cyber.funcional.conquista.core.utils.Utilitarios.screenshotsCriarFiles;

import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features", 
		extraGlue = {"br.com.cyber.funcional.conquista.execute" }, 
		tags = "@tag",
		plugin = {
//					"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"json:target/evidencias/json/report.json",
				"timeline:target/test-output-thread/" }, 
		monochrome = true, 
		snippets = SnippetType.CAMELCASE, 
		publish = true, 
		dryRun = false
		)

public class RunnerTestNg extends AbstractTestNGCucumberTests {

	@Override
	public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
		super.runScenario(pickleWrapper, featureWrapper);

		System.out.println("RUNNER " + pickleWrapper.toString());
		System.out.println("RUNNER " + pickleWrapper.getPickle().getName());
		System.out.println("RUNNER " + pickleWrapper.getPickle().getScenarioLine());
		System.out.println("RUNNER " + pickleWrapper.getPickle().getTags().toString());
		System.out.println("RUNNER " + pickleWrapper.getPickle().getUri().toString());
		System.out.println("RUNNER " + pickleWrapper.getPickle().getLine());

		System.out.println("RUNNER " + featureWrapper.toString());
	}

	@DataProvider(parallel = true)
	@Override
	public Object[][] scenarios() {
		return super.scenarios();
	}

	@BeforeClass
	public static void screenshotFileCheck() {
		screenshotsCriarFiles();
		deletandoScreenshotsFile();
	}

}
package br.com.cyber.funcional.conquista.execute.hooks;

import static br.com.cyber.funcional.conquista.core.DriverFactory.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.cyber.funcional.conquista.core.utils.InputDeDados;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HookBefore {
	
	
	
	@Before(order = 0)
	public static void coletarDados(Scenario scenario) throws IOException {
		
		String pathScenario = scenario.getUri().toString().replace("file:///C:", "");
		System.out.println("-------------------------------------" + pathScenario);
		List<String> allLines = Files.readAllLines(Paths.get(pathScenario));
		int count = 1;
		for (String line : allLines) {
			if (count == scenario.getLine()) {
				InputDeDados.setInput(line);
			}
			count++;
		}
	}

	@Before(order = 0)
	public void setarConfiguracoes() {
		getDriver().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		new WebDriverWait(getDriver(), 10);
		System.out.println(Thread.currentThread().getName());
	}

}

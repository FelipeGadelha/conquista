package br.com.cyber.funcional.conquista.execute.hooks;

import static br.com.cyber.funcional.conquista.core.DriverFactory.killDriver;
import static br.com.cyber.funcional.conquista.core.utils.Utilitarios.caminhoScreenshot;
import static br.com.cyber.funcional.conquista.core.utils.Utilitarios.formatter;
import static br.com.cyber.funcional.conquista.core.utils.Utilitarios.fullPageScreenshot;

import java.io.File;

import br.com.cyber.funcional.conquista.core.Properties;
import br.com.cyber.funcional.conquista.observer.ErrorEvent;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class HookAfter {
	
	
	@After(order = 2)
	public void inputData(Scenario scenario) {
		System.out.println(scenario.getId());
		System.out.println(scenario.getName());
		System.out.println(scenario.getLine());
		System.out.println(scenario.getStatus().name());
		scenario.getSourceTagNames().forEach(System.out::println);
		if(!scenario.isFailed()) {
			System.out.println("EVENT ----------------------------");
			ErrorEvent event= new ErrorEvent();
		}
	}
	
	@After(order = 1)
	public void screenshot(Scenario scenario) {

		String nome = String.format("%s_%s", scenario.getName().replace(" ", "_"), formatter()); 
		String evidencia = (!scenario.isFailed()) ? evidencia = "sucesso" : "erro";
		String caminho = caminhoScreenshot() + evidencia + File.separator;

		fullPageScreenshot(caminho, nome);
	}

	@After(order = 0)
	public void finalizar() {
		if (Properties.FECHAR_BROWSER)
			killDriver();
	}
}

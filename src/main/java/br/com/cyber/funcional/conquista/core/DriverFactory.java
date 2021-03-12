package br.com.cyber.funcional.conquista.core;

import org.openqa.selenium.WebDriver;

import br.com.cyber.funcional.conquista.enums.SistemaOperacional;

public class DriverFactory {
	
//	private static WebDriver driver;
	
	private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>() {
		@Override
		protected synchronized WebDriver initialValue() {
			return initDriver();
		}
	};
	
	private DriverFactory() { }
	
	public static WebDriver getDriver() {
		return threadDriver.get();
	}
	
	public static WebDriver initDriver() {
		WebDriver driver = null;
		driver = Properties.browser.newDriver(SistemaOperacional.valueOf(getSOFormatted()), Properties.INTERFACE_GRAFICA);
		driver.manage().window().maximize();			
		return driver;
	}
	
	public static void killDriver() {
		WebDriver driver = getDriver();
		if (driver != null) {
			driver.quit();
			driver = null;			
		}
		if (threadDriver != null) {
			threadDriver.remove();
		}
	}
	
	private static String getSOFormatted() {
		String sistemaOperacional = System.getProperty("os.name");
		String[] split = sistemaOperacional.split(" ");
		return split[0].toUpperCase();
	}
	
}

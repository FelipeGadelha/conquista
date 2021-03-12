package br.com.cyber.funcional.conquista.core.interactions;


import static br.com.cyber.funcional.conquista.core.DriverFactory.getDriver;
import static br.com.cyber.funcional.conquista.enums.ExceptionsMessages.*;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface que organiza métodos de manipulação do navegador.
 * 
 * @author Felipe Gadelha
 * @author Jonathan Daflon
 * @author Thyago Sasso
 */
public interface INavegador {

	static final Logger log = LoggerFactory.getLogger(INavegador.class.getSimpleName());
//	public JavascriptExecutor jse = (JavascriptExecutor) getDriver();
	
	/**
	 * <p><strong>Substitui:</strong>
	 * <ul>
	 * <li>novaAba()</li>
	 * </ul>
	 * <p><strong>Função:</strong> abre uma nova guia no navegador.
	 * @return {@link Void void}
	 */
	default void newTab() {
		log.info("Método: newTab() - Abrindo uma nova guia.");
//		jse.executeScript("window.open('about:blank', '-blank')");
		((JavascriptExecutor) getDriver()).executeScript("window.open('about:blank', '-blank')");
	}
	
	/**
	 * <p><strong>Substitui:</strong>
	 * <ul>
	 * <li>trocarAba()</li>
	 * </ul>
	 * <p><strong>Função:</strong> abre uma nova guia no navegador.
	 * @param tab é a {@link Integer aba} do navegador que terá foco.
	 * @return {@link Void void}
	 */
	default void switchTab(Integer tab) {
		log.info(String.format("Método: switchTab() - Trocando para a guia %s.", tab.toString()));
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		tabs.forEach(t -> log.info(t));
		getDriver().switchTo().window(tabs.get(tab));
	}
	
	/**
	 * <p><strong>Substitui:</strong>
	 * <ul>
	 * <li>fecharAba()</li>
	 * </ul>
	 * <p><strong>Função:</strong> encerra a guia atual do navegador.
	 * @return {@link Void void}
	 */
	default void closeTab() {
		log.info("Método: closeTab() - Fechando a guia atual.");
		getDriver().close();
	}
	
	/**
	 * <p><strong>Função:</strong> realiza um scroll na tela até o elemento especificado.
	 * @param by é o {@link By seletor} do elemento.
	 * @param description é o {@link String nome} do elemento.
	 * @return {@link Void void}
	 * @throws NoSuchElementException caso o elemento não existir.
	 * @throws TimeoutException caso exceder o tempo de carregamento do elemento.
	 * @throws ElementNotVisibleException caso a visão do elemento estiver obstruída ou ele estiver oculto.
	 * @throws StaleElementReferenceException caso o elemento não estiver mais visível na DOM.
	 * @throws ElementNotInteractableException caso o elemento estiver visível, mas em um estado não interagível.
	 * @throws Exception caso ocorra uma exceção não tratada.
	 * @see InteractionException
	 */
	public default void scroll(By by, String description) {
		log.info(String.format("Método: scroll() - Descendo a tela até o elemento %s.", description));
		try {
			
			WebElement e = getDriver().findElement(by);
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", e);
			
		} catch (NoSuchElementException e) {
			NO_SUCH_ELEMENT.getException(e, description);
			
		} catch (TimeoutException e) {
			TIMEOUT.getException(e, description);
			
		} catch (ElementNotVisibleException e) {
			NOT_VISIBLE.getException(e, description);
			
		} catch (StaleElementReferenceException e) {
			STALE_REFERENCE.getException(e, description);
			
		} catch (ElementNotInteractableException e) {
			NOT_INTERACTABLE.getException(e, description);
			
		} catch (Exception e) {
			EXCEPTION.getException(e, description);
		}
	}
	
}

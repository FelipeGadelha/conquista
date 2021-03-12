package br.com.cyber.funcional.conquista.core;

import br.com.cyber.funcional.conquista.core.interactions.Interactions;

/**
 * Uma classe base para todos os PageObjects.
 * 
 * @author Felipe Gadelha
 * @author Jonathan Daflon
 * @author Thyago Sasso
 *
 */
public abstract class BasePage {

	protected Interactions interactions ;
	
	public BasePage() {
		interactions = new Interactions();
	}
}
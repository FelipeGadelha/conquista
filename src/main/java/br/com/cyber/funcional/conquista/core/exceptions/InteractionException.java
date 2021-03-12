package br.com.cyber.funcional.conquista.core.exceptions;

import static br.com.cyber.funcional.conquista.core.utils.Utilitarios.formatter;

import br.com.cyber.funcional.conquista.core.utils.InputDeDados;

/**
 *<p><strong>Excessões Personalizadas</strong> para a classe {@link br.com.cyber.conquista.frameworkConquista.core.interacao.Interactions Interactions}.
 * 
 * @author Felipe Gadelha
 * @author Jonathan Daflon
 * @author Thyago Sasso
 */
public class InteractionException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;
	
	public InteractionException(String message) {
		
		this.message = String.format("%s - %s", formatter(), message);
	}

	@Override
	public String toString() {
	
		return 
		"============================ ERRO ============================"
		+ System.lineSeparator()
		+ System.lineSeparator()
		+ this.getClass().getSimpleName() + ": " + message
		+ System.lineSeparator()
		+ System.lineSeparator()
		+ "====================== MASSA UTILIZADA ======================"
		+ System.lineSeparator()
		+ System.lineSeparator()
		+ InputDeDados.getInput()
		+ System.lineSeparator()
		+ System.lineSeparator()
		+ "=========================== DICAS ==========================="
		+ System.lineSeparator()
		+ System.lineSeparator()
		+ "Verifique se o seu Xpath está correto."
		+ System.lineSeparator()
		+ "Verifique se não existe um Iframe nessa página."
		+ System.lineSeparator()
		+ "Verifique se seu PageObject foi instanciado corretamente em caso de nullPointer."
		+ System.lineSeparator()
		;
	}
}

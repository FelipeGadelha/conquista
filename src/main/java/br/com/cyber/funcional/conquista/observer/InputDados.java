package br.com.cyber.funcional.conquista.observer;

public class InputDados implements InputDataObserver{

	@Override
	public void event(ErrorEvent event) {
		System.out.println("Teste funcionando");
		
	}

}

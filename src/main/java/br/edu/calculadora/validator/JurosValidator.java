package br.edu.calculadora.validator;

import org.springframework.stereotype.Component;

import br.edu.calculadora.dominio.Juros;

@Component
public class JurosValidator {

	public void validarFormulario (Juros juros) throws IllegalArgumentException {
		
		if (juros.getCapital() <= 0 || juros.getTaxaDeJuros() <=0 || juros.getTempo() <= 0) {
			throw new IllegalArgumentException ("Existem campos inválidos, por favor, digite valores maiores que zero");
		}
	}
}

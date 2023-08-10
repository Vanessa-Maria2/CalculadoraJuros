package br.edu.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class JurosService {

	public double conversaoTempo(Integer tempo, Integer tipoDeTaxa, Integer tipoDeTempo) {
		double auxTempo = tempo;

		if (tipoDeTaxa == 0) { // taxa ao dia
			if (tipoDeTempo == 1) { //mês
				auxTempo = tempo * 30;
			} else if (tipoDeTempo == 2) { //ano
				auxTempo = tempo * 365;
			}
		} else if (tipoDeTaxa == 1) {// taxa ao mês
			if (tipoDeTempo == 0) { // tempo em dia
				auxTempo = (double) tempo/30;
			} else if (tipoDeTempo == 2) { // tempo em ano
				auxTempo = tempo * 12;
			}
		} else { // taxa ao ano
			if (tipoDeTempo == 0) { // tempo em dia
				auxTempo = (double) tempo / 365;
			} else if (tipoDeTempo == 1) { // tempo em mês
				auxTempo = (double) tempo/12;
			}
		}

		return auxTempo;
	}

	public double calcularJurosSimples(double capital, double taxaDeJuros, Integer tempo, Integer tipoDeTaxa,
			Integer tipoDeTempo) {
		double auxTempo = tempo;
		
		if (tipoDeTempo != tipoDeTaxa) {
			auxTempo = conversaoTempo(tempo, tipoDeTaxa, tipoDeTempo);
		}

		return capital * (taxaDeJuros / 100) * auxTempo;
	}
	
	public double calcularJurosCompostos(double capital, double taxaDeJuros, Integer tempo, Integer tipoDeTaxa,
			Integer tipoDeTempo) {
		double auxTempo = tempo;
		
		if (tipoDeTempo != tipoDeTaxa) {
			auxTempo = conversaoTempo(tempo, tipoDeTaxa, tipoDeTempo);
		}
		
		return (capital * Math.pow((1 + (taxaDeJuros/100)), auxTempo)) - capital;
	}
	
	public double calcularJuros(double capital, double taxaDeJuros, Integer tempo, Integer tipoDeTaxa,
			Integer tipoDeTempo, Integer tipoDeJuros) {
		double juros = 0;
		
		if (tipoDeJuros == 0) { //juros simples
			juros = calcularJurosSimples(capital, taxaDeJuros, tempo, tipoDeTaxa, tipoDeTempo);
		} else if (tipoDeJuros == 1) { //juros compostos
			juros = calcularJurosCompostos(capital, taxaDeJuros, tempo, tipoDeTaxa, tipoDeTempo);
		}
		return juros;
	}
}

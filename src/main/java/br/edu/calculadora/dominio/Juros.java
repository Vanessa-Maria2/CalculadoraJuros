package br.edu.calculadora.dominio;

public class Juros {
	private double capital;
	private double juros;
	private double taxaDeJuros;
	private Integer tempo, tipoDeTaxa, tipoDeJuros, tipoDeTempo;
	
	public double getCapital() {
		return capital;
	}
	
	public void setCapital(double capital) {
		this.capital = capital;
	}
	
	public double getJuros() {
		return juros;
	}
	
	
	public void setJuros(double juros) {
		this.juros = juros;
	}
	
	public double getTaxaDeJuros() {
		return taxaDeJuros;
	}
	
	public void setTaxaDeJuros(double taxaDeJuros) {
		this.taxaDeJuros = taxaDeJuros;
	}
	
	public Integer getTempo() {
		return tempo;
	}
	
	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}
	
	public Integer getTipoDeTaxa() {
		return tipoDeTaxa;
	}
	
	public void setTipoDeTaxa(Integer tipoDeTaxa) {
		this.tipoDeTaxa = tipoDeTaxa;
	}
	
	public Integer getTipoDeJuros() {
		return tipoDeJuros;
	}
	
	public void setTipoDeJuros(Integer tipoDeJuros) {
		this.tipoDeJuros = tipoDeJuros;
	}
	
	public Integer getTipoDeTempo() {
		return tipoDeTempo;
	}
	
	public void setTipoDeTempo(Integer tipoDeTempo) {
		this.tipoDeTempo = tipoDeTempo;
	}
}
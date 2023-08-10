package br.edu.calculadora.controller;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.calculadora.dominio.Juros;
import br.edu.calculadora.service.JurosService;
import br.edu.calculadora.validator.JurosValidator;

@Controller
@RequestMapping("/calculadora")
public class JurosController {
		
	@Autowired
	JurosService jurosService;
	
	@Autowired
	JurosValidator jurosValidator;
		
	@RequestMapping("/inicio")
	public String jurosSimples(Model model) {
		model.addAttribute("juros", new Juros());
		return "index";
	}
	
	@RequestMapping("/calcular")
	public String calcularJuros(Juros juros, @RequestParam(value="tipoDeTaxa") Integer tipoDeTaxa,
			@RequestParam(value="tipoDeTempo") Integer tipoDeTempo,
			@RequestParam(value="tipoDeJuros") Integer tipoDeJuros,
			ModelMap model) {	

		try {
			
			jurosValidator.validarFormulario(juros);
			
			double resultado = jurosService.calcularJuros(juros.getCapital(), juros.getTaxaDeJuros(), juros.getTempo(), tipoDeTaxa, tipoDeTempo, tipoDeJuros);
			
			DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
		    decimalFormat.setRoundingMode(RoundingMode.DOWN);
		        
			juros.setJuros(Double.parseDouble(decimalFormat.format(resultado).replace(",", ".")));
			
			model.addAttribute("tipoDeTaxa", tipoDeTaxa);
			model.addAttribute("tipoDeTempo", tipoDeTempo);
			model.addAttribute("tipoDeJuros", tipoDeJuros);
			model.addAttribute("juros", juros);
			
		} catch (IllegalArgumentException e) {
			model.addAttribute("mensagens", e.getMessage());
		}
		
		return "index";
	}

}

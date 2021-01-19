package com.algaworks.cobrancaAlgaWorks.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.cobrancaAlgaWorks.model.StatusTitulo;
import com.algaworks.cobrancaAlgaWorks.model.Titulo;
import com.algaworks.cobrancaAlgaWorks.repository.Titulos;

@Controller
@RequestMapping("/titulos")
public class TituloController {
	
	@Autowired
	private Titulos titulos;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroTitulo");
		mv.addObject(new Titulo());
		return mv;
	}
	
	@RequestMapping( method =RequestMethod.POST )
	public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes) {
		
		if(errors.hasErrors()) {
			System.out.println(">>Erro salvar");
			return "CadastroTitulo";
		}
				
		System.out.println(">>Banco<<");
		titulos.save(titulo);
		
		attributes.addFlashAttribute("mensagem", "Título salvo com sucesso!");
		System.out.println(">>"+ titulo.getDataVencimento());
		return "redirect:/titulos/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
		List<Titulo> todosTitulos = titulos.findAll();
		ModelAndView mv = new ModelAndView("PesquisaTitulos");
		mv.addObject("titulos", todosTitulos);
		return mv;
	}
	
	@ModelAttribute("todosStatusTitulo")
	public List<StatusTitulo> todosStatusTitulo(){
		return Arrays.asList(StatusTitulo.values());
	}
}

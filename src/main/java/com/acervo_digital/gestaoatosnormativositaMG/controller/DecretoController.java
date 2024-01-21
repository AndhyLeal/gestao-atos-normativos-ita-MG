package com.acervo_digital.gestaoatosnormativositaMG.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.acervo_digital.gestaoatosnormativositaMG.entidades.Decreto;
import com.acervo_digital.gestaoatosnormativositaMG.repository.DecretoRepository;

@Controller
@RequestMapping("/")
public class DecretoController {
	@Autowired
	private DecretoRepository decretoRepository;

	@GetMapping("/administrativo")
	public ModelAndView listarDecretos(@RequestParam(name = "filtro", required = false) String filtro,
			@RequestParam(name = "termoPesquisa", required = false) String termoPesquisa) {
		System.out.println("Filtro: " + filtro);
		System.out.println("Termo de Pesquisa: " + termoPesquisa);

		List<Decreto> listaDecretos;

		if (filtro != null && termoPesquisa != null) {
			switch (filtro) {
			case "ano":
				listaDecretos = decretoRepository.findByAno(Integer.parseInt(termoPesquisa));
				break;
			case "numero":
				listaDecretos = decretoRepository.findByNumero(termoPesquisa);
				break;
			case "ementa":
				listaDecretos = decretoRepository.findByEmentaContaining(termoPesquisa);
				break;
			default:
				listaDecretos = decretoRepository.findAll();
			}
		} else {
			System.out.println("Os filtros estão nulos");
			listaDecretos = decretoRepository.findAll();
		}

		ModelAndView modelAndView = new ModelAndView("/administrativo/index");
		modelAndView.addObject("decretos", listaDecretos);

		return modelAndView;
	}
}

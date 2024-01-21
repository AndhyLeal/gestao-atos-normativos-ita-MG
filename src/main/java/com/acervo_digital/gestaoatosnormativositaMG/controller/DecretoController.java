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

	@GetMapping("/decretos")
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
				listaDecretos = decretoRepository.findByNumeroIgnoreCase(termoPesquisa);
				break;
			case "ementa":
				listaDecretos = decretoRepository.findByEmentaContainingIgnoreCase(termoPesquisa);
				break;
			case "palavras_chave":
				listaDecretos = decretoRepository.findByPalavrasChaveContainingIgnoreCase(termoPesquisa);
				break;
			case "etiqueta":
				listaDecretos = decretoRepository.findByEtiquetaContainingIgnoreCase(termoPesquisa);
				break;
			case "status":
				listaDecretos = decretoRepository.findByStatusIgnoreCase(termoPesquisa);
				break;
			default:
				listaDecretos = decretoRepository.findAll();
			}
		} else {
			System.out.println("Os filtros estão nulos");
			listaDecretos = decretoRepository.findAll();
		}

		ModelAndView modelAndView = new ModelAndView("/decretos/index");
		modelAndView.addObject("decretos", listaDecretos);

		return modelAndView;
	}

	@GetMapping("/home")
	public String home() {
		return "home/home";
	}

	@GetMapping("/administrativo")
	public String login_page() {
		return "administrativo/login_colaborador";
	}
}

package br.com.marcos.demoajax2.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import br.com.marcos.demoajax2.domain.Categoria;
import br.com.marcos.demoajax2.domain.Promocao;
import br.com.marcos.demoajax2.repository.CategoriaRepository;
import br.com.marcos.demoajax2.repository.PromocaoRepository;

@Controller
@RequestMapping("/promocao")
public class PromocaoController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private PromocaoRepository promocaoRepository;
	
	private static Logger log = LoggerFactory.getLogger(PromocaoController.class);
	
	@GetMapping("/add")
	public String abrirCadastro() {
		
		return "promo-add";
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> getCategorias() {
		return categoriaRepository.findAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<Promocao> salvarPromocao(Promocao promo){
		
		log.info("Promoção {}", promo.toString());
		promo.setDtCadastro(LocalDateTime.now());
		
		promocaoRepository.save(promo);
			System.out.println(promo.toString());
		return ResponseEntity.ok().build();
	}
}
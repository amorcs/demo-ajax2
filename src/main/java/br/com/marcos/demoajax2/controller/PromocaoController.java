package br.com.marcos.demoajax2.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	public ResponseEntity<?> salvarPromocao(@Valid Promocao promo, BindingResult result){
		
		if (result.hasErrors()) {
			Map<String, String> errors = new HashMap<String, String>();
			
			for (FieldError error : result.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}
			return ResponseEntity.unprocessableEntity().body(errors);
		}
		
		log.info("Promoção {}", promo.toString());
		promo.setDtCadastro(LocalDateTime.now());
		
		promocaoRepository.save(promo);
			System.out.println(promo.toString());
		return ResponseEntity.ok().build();
	}
}
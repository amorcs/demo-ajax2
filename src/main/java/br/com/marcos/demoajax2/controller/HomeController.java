package br.com.marcos.demoajax2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String promoAdd() {
		return "redirect:/promocao/add";
	}
}

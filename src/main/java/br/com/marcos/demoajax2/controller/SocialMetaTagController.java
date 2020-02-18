package br.com.marcos.demoajax2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.marcos.demoajax2.domain.SocialMetaTag;
import br.com.marcos.demoajax2.service.SocialMetaTagService;

@Controller
@RequestMapping("/meta")
public class SocialMetaTagController {
	
	@Autowired
	private SocialMetaTagService metaTagService;
	
	@PostMapping("/info")
	public ResponseEntity<SocialMetaTag> getDadosViaUrl(@RequestParam("url") String url){
		SocialMetaTag socialTagByUrl = metaTagService.getSocialTagByUrl(url);
		return socialTagByUrl != null 
				?ResponseEntity.ok(socialTagByUrl)
				:ResponseEntity.notFound().build();
	}
}

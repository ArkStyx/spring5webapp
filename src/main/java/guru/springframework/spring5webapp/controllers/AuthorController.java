package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.AuthorRepository;

@Controller
public class AuthorController {

	private final AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		super();
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		String nomAttributDansTemplateThymeleaf = "listeAuteurs";
		model.addAttribute(nomAttributDansTemplateThymeleaf, authorRepository.findAll());
		
		String nomRepertoireThymeleaf = "authors";
		String nomTemplateThymeleaf = "list";
		String modelPourRetour = nomRepertoireThymeleaf + "/" + nomTemplateThymeleaf;
		return modelPourRetour;
	}
	
	
}

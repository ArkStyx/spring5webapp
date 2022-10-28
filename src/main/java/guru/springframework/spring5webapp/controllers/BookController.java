package guru.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springframework.spring5webapp.repositories.BookRepository;

@Controller
public class BookController {

	private final BookRepository bookRepository;
	
	public BookController(BookRepository bookRepository) {
		super();
		this.bookRepository = bookRepository;
	}

	@RequestMapping("/books")
	public String getBooks(Model model) {
		String nomAttributDansTemplateThymeleaf = "listeLivres";
		model.addAttribute(nomAttributDansTemplateThymeleaf, bookRepository.findAll());
		
		String nomRepertoireThymeleaf = "books";
		String nomTemplateThymeleaf = "list";
		String modelPourRetour = nomRepertoireThymeleaf + "/" + nomTemplateThymeleaf;
		return modelPourRetour;
	}
}

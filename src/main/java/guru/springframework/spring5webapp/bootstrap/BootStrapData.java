package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Started in Spring CommandLineRunner");

		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Development", "123123");
		addAuthorAndBook(eric, ddd);
		
		System.out.println("01 - Number of authors saved : " + authorRepository.count());
		System.out.println("01 - Number of books saved : " + bookRepository.count());

		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE development without EJB", "39394594459");
		addAuthorAndBook(rod, noEJB);
		
		System.out.println("02 - Number of authors saved : " + authorRepository.count());
		System.out.println("02 - Number of books saved : " + bookRepository.count());
		
		Publisher ouinOuinPublishing = new Publisher("Ouin-ouin Publishing", "123 fancy street", "Miami", "Florida", "12345", "USA");
		addPublisherAndBook(ouinOuinPublishing, ddd);
		addPublisherAndBook(ouinOuinPublishing, noEJB);
		
		System.out.println("03 - Number of publishers saved : " + publisherRepository.count());
		System.out.println("03 - Number of books published saved : " + ouinOuinPublishing.getBooks().size());
	}

	private void addAuthorAndBook(Author author, Book book) {
		author.getBooks().add(book);
		authorRepository.save(author);
		
		book.getAuthors().add(author);
		bookRepository.save(book);
	}
	
	private void addPublisherAndBook(Publisher publisher, Book book) {
		publisher.getBooks().add(book);
		publisherRepository.save(publisher);
		
		book.setPublisher(publisher);
		bookRepository.save(book);
	}
	
}

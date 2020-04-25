package org.github.rakhmedovrs.spring5webapp.bootstrap;

import org.github.rakhmedovrs.spring5webapp.model.Author;
import org.github.rakhmedovrs.spring5webapp.model.Book;
import org.github.rakhmedovrs.spring5webapp.repositories.AuthorRepository;
import org.github.rakhmedovrs.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author RakhmedovRS
 * @created 25-Apr-20
 */
@Component
public class BootStrapData implements CommandLineRunner
{
	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;

	public BootStrapData(@Autowired AuthorRepository authorRepository, @Autowired BookRepository bookRepository)
	{
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void run(String... args) throws Exception
	{
		Author eric = new Author("Eric", "Evans");
		Book springForDummies = new Book("Spring for Dummies", "010010101101");
		eric.getBooks().add(springForDummies);
		springForDummies.getAuthors().add(eric);

		authorRepository.save(eric);
		bookRepository.save(springForDummies);

		Author rod = new Author("Rod", "Jonson");
		Book noEJB = new Book("J2EE Development without EJB", "111010101110");
		rod.getBooks().add(noEJB);
		noEJB.getAuthors().add(rod);

		authorRepository.save(rod);
		bookRepository.save(noEJB);

		System.out.println("Started in bootstrap");
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of authors: " + authorRepository.count());
	}
}

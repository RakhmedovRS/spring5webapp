package org.github.rakhmedovrs.spring5webapp.model;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import javax.persistence.*;

/**
 * @author RakhmedovRS
 * @created 25-Apr-20
 */
@Entity
public class Book
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String isbn;

	@ManyToMany
	@JoinTable(
		name = "author_to_book",
		joinColumns = @JoinColumn(name = "book_id"),
		inverseJoinColumns = @JoinColumn(name = "author_id"))
	private Set<Author> authors;

	public Book()
	{
	}

	public Book(String title, String isbn, Set<Author> authors)
	{
		this.title = title;
		this.isbn = isbn;
		this.authors = authors;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public Set<Author> getAuthors()
	{
		return authors;
	}

	public void setAuthors(Set<Author> authors)
	{
		this.authors = authors;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}

		Book book = (Book) o;

		return Objects.equals(id, book.id);
	}

	@Override
	public int hashCode()
	{
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
			.add("id=" + id)
			.add("title='" + title + "'")
			.add("isbn='" + isbn + "'")
			.add("authors=" + authors)
			.toString();
	}
}

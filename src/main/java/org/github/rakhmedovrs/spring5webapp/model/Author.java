package org.github.rakhmedovrs.spring5webapp.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import javax.persistence.*;

/**
 * @author RakhmedovRS
 * @created 25-Apr-20
 */
@Entity
public class Author
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy = "authors")
	private Set<Book> books;

	public Author()
	{
	}

	public Author(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.books = new HashSet<>();
	}

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public Set<Book> getBooks()
	{
		return books;
	}

	public void setBooks(Set<Book> books)
	{
		this.books = books;
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

		Author author = (Author) o;

		return Objects.equals(id, author.id);
	}

	@Override
	public int hashCode()
	{
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Author.class.getSimpleName() + "[", "]")
			.add("id=" + id)
			.add("firstName='" + firstName + "'")
			.add("lastName='" + lastName + "'")
			.toString();
	}
}

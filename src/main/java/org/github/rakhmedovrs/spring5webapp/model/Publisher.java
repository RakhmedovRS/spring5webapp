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
public class Publisher
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String address;
	private String city;
	private String state;
	private String zip;

	@OneToMany
	@JoinColumn(name = "publisher_id")
	private Set<Book> books;

	public Publisher()
	{
	}

	public Publisher(String name, String address, String city, String state, String zip)
	{
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZip()
	{
		return zip;
	}

	public void setZip(String zip)
	{
		this.zip = zip;
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

		Publisher publisher = (Publisher) o;

		return Objects.equals(id, publisher.id);
	}

	@Override
	public int hashCode()
	{
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public String toString()
	{
		return new StringJoiner(", ", Publisher.class.getSimpleName() + "[", "]")
			.add("id=" + id)
			.add("name='" + name + "'")
			.add("address='" + address + "'")
			.add("city='" + city + "'")
			.add("state='" + state + "'")
			.add("zip='" + zip + "'")
			.toString();
	}
}

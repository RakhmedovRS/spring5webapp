package org.github.rakhmedovrs.spring5webapp.repositories;

import org.github.rakhmedovrs.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author RakhmedovRS
 * @created 25-Apr-20
 */
public interface BookRepository extends CrudRepository<Book, Long>
{
}

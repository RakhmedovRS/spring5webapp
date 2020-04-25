package org.github.rakhmedovrs.spring5webapp.repositories;

import org.github.rakhmedovrs.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * @author RakhmedovRS
 * @created 25-Apr-20
 */
public interface AuthorRepository extends CrudRepository<Author, Long>
{
}

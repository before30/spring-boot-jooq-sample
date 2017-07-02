package cc.before30.sample.domain;

import cc.before30.sample.domain.entity.tables.pojos.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookService {

	@Transactional
	void create(int id, int authorId, String title);

	List<Book> findAll();

	Book findOne(int id);

}

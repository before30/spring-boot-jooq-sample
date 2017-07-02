package cc.before30.sample.domain;

import cc.before30.sample.domain.entity.Tables;
import cc.before30.sample.domain.entity.tables.pojos.Book;
import cc.before30.sample.domain.entity.tables.records.BookRecord;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static cc.before30.sample.domain.entity.Tables.BOOK;

@Service
@Slf4j
public class DefaultBookService implements BookService {

	@Autowired
    DSLContext dsl;

	@Override
	@Transactional
	public void create(int id, int authorId, String title) {

		for (int i=0; i<2; i++) {
			dsl.insertInto(BOOK)
					.set(BOOK.ID, id)
					.set(BOOK.AUTHOR_ID, authorId)
					.set(BOOK.TITLE, title)
					.execute();
		}
	}

	@Override
	public List<Book> findAll() {
		return dsl.selectFrom(Tables.BOOK)
				.fetch()
				.into(Book.class);
	}

	@Override
	public Book findOne(int id) {
		return dsl.selectFrom(Tables.BOOK)
				.where(Tables.BOOK.ID.eq(id))
				.fetchOne()
				.into(Book.class);
	}
}

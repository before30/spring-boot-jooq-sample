package cc.before30.sample.controller;

import cc.before30.sample.domain.BookService;
import cc.before30.sample.domain.entity.tables.pojos.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by before30 on 02/07/2017.
 */
@RestController
@Slf4j
public class BookStoreController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> allBooks() {
        return bookService.findAll();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") int id) {
        log.info("id is {}", id);
        return bookService.findOne(1);
    }

}

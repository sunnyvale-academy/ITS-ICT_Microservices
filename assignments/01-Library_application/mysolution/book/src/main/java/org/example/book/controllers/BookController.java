package org.example.book.controllers;

import lombok.extern.slf4j.Slf4j;
import org.example.book.exceptions.BookNotFoundException;
import org.example.book.models.Book;
import org.example.book.repos.BookRepository;
import org.example.book.services.TraceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/v2/books")
public class BookController {

    @Autowired
    TraceService traceService;

    @Autowired
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // CREATE
    @RequestMapping(method = RequestMethod.PUT)
    public Book addNewBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }


    // READ
    @RequestMapping(value = "/{bookId}", method = RequestMethod.GET)
    public Book getBook(@PathVariable String bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if(bookOptional.isPresent()){
            return bookOptional.get();
        }else{
            throw new BookNotFoundException();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Book> getAllBooks() {
        log.info("Get all books");
        return bookRepository.findAll();
    }


    // UPDATE
    @RequestMapping(value = "/{bookId}", method = RequestMethod.POST)
    public Book modifyBook(@RequestBody Book book, @RequestBody String bookId ) {
        return bookRepository.save(book);
    }


    // DELETE
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllBooks() {
        bookRepository.deleteAll();
    }

    @RequestMapping(value = "/{bookId}", method = RequestMethod.DELETE)
    public void deleteBook(@PathVariable String bookId) {
        bookRepository.deleteById(bookId);
    }
}



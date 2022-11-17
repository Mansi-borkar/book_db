package com.assignment.BookManager.controllers;

import com.assignment.BookManager.models.Book;

import com.assignment.BookManager.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/get-all-books")
    public List<Book> getAllBook() {
        List<Book> allBooklist = bookRepository.findAll();
        return allBooklist;

    }

    @GetMapping("/get-book/{id}")
    public Book getBookbyId(@PathVariable(value = "id") Integer bookId) {
        Book book = bookRepository.findById(bookId).get();

        return book;
    }

    @PostMapping("/create-books")
    public Book createBook(@RequestBody Book book) {

        Book savedBook = bookRepository.save(book);

        return savedBook;
    }

    @PutMapping("/update-books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable(value = "id") Integer employeeId,
                                           @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(employeeId).get();

        book.setBookName(bookDetails.getBookName());
        book.setAuthor(bookDetails.getAuthor());
        book.setPublishyear(bookDetails.getPublishyear());
        book.setDbupdatedate(bookDetails.getDbupdatedate());
        final Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);

    }

    @DeleteMapping("/delete-books/{id}")
    public Map<String, Boolean> deleteBook(@PathVariable(value = "id") Integer bookId) {
        Book book = bookRepository.findById(bookId).get();

        bookRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}

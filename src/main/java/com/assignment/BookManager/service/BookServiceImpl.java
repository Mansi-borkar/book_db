package com.assignment.BookManager.service;
import com.assignment.BookManager.models.Book;
import com.assignment.BookManager.repositories.BookRepository;
import com.sun.istack.FinalArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookbyId(Integer bookId) {
        Book book = bookRepository.getReferenceById(bookId);
        return book;
    }

    @Override
    public Book createBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book updateBook(Integer bookId, Book book) {
        if (bookRepository.existsById(bookId)){
            bookRepository.save(book);
        }
        return book;
    }

    @Override
    public void deleteBook(Integer bookId) {

        bookRepository.deleteById(bookId);;

    }
}

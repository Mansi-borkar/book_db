package com.assignment.BookManager.service;

import com.assignment.BookManager.models.Book;

import java.util.List;

public interface BookService {
    public List<Book> getBooks();
    public Book getBookbyId(Integer bookId);
    public Book createBook(Book book);
    public Book updateBook(Integer bookId, Book book);
    public void deleteBook(Integer bookId);
}

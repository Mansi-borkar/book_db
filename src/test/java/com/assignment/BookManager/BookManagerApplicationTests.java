package com.assignment.BookManager;

import com.assignment.BookManager.models.Book;
import com.assignment.BookManager.repositories.BookRepository;
import com.assignment.BookManager.service.BookService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookManagerApplicationTests {

    @MockBean
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    Book book;
    @Test
    public void testCreate() throws ParseException {
        book = new Book(24, "Wakanda Forever", "James", 2018, LocalDate.parse("2022-09-15"));
        when(bookRepository.save(book)).thenReturn(book);
        assertEquals(book,bookService.createBook(book));
    }

    @Test
    public void delete() {
        Integer bookId=24;
        bookService.deleteBook(bookId);
       verify(bookRepository,times(1)).deleteById(bookId);
    }

    @Test
    public void getBookById() {
        Integer bookId = 10;
        bookService.getBookbyId(bookId);
        verify(bookRepository,times(1)).getReferenceById(10);
    }

    @Test
    public void updateBook() {
        Integer bookId = 10;
        book = new Book(26, "Swami","Williams", 2022,LocalDate.parse("2022-11-22"));
        when(bookRepository.save(book)).thenReturn(book);
        assertEquals(book,bookService.updateBook(bookId, book));
    }

    @Test
    public void getAllBooks() {
        when(bookRepository.findAll()).thenReturn(Stream.of(new Book(26, "Swami","Williams", 2022,LocalDate.parse("2022-11-22")),
        new Book(27, "Hales","Samson", 2022,LocalDate.parse("2022-11-22"))).collect(Collectors.toList()));
        assertEquals(2,bookService.getBooks().size());
    }



}

package com.assignment.BookManager;

import com.assignment.BookManager.models.Book;
import com.assignment.BookManager.repositories.BookRepository;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookManagerApplicationTests {

    @Autowired
    BookRepository bookRepository;
    @Test
    @Order(1)
    public void testCreate() throws ParseException {
        Book b = new Book();
        String pattern = "yyyy-mm-dd";
        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat(pattern);
        Date d = simpleDateFormat.parse("2022-06-19");
        b.setBookId(14);
        b.setBookName("A Tale of Two Cities");
        b.setAuthor("Charles Darwin");
        b.setPublishyear(2019);
        b.setDbupdatedate(d);
        bookRepository.save(b);
        assertNotNull(bookRepository.findById(14).get());

    }

    @Test
    @Order(2)
    public void getAll() {
        List<Book> list = bookRepository.findAll();
        AssertionsForInterfaceTypes.assertThat(list).size().isGreaterThan(0);
    }

    @Test
    @Order(3)
    public void getById() {
        Book b = bookRepository.findById(14).get();
        assertEquals("A Tale of Two Cities", b.getBookName());
    }

    @Test
    @Order(4)
    public void update() {
        Book b = bookRepository.findById(14).get();
        b.setBookName("Oliver Twist");
        bookRepository.save(b);
        assertNotEquals("A Tale of Two Cities", bookRepository.findById(14).get().getBookName());
    }

    @Test
    @Order(5)
    public void delete() {
        bookRepository.deleteById(14);
        AssertionsForInterfaceTypes.assertThat(bookRepository.existsById(14)).isFalse();
    }

}

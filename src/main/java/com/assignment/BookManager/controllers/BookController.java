package com.assignment.BookManager.controllers;
import com.assignment.BookManager.models.Book;
import com.assignment.BookManager.service.BookService;
import com.assignment.BookManager.service.BookServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/get-all-books")
    public List<Book> getBooks() {
        return this.bookService.getBooks();
    }

    @GetMapping("/get-book/{id}")
    public Book getBookbyId(@PathVariable(value = "id") Integer bookId) {
        return this.bookService.getBookbyId(bookId);
    }

    @PostMapping("/create-books")
    public Book createBook(@RequestBody Book book) {
        return this.bookService.createBook(book);
    }

    @PutMapping("/update-books/{id}")
    public Book updateBook(@PathVariable Integer bookId,@RequestBody Book book){
        Book existingBook = bookService.getBookbyId(bookId);
        BeanUtils.copyProperties(book,existingBook,"bookId");
        return bookService.updateBook(bookId,existingBook);
    }
    @DeleteMapping("/delete-books/{id}")
    public ResponseEntity<HttpStatus> deleteBook(@PathVariable(value = "id") Integer bookId) {
        try {
            this.bookService.deleteBook(bookId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

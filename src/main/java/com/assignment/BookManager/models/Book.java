package com.assignment.BookManager.models;

import com.assignment.BookManager.repositories.BookRepository;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "book")
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(name = "book_name", nullable = false)
    private String bookName;

    @Column(name = "book_author", nullable = false)
    private String author;

    @Column(name = "publish_year", nullable = false)
    private Integer publishyear;

    @Column(name = "db_update_date", nullable = false)
    private Date dbupdatedate;

    public Book() {

    }

    public Book(Integer bookId,String bookName, String author, Integer publishyear, Date dbupdatedate) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.publishyear = publishyear;
        this.dbupdatedate = dbupdatedate;

    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {

        this.bookId = bookId;
    }

    public String getBookName() {

        return bookName;
    }

    public void setBookName(String bookName) {

        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public Integer getPublishyear() {

        return publishyear;
    }

    public void setPublishyear(Integer publishyear) {

        this.publishyear = publishyear;
    }

    public Date getDbupdatedate() {
        return dbupdatedate;
    }

    public void setDbupdatedate(Date dbupdatedate) {
        this.dbupdatedate = dbupdatedate;
    }

    public String toString() {
        return "Employee [BookId=" + bookId + ", BookName=" + bookName + ", Author=" + author + ", PublishYear=" + publishyear
                + ", DbUpdateDate=" + dbupdatedate + "]";
    }
}

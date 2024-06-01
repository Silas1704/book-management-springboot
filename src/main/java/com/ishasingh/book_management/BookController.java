package com.ishasingh.book_management;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping
    public List<Book> getAllBook(){
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id){
        return bookService.findById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book){
        return bookService.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id ,@RequestBody Book book){
        return bookService.save(book);

    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long bookid){
        bookService.deleteById(bookid);
    }

    @PostMapping("/{bookid}/borrow/{userid}")
    public ResponseEntity<Book> borrowBook(@PathVariable Long bookId,@PathVariable Long userID){
        Book borrowedBook =bookService.borrowBook(bookId,userID);
        if (borrowedBook!=null){
            return ResponseEntity.ok(borrowedBook);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{bookid}/return")
    public ResponseEntity<Book> returnBook(@PathVariable Long bookid){
        Book returnedBook=bookService.returnBook(bookid);
        if (returnedBook!=null){
            return ResponseEntity.ok(returnedBook);
        }else {
            return ResponseEntity.badRequest().build();
        }
    }
}

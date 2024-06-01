package com.ishasingh.book_management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public Book findById(Long id){
        return bookRepository.findById(id).orElse(null);

    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }

    public Book borrowBook(Long Bookid ,Long userID){
        Book book=findById(Bookid);
        User user =userRepository.findById(userID).orElse(null);

        if (book!=null && !book.isBorrowed() && user!=null){
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        return null;
    }


    public Book returnBook(Long Bookid){
        Book book=findById(Bookid);
        if (book!=null && book.isBorrowed()){
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }
        return null;
    }


}

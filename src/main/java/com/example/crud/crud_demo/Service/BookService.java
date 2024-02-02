package com.example.crud.crud_demo.Service;

import com.example.crud.crud_demo.Model.BookModel;
import com.example.crud.crud_demo.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;
    public BookModel createBook(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    public BookModel getBook(Long id) {
        return bookRepository.findById(id).get();
    }


    public BookModel updateModel(BookModel bookModelBody, Long id) {
        return bookRepository.findById(id)
                .map(existingBookModel -> {
                    if (bookModelBody.getTitle() != null) existingBookModel.setTitle(bookModelBody.getTitle());
                    if (bookModelBody.getAuthor() != null) existingBookModel.setAuthor(bookModelBody.getAuthor());
                    return bookRepository.save(existingBookModel);
                })
                .orElse(null);
    }


    public String deleteBook(Long id) {
        return "book with " + id + " has been deleted";
    }
}

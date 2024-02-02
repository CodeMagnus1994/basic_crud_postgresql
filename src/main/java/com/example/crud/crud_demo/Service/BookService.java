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


    public BookModel updateModel(BookModel BookModelBody, Long id) {

        Optional<BookModel> existingBookModelOptional = bookRepository.findById(id);

        if(existingBookModelOptional.isPresent()) {

            BookModel updatedBookModel = existingBookModelOptional.get();

            if(BookModelBody.getTitle() != null)
                updatedBookModel.setTitle(BookModelBody.getTitle());

            if(BookModelBody.getAuthor() != null)
                updatedBookModel.setAuthor(BookModelBody.getAuthor());

            return bookRepository.save(updatedBookModel);
        } else {
            return null;
        }
    }

    public String deleteBook(Long id) {
        return "book with " + id + " has been deleted";
    }
}

package com.example.crud.crud_demo.Controller;

import com.example.crud.crud_demo.Model.BookModel;
import com.example.crud.crud_demo.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book/create")
    public BookModel createBook(@RequestBody BookModel bookModel) {
        return bookService.createBook(bookModel);
    }

    @GetMapping("/book/get/{id}")
    public BookModel getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PutMapping("/book/update/{id}")
    public BookModel updateBook(@RequestBody BookModel bookModel, @PathVariable Long id) {
        return bookService.updateModel(bookModel, id);
    }

    @DeleteMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        return bookService.deleteBook(id);
    }

}

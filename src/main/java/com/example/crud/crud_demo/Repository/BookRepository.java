package com.example.crud.crud_demo.Repository;

import com.example.crud.crud_demo.Model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {



}

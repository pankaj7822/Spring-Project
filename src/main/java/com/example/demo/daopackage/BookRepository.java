package com.example.demo.daopackage;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Book;
@Repository
public interface BookRepository extends CrudRepository<Book,Long> {
}
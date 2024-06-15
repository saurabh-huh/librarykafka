package com.speingboot.bookService.repository;

import com.speingboot.bookService.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface BookRepository extends MongoRepository<Book, UUID> {
}

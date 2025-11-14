package io.github.aplaraujo.repository;

import io.github.aplaraujo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

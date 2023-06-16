package by.ghoncharko.project1alish.repository;

import by.ghoncharko.project1alish.entity.Book;
import by.ghoncharko.project1alish.entity.Human;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface BookRepository {
    List<Book> getAll();

    boolean deleteById(Long id);

    boolean updateById(Long id, String name, String author, String year, Human human);

    Optional<Book> getById(Long id);

    boolean add(String name, String author, String year, Human human);
}

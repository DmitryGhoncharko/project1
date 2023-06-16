package by.ghoncharko.project1alish.repository;

import by.ghoncharko.project1alish.entity.Book;
import by.ghoncharko.project1alish.entity.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SimpleBookRepository implements BookRepository{
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper bookMapper;
    @Autowired
    public SimpleBookRepository(JdbcTemplate jdbcTemplate, RowMapper bookMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Book> getAll() {
        return jdbcTemplate.query("select book_id, book_name, book_author, book_year, h.human_id, h.human_name, h.human_year from book " +
                "inner join human h on book.human_id = h.human_id",bookMapper);
    }

    @Override
    public boolean deleteById(Long id) {
        return jdbcTemplate.update("delete from book where  book_id = ?",id)>0;
    }

    @Override
    public boolean updateById(Long id, String name, String author, String year, Human human) {
        return jdbcTemplate.update("update book set book_name= ?, book_author=?, book_year=?, human_id = ? where book_id = ?",name,author,year,human.getId(),id)>0;
    }

    @Override
    public Optional<Book> getById(Long id) {
        return Optional.of((Book) jdbcTemplate.queryForObject("select book_id, book_name, book_author, book_year, h.human_id, h.human_name, h.human_year from book " +
                "inner join human h on book.human_id = h.human_id",new Object[]{id},bookMapper));
    }

    @Override
    public boolean add(String name, String author, String year, Human human) {
        return jdbcTemplate.update("insert into book(book_name, book_author,book_year,human_id) values (?,?,?,?)",name,author,year,human.getId())>0;
    }
}

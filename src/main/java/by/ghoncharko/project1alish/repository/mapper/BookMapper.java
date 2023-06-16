package by.ghoncharko.project1alish.repository.mapper;

import by.ghoncharko.project1alish.entity.Book;
import by.ghoncharko.project1alish.entity.Human;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class BookMapper implements RowMapper<Book> {


    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        while (rs.next()){
            return Book.builder().
                    id(rs.getLong("id")).
                    name(rs.getString("book_name")).
                    author(rs.getString("book_author")).
                    year(rs.getString("book_year")).
                    human(Human.builder().
                            id(rs.getLong("h.human_id")).
                            firstName(rs.getString("h.human_name")).
                            yearBorn(rs.getString("h.human_year")).
                            build()).
                    build();
        }
        return null;
    }
}

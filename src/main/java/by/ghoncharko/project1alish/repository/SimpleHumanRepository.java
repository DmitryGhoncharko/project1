package by.ghoncharko.project1alish.repository;

import by.ghoncharko.project1alish.entity.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SimpleHumanRepository implements HumanRepository {
    private final JdbcTemplate jdbcTemplate;

    private final RowMapper humanMapper;

    @Autowired
    public SimpleHumanRepository(JdbcTemplate jdbcTemplate, RowMapper humanMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.humanMapper = humanMapper;
    }

    @Override
    public List<Human> getAll() {
        return jdbcTemplate.query("select human_id, human_name, human_year from human", humanMapper);
    }

    @Override
    public Optional<Human> getById(Long id) {
        return Optional.of((Human) jdbcTemplate.queryForObject("select human_id, human_name, human_year from human where human_id = ?", new Object[]{id}, humanMapper));
    }

    @Override
    public boolean deleteById(Long id) {
        return jdbcTemplate.update("delete  from human where human_id = ?", id) > 0;
    }

    @Override
    public boolean updateById(Long id, String firstName, String yearOfBorn) {
        return jdbcTemplate.update("update human set human_name = ?, human_year = ? where human_id = ?", firstName, yearOfBorn, id) > 0;
    }

    @Override
    public boolean add(String firstName, String yearOfBorn) {
        return jdbcTemplate.update("insert into  human(human_name,human_year) values (?,?)",firstName,yearOfBorn)>0;
    }

    @Override
    public Optional<Human> getByName(String name) {
        return Optional.of((Human) jdbcTemplate.queryForObject("select human_id, human_name, human_year from human where human_name = ?", new Object[]{name}, humanMapper));
    }
}

package by.ghoncharko.project1alish.repository.mapper;

import by.ghoncharko.project1alish.entity.Human;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class HumanMapper implements RowMapper<Human> {
    @Override
    public Human mapRow(ResultSet rs, int rowNum) throws SQLException {
        if(rs.next()){
            return Human.builder().
                    id(rs.getLong("human_id")).
                    firstName(rs.getString("human_name")).
                    yearBorn(rs.getString("human_year")).
                    build();
        }
        return null;
    }
}

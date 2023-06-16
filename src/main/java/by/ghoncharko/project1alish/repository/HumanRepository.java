package by.ghoncharko.project1alish.repository;

import by.ghoncharko.project1alish.entity.Human;

import java.util.List;
import java.util.Optional;

public interface HumanRepository {
    List<Human> getAll();

    Optional<Human> getById(Long id);

    boolean deleteById(Long id);

    boolean updateById(Long id, String firstName, String yearOfBorn);

    boolean add(String firstName, String yearOfBorn);

    Optional<Human> getByName(String name);
}

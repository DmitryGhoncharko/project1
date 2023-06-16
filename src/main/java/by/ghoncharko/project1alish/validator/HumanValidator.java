package by.ghoncharko.project1alish.validator;

import by.ghoncharko.project1alish.entity.Human;
import by.ghoncharko.project1alish.repository.HumanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class HumanValidator implements Validator {
    private final HumanRepository humanRepository;
    @Autowired
    public HumanValidator(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Human.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Human human = (Human) target;
        if(humanRepository.getByName(human.getFirstName()).isPresent()){
            errors.rejectValue("name","","Пользователь с таким именем уже существует");
        }
    }
}

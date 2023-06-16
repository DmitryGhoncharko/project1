package by.ghoncharko.project1alish.controller;

import by.ghoncharko.project1alish.entity.Human;
import by.ghoncharko.project1alish.repository.HumanRepository;
import by.ghoncharko.project1alish.validator.HumanValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/human")
public class HumanController {
    private final HumanRepository humanRepository;
    private final HumanValidator humanValidator;
    @Autowired
    public HumanController(HumanRepository humanRepository,HumanValidator humanValidator) {
        this.humanRepository = humanRepository;
        this.humanValidator = humanValidator;
    }
    @GetMapping("/add")
    public String showAddHumanPage(){
        return "addHuman.html";
    }
    @PostMapping("/add")
    public String addHuman(@ModelAttribute("human") @Valid Human human, BindingResult bindingResult){
        humanValidator.validate(human,bindingResult);
        if(bindingResult.hasErrors()){
            return "redirect:/human/add";
        }
        humanRepository.add(human.getFirstName(),human.getYearBorn());
        return "redirect:/human";
    }
    @GetMapping
    public String showAllHumansPage(Model model){
        List<Human> humans = humanRepository.getAll();
        model.addAttribute("humans",humans);
        return "humans.html";
    }
}

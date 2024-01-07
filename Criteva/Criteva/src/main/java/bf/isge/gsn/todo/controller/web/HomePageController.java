package bf.isge.gsn.todo.controller.web;

import bf.isge.gsn.todo.dao.TutorialRepository;
import bf.isge.gsn.todo.model.entities.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    private TutorialRepository tutorialRepository;

    @GetMapping({ "/", "/index" })
    public String getAll(Model model, @Param("keyword") String keyword) {
        try {
            List<Tutorial> tutorials = new ArrayList<Tutorial>();

            if (keyword == null) {
                tutorialRepository.findAll().forEach(tutorials::add);
            } else {
                tutorialRepository.findByTitleContainingIgnoreCase(keyword).forEach(tutorials::add);
                model.addAttribute("keyword", keyword);
            }

            model.addAttribute("tutorials", tutorials);
        } catch (Exception e) {
            model.addAttribute("message", e.getMessage());
        }

        return "index";
    }
}

package bf.isge.gsn.todo.controller.web;

import bf.isge.gsn.todo.dao.TutorialRepository;
import bf.isge.gsn.todo.model.dto.CreateTodoDTO;
import bf.isge.gsn.todo.model.entities.Evaluation;
import bf.isge.gsn.todo.model.entities.Todo;
import bf.isge.gsn.todo.model.entities.Tutorial;
import bf.isge.gsn.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoPageController {


    @Autowired
    private TutorialRepository tutorialRepository;
    private final TodoService todoService;
    public TodoPageController(TodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping("/todoList" )
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

        return "todoList";
    }

    @GetMapping("/todoList/new/{id_critere}")
    public String addEvaluation(@PathVariable("id_critere") Integer id_critere, Model model) {
        Evaluation evaluation = new Evaluation();
        evaluation.setIdCritere(id_critere);
        model.addAttribute("evaluation", evaluation);
        model.addAttribute("pageTitle", "Nouvelle evaluer du critère {ID : " + id_critere + "}");
        return "evaluation_form";
    }

    @GetMapping("/createTodo" )
    public String showCreateTod(Model model) {
        CreateTodoDTO todoForm = new CreateTodoDTO();
        model.addAttribute("todoForm", todoForm);
        return "createTodo";
    }
    @PostMapping("/createTodo")
    public String saveTodo(Model model,@ModelAttribute("todoForm") CreateTodoDTO todoForm) {
        String title = todoForm.getTitle();
        String description = todoForm.getDescription();
        if(title == null || title.isBlank()) {
            model.addAttribute("errorMessage", "Le title est requis");
            return "createTodo";
        }
        if(description == null || description.isBlank()) {
            model.addAttribute("errorMessage", "La description est requise");
            return "createTodo";
        }
        Todo todo = new Todo();
        todo.setArchived(false);
        todo.setTitle(todoForm.getTitle());
        todo.setDescription(todoForm.getDescription());
        todoService.create(todo);
        return "redirect:/todoList";
    }
}

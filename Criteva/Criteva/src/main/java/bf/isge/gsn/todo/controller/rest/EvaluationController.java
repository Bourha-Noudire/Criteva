package bf.isge.gsn.todo.controller.rest;

import bf.isge.gsn.todo.dao.EvaluationRepository;
import bf.isge.gsn.todo.model.entities.Evaluation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EvaluationController {

  @Autowired
  private EvaluationRepository evaluationRepository;
/*
  @GetMapping("/evaluation")
  public String getAll(Model model, @Param("keyword") String keyword) {
    try {
      List<Evaluation> evaluation = new ArrayList<Evaluation>();

      if (keyword == null) {
        evaluationRepository.findAll().forEach(evaluation::add);
      } else {
        evaluationRepository.findByTitleContainingIgnoreCase(keyword).forEach(evaluation::add);
        model.addAttribute("keyword", keyword);
      }

      model.addAttribute("evaluation", evaluation);
    } catch (Exception e) {
      model.addAttribute("message", e.getMessage());
    }

    return "evaluation";
  }*/

  @GetMapping("/evaluation/new")
  public String addEvaluation(Model model) {
    Evaluation evaluation = new Evaluation();
    model.addAttribute("evaluation", evaluation);
    model.addAttribute("pageTitle", "Creer un nouveau cirtère");
    return "evaluation_form";
  }

  @PostMapping("/evaluation/save")
  public String saveEvaluation(Evaluation evaluation, RedirectAttributes redirectAttributes) {
    try {
      evaluationRepository.save(evaluation);
      redirectAttributes.addFlashAttribute("message", "Critère évalué avec succès !!!");
    } catch (Exception e) {
      redirectAttributes.addAttribute("message", e.getMessage());
    }
    return "redirect:/todoList";
  }


}

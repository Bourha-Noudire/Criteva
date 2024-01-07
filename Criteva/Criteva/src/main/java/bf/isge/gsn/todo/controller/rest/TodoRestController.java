package bf.isge.gsn.todo.controller.rest;

import bf.isge.gsn.todo.dao.TutorialRepository;
import bf.isge.gsn.todo.model.dto.CreateTodoDTO;
import bf.isge.gsn.todo.model.dto.TodoDTO;
import bf.isge.gsn.todo.model.entities.Todo;
import bf.isge.gsn.todo.model.entities.Tutorial;
import bf.isge.gsn.todo.model.entities.User;
import bf.isge.gsn.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/todos")
public class TodoRestController {
    private TodoService todoService;
    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping()
    public Todo createTodo(@RequestBody CreateTodoDTO createTodoRequest) {
        System.out.println(createTodoRequest);
        Todo todo = new Todo();
        todo.setArchived(false);
        todo.setTitle(createTodoRequest.getTitle());
        todo.setDescription(createTodoRequest.getDescription());
        User author = new User();
        author.setId(createTodoRequest.getAuthorId());
        todo.setAuthor(author);
        return todoService.create(todo);
    }

    @GetMapping()
    public List<TodoDTO> findAllTodo() {
        System.out.println("Find all todos");
        return todoService.findAll().stream().map(
                todo -> TodoDTO.builder()
                        .title(todo.getTitle())
                        .description(todo.getDescription())
                        .archived(todo.isArchived())
                        .createdAt(todo.getCreatedAt())
                        .author(todo.getAuthor())
                        .id(todo.getId())
                        .build()
        ).collect(Collectors.toList());
    }

    @DeleteMapping("{id}")
    public void deleteTodo(@PathVariable int id) {
        System.out.println("Deleting todo with id " + id);
        todoService.deleteById(id);
    }

}

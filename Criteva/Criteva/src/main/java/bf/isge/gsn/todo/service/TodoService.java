package bf.isge.gsn.todo.service;

import bf.isge.gsn.todo.model.entities.Todo;

import java.util.List;

public interface TodoService {
    Todo create(Todo createTodoRequest);
    List<Todo> findAll();
    void deleteById(int id);
}

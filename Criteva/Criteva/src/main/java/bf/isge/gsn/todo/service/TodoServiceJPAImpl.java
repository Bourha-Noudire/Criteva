package bf.isge.gsn.todo.service;

import bf.isge.gsn.todo.dao.TodoRepository;
import bf.isge.gsn.todo.model.entities.Todo;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceJPAImpl implements TodoService{
    private TodoRepository todoRepository;
    public TodoServiceJPAImpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo create(Todo createTodoRequest) {
        return todoRepository.save(createTodoRequest);
    }

    @Override
    public List<Todo> findAll() {
        return Streamable.of(todoRepository.findAll()).toList();
    }

    @Override
    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }
}

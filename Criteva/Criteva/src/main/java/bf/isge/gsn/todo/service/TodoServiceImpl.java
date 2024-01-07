package bf.isge.gsn.todo.service;

import bf.isge.gsn.todo.model.entities.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TodoServiceImpl implements TodoService{
    // id, todo
    Map<Integer, Todo> todoStore = new HashMap<>();
    // 1 --> todo1
    // 2 --> todo2
    // ...
    @Override
    public Todo create(Todo createTodoRequest) {
        Todo todo = new Todo();
        todo.setCreatedAt(LocalDate.now());
        todo.setId(todoStore.size()+1);
        todo.setArchived(false);
        todo.setTitle(createTodoRequest.getTitle());
        todo.setDescription(createTodoRequest.getDescription());
        todo.setAuthor(createTodoRequest.getAuthor());
        return todoStore.put(todo.getId(), todo);
    }

    @Override
    public List<Todo> findAll() {
        return new ArrayList<>(todoStore.values());
    }

    @Override
    public void deleteById(int key) {
        if(!todoStore.containsKey(key)){
            throw new RuntimeException("Trying to delete unexisting todo");
        }
        todoStore.remove(key);
    }
}

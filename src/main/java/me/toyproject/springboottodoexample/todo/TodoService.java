package me.toyproject.springboottodoexample.todo;


import me.toyproject.springboottodoexample.todo.dto.NewTodo;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createNewTodo(NewTodo newTodo) {
        Todo todo = new Todo(newTodo.getTask());
        return todoRepository.save(todo);
    }
}

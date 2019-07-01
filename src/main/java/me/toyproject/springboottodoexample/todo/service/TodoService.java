package me.toyproject.springboottodoexample.todo.service;

import me.toyproject.springboottodoexample.todo.dao.TodoRepository;
import me.toyproject.springboottodoexample.todo.domain.Todo;
import me.toyproject.springboottodoexample.todo.dto.TodoRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createNewTodo(TodoRequest todoRequest) {
        Todo todo = new Todo(todoRequest.getTask());
        return todoRepository.save(todo);
    }

    public List<Todo> findAll() {
        return todoRepository.findAll();
    }
}

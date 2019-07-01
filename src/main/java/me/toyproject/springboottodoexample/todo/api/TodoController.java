package me.toyproject.springboottodoexample.todo.api;


import lombok.RequiredArgsConstructor;
import me.toyproject.springboottodoexample.todo.domain.Todo;
import me.toyproject.springboottodoexample.todo.dto.TodoRequest;
import me.toyproject.springboottodoexample.todo.dto.TodoResponse;
import me.toyproject.springboottodoexample.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TodoController {

    private TodoService service;

    @GetMapping("")
    public String test() {
        return "";
    }

    @PostMapping("todo_list")
    public ResponseEntity saveTodo(@RequestBody TodoRequest newTodo) {
        Todo todo = service.createNewTodo(newTodo);
        return new ResponseEntity<>(new TodoResponse(todo), HttpStatus.CREATED);
    }

    @GetMapping("todo_list")
    public ResponseEntity findAll() {
        List<Todo> todoList = service.findAll();
        List<TodoResponse> todoResponses = todoList.stream()
                .map(TodoResponse::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(todoResponses, HttpStatus.OK);
    }
}

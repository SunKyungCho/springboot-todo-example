package me.toyproject.springboottodoexample.todo;


import me.toyproject.springboottodoexample.todo.dto.NewTodo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @Autowired
    TodoService service;

    @RequestMapping("/todolist")
    public ResponseEntity saveTodo(NewTodo todo) {
        Todo newTodo = service.createNewTodo(todo);
        return ResponseEntity.;
    }

}

package me.toyproject.springboottodoexample.todo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.toyproject.springboottodoexample.todo.domain.Todo;

@Getter
@Setter
@NoArgsConstructor
public class TodoResponse {

    private String task;
    private boolean isDone;

    public TodoResponse(Todo todo) {
        this.task = todo.getTask();
    }
}

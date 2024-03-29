package me.toyproject.springboottodoexample.domain.todo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TodoRequest {
    private String task;

    public TodoRequest(String task) {
        this.task = task;
    }
}

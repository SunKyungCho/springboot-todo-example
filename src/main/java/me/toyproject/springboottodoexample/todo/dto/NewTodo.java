package me.toyproject.springboottodoexample.todo.dto;

import lombok.Getter;

@Getter
public class NewTodo {
    private String task;

    public NewTodo(String task) {
        this.task = task;
    }
}

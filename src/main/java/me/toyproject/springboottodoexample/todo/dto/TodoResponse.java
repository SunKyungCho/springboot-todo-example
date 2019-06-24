package me.toyproject.springboottodoexample.todo.dto;


import lombok.Getter;

@Getter
public class TodoResponse {

    private String task;
    private String isDone;

    public TodoResponse(String task, String isDone) {
        this.task = task;
        this.isDone = isDone;
    }
}

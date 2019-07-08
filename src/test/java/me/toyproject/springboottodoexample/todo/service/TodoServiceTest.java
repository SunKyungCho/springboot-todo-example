package me.toyproject.springboottodoexample.todo.service;

import me.toyproject.springboottodoexample.todo.domain.Todo;
import me.toyproject.springboottodoexample.todo.dto.TodoRequest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
class TodoServiceTest {

    @Autowired
    private TodoService todoService;

    @Test
    public void addTask() {
        // Given
        TodoRequest todoRequest = new TodoRequest("hellow");

        // When
        Todo addedTodo = todoService.createNewTodo(todoRequest);

        // Then
        assertThat(todoRequest.getTask()).isEqualTo(addedTodo.getTask());
    }
}
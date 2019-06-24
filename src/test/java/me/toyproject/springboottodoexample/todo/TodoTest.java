package me.toyproject.springboottodoexample.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TodoTest {

    private Todo todo;

    @BeforeEach
    void setUp() {
        todo = new Todo("test");
    }

    @Test
    @DisplayName("Todo의 기본값")
    public void todoTest() {
        assertThat(todo.isDone()).isFalse();
    }

    @Test
    @DisplayName("Todo 처리 완료")
    public void doneTodo() {
        todo.done();
        assertThat(todo.isDone()).isTrue();
    }
}

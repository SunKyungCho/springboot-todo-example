package me.toyproject.springboottodoexample.domain.todo.dao;

import me.toyproject.springboottodoexample.domain.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

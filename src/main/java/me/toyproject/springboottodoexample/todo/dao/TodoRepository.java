package me.toyproject.springboottodoexample.todo.dao;

import me.toyproject.springboottodoexample.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}

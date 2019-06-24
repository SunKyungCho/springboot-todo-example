package me.toyproject.springboottodoexample.todo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "task")
    private String task;

    @Column(name = "done")
    private boolean isDone;

    @CreationTimestamp
    @Column(name = "creat_at", updatable = false)
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at")
    private LocalDateTime updateAt;

    public Todo(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public Todo done() {
        this.isDone = true;
        return this;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", isDone=" + isDone +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }
}

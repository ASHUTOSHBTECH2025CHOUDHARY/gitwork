package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    
    private List<Todo> todos = new ArrayList<>();
    private AtomicLong counter = new AtomicLong();

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        todo.setId(counter.incrementAndGet());
        todos.add(todo);
        return todo;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todos;
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todos.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public boolean deleteTodo(@PathVariable Long id) {
        return todos.removeIf(todo -> todo.getId().equals(id));
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        for (Todo todo : todos) {
            if (todo.getId().equals(id)) {
                todo.setTitle(updatedTodo.getTitle());
                todo.setDescription(updatedTodo.getDescription());
                todo.setCompleted(updatedTodo.isCompleted());
                return todo;
            }
        }
        return null;
    }
}

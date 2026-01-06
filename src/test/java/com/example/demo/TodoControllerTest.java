package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TodoControllerTest {

    private TodoController controller;

    @BeforeEach
    public void setUp() {
        controller = new TodoController();
    }

    @Test
    public void testCreateTodo() {
        Todo todo = new Todo();
        todo.setTitle("Test");
        todo.setDescription("Test Description");
        
        Todo created = controller.createTodo(todo);
        
        assertNotNull(created.getId());
        assertEquals("Test", created.getTitle());
    }

    @Test
    public void testGetAllTodos() {
        Todo todo1 = new Todo();
        todo1.setTitle("Todo 1");
        controller.createTodo(todo1);
        
        List<Todo> todos = controller.getAllTodos();
        
        assertEquals(1, todos.size());
    }

    @Test
    public void testGetTodoById() {
        Todo todo = new Todo();
        todo.setTitle("Test");
        Todo created = controller.createTodo(todo);
        
        Todo found = controller.getTodoById(created.getId());
        
        assertNotNull(found);
        assertEquals(created.getId(), found.getId());
    }

    @Test
    public void testDeleteTodo() {
        Todo todo = new Todo();
        todo.setTitle("Test");
        Todo created = controller.createTodo(todo);
        
        boolean deleted = controller.deleteTodo(created.getId());
        
        assertTrue(deleted);
        assertNull(controller.getTodoById(created.getId()));
    }

    @Test
    public void testUpdateTodo() {
        Todo todo = new Todo();
        todo.setTitle("Original");
        Todo created = controller.createTodo(todo);
        
        Todo updated = new Todo();
        updated.setTitle("Updated");
        updated.setDescription("New Description");
        updated.setCompleted(true);
        
        Todo result = controller.updateTodo(created.getId(), updated);
        
        assertNotNull(result);
        assertEquals("Updated", result.getTitle());
        assertEquals("New Description", result.getDescription());
        assertTrue(result.isCompleted());
    }
}

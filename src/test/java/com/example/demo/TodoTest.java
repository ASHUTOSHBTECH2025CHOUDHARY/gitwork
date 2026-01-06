package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodoTest {

    @Test
    public void testTodoCreation() {
        Todo todo = new Todo(1L, "Test", "Description");
        assertEquals(1L, todo.getId());
        assertEquals("Test", todo.getTitle());
        assertEquals("Description", todo.getDescription());
        assertFalse(todo.isCompleted());
    }

    @Test
    public void testSetters() {
        Todo todo = new Todo();
        todo.setId(2L);
        todo.setTitle("New Title");
        todo.setDescription("New Description");
        todo.setCompleted(true);
        
        assertEquals(2L, todo.getId());
        assertEquals("New Title", todo.getTitle());
        assertEquals("New Description", todo.getDescription());
        assertTrue(todo.isCompleted());
    }
}

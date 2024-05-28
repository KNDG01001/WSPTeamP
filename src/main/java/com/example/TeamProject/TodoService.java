package com.example.TeamProject;

import java.util.List;

public interface TodoService {
    int count();
    Todo getTodoById(int id);
    List<Todo> getTodo();
    Todo deleteTodoById(int id);
}

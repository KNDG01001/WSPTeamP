package com.example.TeamProject;

import java.util.List;

public interface TodoDAO {
    int count();
    Todo getTodoById(int id);
    List<Todo> getTodo();
    Todo deleteTodoById();
}

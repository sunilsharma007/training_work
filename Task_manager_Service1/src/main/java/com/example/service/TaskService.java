package com.example.service;

import java.util.List;

import com.example.model.Task;

public interface TaskService {
    public List<Task> getTasks();
    public void createTask(Task tasks);
    public Task getTask(int taskId);
    public void deleteTask(int taskId);
}

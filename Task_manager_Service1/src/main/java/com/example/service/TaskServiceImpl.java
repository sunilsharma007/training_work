package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.TaskDAO;
import com.example.model.Task;

import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService {
    private TaskDAO taskDAO;

    public TaskServiceImpl() {
    }

    @Autowired
    public TaskServiceImpl(TaskDAO todoDAO) {
        this.taskDAO = taskDAO;
    }

    @Override
    public List<Task> getTasks() {
        return taskDAO.getTasks();
    }

    @Override
    public void createTask(Task tasks) {
        taskDAO.createTask(tasks);
    }

    @Override
    public Task getTask(int taskId) {
       return taskDAO.getTask(taskId);
    }

    @Override
    public void deleteTask(int taskId) {
        taskDAO.deleteTask(taskId);

    }


}

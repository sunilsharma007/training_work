package com.example.controller;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.example.model.Task;
import com.example.service.TaskService;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskManagerController {
    private TaskService taskService;

    public TaskManagerController(TaskService taskService) {
        this.taskService = taskService;
    }
    @RequestMapping("/listTask")
    public String listTask(Model model) {
        model.addAttribute("task", taskService.getTasks());
        return "task-list";

    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/showFormForAdd")
    public String showFormForAdd(Model model)
    {
        model.addAttribute("task",new Task());
        return "task-form";
    }

    @RequestMapping("/saveTask")
    public String saveCustomer(@Valid @ModelAttribute("task") Task tasks,
                               BindingResult theBindingResult)
    {

        if (theBindingResult.hasErrors()) {
            return "task-form";
        } else {
            taskService.createTask(tasks);
            return "redirect:/task/listTask";
        }

    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("taskId") int theId,
                                    Model theModel) {

        Task theTasks = taskService.getTask(theId);

        theModel.addAttribute("task", theTasks);

        return "task-form";
    }
    @RequestMapping("/updateTask")
    public String updateCustomer(@ModelAttribute("task") Task tasks)
    {
        taskService.createTask(tasks);
        return "redirect:/task/listTask";
    }
    @RequestMapping("/delete")
    public String delete(@RequestParam("taskId") int taskId)
    {
        taskService.deleteTask(taskId);
        return "redirect:/task/listTask";
    }

}

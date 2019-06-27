package com.annascibska.tasks.demo.controller;

import com.annascibska.tasks.demo.model.Task;
import com.annascibska.tasks.demo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @GetMapping
    public Set<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping ("/done")
    public Set<Task> getDoneTasks() {
        return taskService.getDoneTasks();
    }

    @GetMapping ("/{id}")
    public Task getTaskById(@PathVariable("id") int id) {
        return taskService.getTaskById(id);
    }

    @GetMapping ("/{id}/description")
    public String getDescriptionById(@PathVariable("id") int id) {
        return taskService.getTaskById(id).getDescription();
    }

    @DeleteMapping ("/{id}")
    public String deleteTaskById(@PathVariable("id") int id) {
        boolean isDeleted = taskService.deleteTaskById(id);
        if (isDeleted) {
            return "Task number: " + id + " was deleted";
        } else {
            return "Task doesn't exist";
        }
    }
}

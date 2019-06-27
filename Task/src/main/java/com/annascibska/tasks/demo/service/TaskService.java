package com.annascibska.tasks.demo.service;

import com.annascibska.tasks.demo.model.Task;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Service
public class TaskService {

    private Set<Task> data;

    @PostConstruct
    public void init() {
        data = new HashSet<>();
        boolean done = false;
        for (int i=0; i<10; i++) {
            Task task = new Task();
            task.setId(i);
            task.setName("task" + i);
            task.setDescription("Description of Task" + i);
            done = !done;
            task.setDone(done);
            data.add(task);
        }
    }

    public void addTask(Task task) { data.add(task); }

    public Set<Task> getTasks() {
        return data;
    }

    public Set<Task> getDoneTasks() {
        HashSet<Task> doneList = new HashSet<>();
        data.stream().filter(u -> u.isDone() == true).forEach(item -> doneList.add(item));
        return doneList;
    }

    public Task getTaskById(int id) {
        return data.stream().filter(u -> u.getId() == id).findFirst().orElse(null);
    }

    public boolean deleteTaskById (int id) {
        return data.removeIf(u -> u.getId() == id);
    }
}

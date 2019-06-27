package com.annascibska.tasks.demo.model;

import org.springframework.stereotype.Component;

@Component
public class Task {

    private int id;
    private String name;
    private String description;
    private boolean done;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() { return description; }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isDone() { return done; }
}

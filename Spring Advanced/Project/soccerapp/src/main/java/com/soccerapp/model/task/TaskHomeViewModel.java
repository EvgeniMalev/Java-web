// app/src/main/java/com/soccerapp/model/dto/task/TaskHomeViewModel.java
package com.soccerapp.model.dto.task;

import java.util.List;

public class TaskHomeViewModel {
    private String username;
    private List<TaskViewModel> tasks;
    public TaskHomeViewModel() {
    }

    public TaskHomeViewModel(String username, List<TaskViewModel> tasks) {
        this.username = username;
        this.tasks = tasks;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<TaskViewModel> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskViewModel> tasks) {
        this.tasks = tasks;
    }
}

class TaskViewModel {
    private String title;
    private String description;
    private boolean completed;

    public TaskViewModel() {
    }

    public TaskViewModel(String title, String description, boolean completed) {
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

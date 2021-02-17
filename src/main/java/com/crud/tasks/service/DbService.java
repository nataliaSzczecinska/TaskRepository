package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@AllArgsConstructor
public class DbService {

    private final TaskRepository repository;

    /*public DbService(TaskRepository repository) {
        this.repository = repository;
    }*/

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task getTask(Long taskId) {
        return repository.findById(taskId);
    }

}
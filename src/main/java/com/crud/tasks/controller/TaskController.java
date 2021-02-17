package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/v1/task")
@RequiredArgsConstructor
public class TaskController {

    private final DbService dbService;
    private final TaskMapper taskMapper;

    /*@Autowired
    public TaskController(DbService dbService, TaskMapper taskMapper) {
        this.dbService = dbService;
        this.taskMapper = taskMapper;
    } zastępuje @RequiredArgsConstructor*/

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    public List<TaskDto> getTasks() {
        List<Task> tasks = dbService.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }

    @GetMapping(value = "getTask/{TaskId}")
    public TaskDto getTask(@PathVariable("TaskId") Long taskId) {
        Task task = dbService.getTask(taskId);
        return taskMapper.mapToTaskDto(task);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask/{TaskId}")
    //@DeleteMapping(value = "deleteTask/{TaskId}")
    public void deleteTask(@PathVariable("TaskId") Long taskId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask/{TaskId}")
    //@PutMapping(value = "updateTask/{TaskId}")
    public TaskDto updateTask(@PathVariable("TaskId") TaskDto taskDto) {
        return new TaskDto(1L, "Edited test title", "Test content");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTask")
    //@PostMapping(value = "createTask")
    public void createTask(TaskDto taskDto) {

    }
}

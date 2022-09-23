package com.turksat.StoryPointScoring.controllers;

import com.turksat.StoryPointScoring.entitys.Task;
import com.turksat.StoryPointScoring.entitys.TaskDTO;
import com.turksat.StoryPointScoring.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {this.taskService = taskService;}


    @GetMapping
    public List<Task> getTask(){
        return taskService.getTask();
    }

    @PostMapping
    public void RegisterTask(@RequestBody TaskDTO task) {
        taskService.addNewTask(task);
    }

    @DeleteMapping(path = "{taskId}")
    public void DeleteTask(@PathVariable("taskId") Integer taskId){
        taskService.deleteTask(taskId);
    }

    @PutMapping(path = "{taskId}")
    public void UpdateTask(
            @PathVariable("taskId") Integer taskId,
            @RequestParam(required = false) String name,String members, String storyPoints){
        taskService.updateTask(taskId,name,members,storyPoints);
    }

}

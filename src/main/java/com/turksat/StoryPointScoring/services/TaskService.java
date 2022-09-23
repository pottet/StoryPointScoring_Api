package com.turksat.StoryPointScoring.services;

import com.turksat.StoryPointScoring.entitys.Task;
import com.turksat.StoryPointScoring.entitys.TaskDTO;
import com.turksat.StoryPointScoring.repostoriy.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskService {
 private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {this.taskRepository = taskRepository;}

    public List<Task> getTask(){ return taskRepository.findAll();}

    public void addNewTask(TaskDTO task) {
        Optional<Task> taskOptional = taskRepository.findTaskByName(task.getName());

        if (taskOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        for(String member: task.getMember()) {
            for (String storyPoint : task.getStoryPoints()) {
                Task data = new Task(
                        task.getName(),
                        member,
                        storyPoint
                );
                taskRepository.save(data);
            }
        }
    }

    public void deleteTask(Integer taskId) {
        //Optional<Task> studentOptional = studentRepository.deleteStudentById(studentId);
        boolean exist = taskRepository.existsById(taskId);
        if (!exist){
            throw new IllegalStateException("this task does not exist!");
        }
        taskRepository.deleteById(taskId);
    }

    @Transactional
    public void updateTask(Integer taskId, String name, String member, String storyPoint) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new IllegalStateException(
                "task with id"+ taskId + "does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(task.getName(),name)){
            task.setName(name);
        }
        if (member != null && member.length() > 0 && !Objects.equals(task.getMembers(),member)){
            Optional<Task> taskOptional = taskRepository.findTaskByMembers (member);

            if (taskOptional.isPresent()) {
                throw new IllegalStateException("this member already exist");
            }
        }
        task.setMembers(member);

        if (storyPoint != null && storyPoint.length() > 0 && !Objects.equals(task.getStoryPoints(),storyPoint)){
            Optional<Task> taskOptional = taskRepository.findTaskByStoryPoints (storyPoint);

            if (taskOptional.isPresent()) {
                throw new IllegalStateException("this storypoints already exist");
            }
        }
        task.setStoryPoints(storyPoint);

    }



}

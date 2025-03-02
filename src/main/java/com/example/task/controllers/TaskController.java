package com.example.task.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.task.entities.Task;
import com.example.task.services.TaskService;


@CrossOrigin  //Para que React o Angular puedan consultar sin problemas
@RestController()
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    //Control GET    
    @GetMapping("")
    public List<Task> tasks(){
        return this.taskService.getRepository();
    }

    //Control POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Task crTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    //Control PUT
    @PutMapping("{id}")
    public Task upTask(@RequestBody Task task, @PathVariable Long id){
        return this.taskService.updateTask(task, id);
    }

    //Control DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public String delTask(@PathVariable Long id){
        this.taskService.deleteTask(id);
        return "Registro eliminado con éxito.";
    }
}

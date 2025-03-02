package com.example.task.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.task.entities.Task;
import com.example.task.repositories.TaskRepository;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    //Almacenamos en el repositorio
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    //Servicio GET
    public List<Task> getRepository(){
        return this.taskRepository.findAll();
    }

    //Servicio POST
    public Task createTask(Task task){
        return this.taskRepository.save(task);
    }

    //Servicio PUT
    public Task updateTask(Task task, Long id){
        Task taskFromDb = taskRepository
            .findById(id)
            .orElseThrow(RuntimeException::new);
        taskFromDb.setNombre(task.getNombre());
        taskFromDb.setHecho(task.isHecho());

        return taskRepository.save(taskFromDb);
    }

    //Servicio DELETE
    public void deleteTask(Long id){
        Task taskFromDb = taskRepository
            .findById(id)
            .orElseThrow(RuntimeException::new);
        
        taskRepository.delete(taskFromDb);        
    }



}

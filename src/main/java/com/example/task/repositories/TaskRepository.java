package com.example.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.task.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}

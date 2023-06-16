package com.todoList2.controller;


import com.todoList2.persistance.entity.Task;
import com.todoList2.persistance.entity.TaskStatus;
import com.todoList2.service.DTO.TaskinDTO;
import com.todoList2.service.TaskService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class controller {

    private final TaskService taskService;

    public controller(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskinDTO taskinDTO){
        return this.taskService.createTask(taskinDTO);
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByStatus(@PathVariable("status")TaskStatus status){
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/marcar_Como_Finalizada/{id}")
    public ResponseEntity<Void> marcarFinal(@Param("id") Integer id){
        this.taskService.marcarTareaFinalizada(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> Borrar(@Param("id") Integer id){
        this.taskService.BorrarTarea(id);
        return ResponseEntity.noContent().build();
    }

}

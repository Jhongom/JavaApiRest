package com.todoList2.service;


import com.todoList2.exceptions.todoExceptions;
import com.todoList2.mapper.TaskinDTOtoTask;
import com.todoList2.persistance.entity.TaskStatus;
import com.todoList2.persistance.repository.ITaskRepository;
import com.todoList2.service.DTO.TaskinDTO;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.todoList2.persistance.entity.Task;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final ITaskRepository taskRepository;
    private final TaskinDTOtoTask mapper;

    public TaskService(ITaskRepository taskRepository, TaskinDTOtoTask mapper) { //Inyeccion sin @Autowired para test
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public Task createTask(TaskinDTO taskinDTO){
        Task task = mapper.map(taskinDTO);
        return this.taskRepository.save(task);
    }

    public List<Task> findAll(){
        return this.taskRepository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status){
        return this.taskRepository.findAllByEstadoTarea(status);
    }

    @Transactional
    public void marcarTareaFinalizada(Integer id){
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new todoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.MarcarFinalizada(id);
    }

    public void BorrarTarea(Integer id){
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new todoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);
    }


}

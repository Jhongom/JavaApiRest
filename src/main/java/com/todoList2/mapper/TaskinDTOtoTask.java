package com.todoList2.mapper;

import com.todoList2.persistance.entity.TaskStatus;
import com.todoList2.service.DTO.TaskinDTO;
import com.todoList2.persistance.entity.Task;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskinDTOtoTask implements IMapper<TaskinDTO , Task>{

    @Override
    public Task map(TaskinDTO in) {
        Task task = new Task();
        task.setTitulo(in.getTitulo());
        task.setDescripcion(in.getDescripcion());
        task.setFecha(LocalDateTime.now());
        task.setFinalizada(false);
        task.setEstadoTarea(TaskStatus.A_Tiempo);
        task.setDiasAsignados(in.getDiasAsignados());
        return task;
    }
}

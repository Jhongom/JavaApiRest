package com.todoList2.persistance.repository;

import com.todoList2.persistance.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import com.todoList2.persistance.entity.Task;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITaskRepository extends JpaRepository<Task, Integer> {

    public List<Task> findAllByEstadoTarea(TaskStatus status);

    @Modifying
    @Query(value = "update tarea set finalizada= true where ID=:id", nativeQuery = true)
    public void MarcarFinalizada(@Param("id") Integer id);
}

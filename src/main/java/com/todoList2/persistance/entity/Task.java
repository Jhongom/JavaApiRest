package com.todoList2.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity //etiqueta para que las varialbes sean llevadas a una SQL DB
@Table(name = "tarea")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titulo;
    private String Descripcion;
    private LocalDateTime fecha;
    private Integer DiasAsignados;
    private Boolean Finalizada;
    private TaskStatus estadoTarea;

}

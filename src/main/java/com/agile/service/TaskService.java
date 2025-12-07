package com.agile.service;

import com.agile.domain.Task;
import com.agile.domain.Task.TaskStatus;
import com.agile.repository.TaskRepository;
import java.util.UUID;

public class TaskService {

    private final TaskRepository taskRepository;

    // Injeção de Dependência via Construtor
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void completeTask(UUID taskId) {
        // 1. Busca
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new IllegalArgumentException("Tarefa não encontrada: " + taskId));

        // 2. Regra de Negócio (Transformação Imutável)
        Task completedTask = task.withStatus(TaskStatus.DONE);

        // 3. Persistência
        taskRepository.save(completedTask);

        System.out.println("Tarefa " + taskId + " atualizada para DONE.");
    }
}
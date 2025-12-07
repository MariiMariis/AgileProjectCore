package com.agile.repository;

import com.agile.domain.Task;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

// Esta classe IMPLEMENTA o contrato definido na Interface.
public class InMemoryTaskRepository implements TaskRepository {

    // Um "banco de dados" simples na memória
    private final Map<UUID, Task> database = new HashMap<>();

    @Override
    public void save(Task task) {
        database.put(task.getId(), task);
        System.out.println("[DB] Tarefa guardada: " + task.getTitle());
    }

    @Override
    public Optional<Task> findById(UUID id) {
        return Optional.ofNullable(database.get(id));
    }
}
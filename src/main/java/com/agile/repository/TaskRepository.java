package com.agile.repository;

import com.agile.domain.Task;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository {
    void save(Task task);
    Optional<Task> findById(UUID id);
}
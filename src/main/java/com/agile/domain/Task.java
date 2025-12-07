package com.agile.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public final class Task {

    private final UUID id;
    private final String title;
    private final String description;
    private final TaskStatus status;
    private final UUID assigneeId;
    private final LocalDateTime createdAt;

    // Construtor Principal
    public Task(UUID id, String title, String description, TaskStatus status, UUID assigneeId, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "ID não pode ser nulo");
        this.title = Objects.requireNonNull(title, "Título não pode ser nulo");
        this.description = description != null ? description : "";
        this.status = status != null ? status : TaskStatus.TODO;
        this.assigneeId = assigneeId;
        this.createdAt = createdAt != null ? createdAt : LocalDateTime.now();
    }

    // Construtor de Conveniência
    public Task(String title, String description) {
        this(UUID.randomUUID(), title, description, TaskStatus.TODO, null, LocalDateTime.now());
    }

    // --- Métodos Wither (Imutabilidade: retornam nova instância) ---

    public Task withStatus(TaskStatus newStatus) {
        if (this.status == newStatus) return this;
        return new Task(this.id, this.title, this.description, newStatus, this.assigneeId, this.createdAt);
    }

    public Task withAssignee(UUID newAssigneeId) {
        return new Task(this.id, this.title, this.description, this.status, newAssigneeId, this.createdAt);
    }

    // --- Getters ---

    public UUID getId() { return id; }
    public String getTitle() { return title; }
    public TaskStatus getStatus() { return status; }
    public String getDescription() { return description; }
    public UUID getAssigneeId() { return assigneeId; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // Enum interno para simplificar
    public enum TaskStatus {
        TODO, IN_PROGRESS, DONE
    }
}
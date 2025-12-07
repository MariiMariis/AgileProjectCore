package com.agile.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Sprint {
    private final UUID id;
    private final String name;
    private final List<Task> tasks;
    private final boolean isClosed;

    public Sprint(UUID id, String name, List<Task> tasks, boolean isClosed) {
        this.id = id;
        this.name = name;
        // Cópia defensiva: garante que ninguém mude a lista de fora
        this.tasks = tasks == null ? List.of() : List.copyOf(tasks);
        this.isClosed = isClosed;
    }

    // Construtor auxiliar
    public Sprint(String name) {
        this(UUID.randomUUID(), name, List.of(), false);
    }

    // Cálculo puro (sem mudar estado)
    public double calculateProgressPercentage() {
        if (tasks.isEmpty()) return 0.0;
        long completed = tasks.stream()
                .filter(t -> t.getStatus() == Task.TaskStatus.DONE)
                .count();
        return (double) completed / tasks.size() * 100.0;
    }

    // Ação que muda estado (Retorna nova Sprint)
    public Sprint closeSprint() {
        return new Sprint(this.id, this.name, this.tasks, true);
    }

    // Adicionar tarefa (Retorna nova Sprint)
    public Sprint addTask(Task task) {
        if (isClosed) {
            throw new IllegalStateException("Não é possível adicionar tarefas a uma Sprint fechada.");
        }
        List<Task> newTaskList = new ArrayList<>(this.tasks);
        newTaskList.add(task);
        return new Sprint(this.id, this.name, newTaskList, this.isClosed);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public boolean isClosed() { return isClosed; }
    public String getName() { return name; }
}
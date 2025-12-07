package com.agile;

import com.agile.domain.Task;
import com.agile.repository.InMemoryTaskRepository;
import com.agile.service.TaskService;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== A iniciar Sistema de Gestão Ágil ===");

        // 1. Preparar as Dependências (Dependency Injection manual)
        // Criamos o repositório (banco de dados em memória)
        InMemoryTaskRepository repository = new InMemoryTaskRepository();

        // Criamos o serviço e passamos o repositório para ele
        TaskService service = new TaskService(repository);

        // 2. Simular o Uso do Sistema
        System.out.println("\n--- Passo 1: Criar uma Tarefa ---");
        Task novaTarefa = new Task("Aprender SOLID", "Estudar os 5 princípios de design");

        // Guardar a tarefa inicial (simulando persistência)
        repository.save(novaTarefa);

        // 3. Executar Lógica de Negócio
        System.out.println("\n--- Passo 2: Completar a Tarefa ---");
        // O serviço vai buscar a tarefa, mudar o status para DONE e guardar novamente
        service.completeTask(novaTarefa.getId());

        // 4. Verificação
        System.out.println("\n=== Sistema executado com sucesso ===");
    }
}
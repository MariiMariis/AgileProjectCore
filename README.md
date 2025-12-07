# 🚀 Agile Project Core

![Java](https://img.shields.io/badge/Java-17%2B-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Status](https://img.shields.io/badge/Status-Completed-success?style=for-the-badge)
![License](https://img.shields.io/badge/License-MIT-blue?style=for-the-badge)
![Clean Code](https://img.shields.io/badge/Pattern-Clean%20Code-green?style=for-the-badge)

> **"Software é para pessoas."** > Uma implementação de referência de um Sistema de Gestão Ágil focado em Arquitetura Limpa, Princípios SOLID e Design Orientado ao Domínio (DDD), sem a "mágica" de frameworks.

---

## 📖 Sobre o Projeto

Este projeto não é apenas um gerenciador de tarefas; é um estudo de caso sobre **Engenharia de Software Disciplinada**. O objetivo foi construir o núcleo de um sistema complexo utilizando apenas Java Puro, demonstrando como decisões arquiteturais afetam a manutenibilidade e a robustez do código.

Aqui, a **Imutabilidade** não é uma sugestão, é a lei. E a **Injeção de Dependência** é feita manualmente para demonstrar o real significado de desacoplamento.

---

## 🏗️ Arquitetura e Decisões de Design

O sistema foi modelado seguindo estritamente os princípios de design de software:

### 1. Imutabilidade Estrita (Domain Safety)
Entidades como `Task` e `Sprint` são imutáveis. Não existem *Setters*. Qualquer alteração de estado resulta em uma nova instância, eliminando *Race Conditions* e efeitos colaterais indesejados em ambientes concorrentes.

### 2. Rich Domain Model vs. Anemic Model
Evitamos o antipadrão de "Modelo Anêmico" (classes que são apenas sacos de dados). Nossas classes contêm regras de negócio e validações intrínsecas.
* **Exemplo:** `StoryPoint` é um *Value Object* que se autovalida, impedindo pontuações negativas no sistema.

### 3. Clean Architecture (Camadas)
O código está organizado para proteger o domínio da infraestrutura:
* `com.agile.domain`: O coração puro (sem dependências externas).
* `com.agile.service`: Casos de uso e regras de fluxo.
* `com.agile.repository`: Contratos (Interfaces) para persistência.

### 4. Tipagem Forte e Defensiva
* **Dinheiro:** Uso de `BigDecimal` para evitar erros de ponto flutuante.
* **Datas:** Uso de `LocalDateTime` (API moderna do Java).
* **Coleções:** Listas expostas são imutáveis (`List.copyOf`), prevenindo modificações externas acidentais.

---

## 📂 Estrutura do Projeto

A organização de pacotes reflete a separação de responsabilidades:

```text
src/main/java/com/agile
├── domain          # Entidades Centrais (Task, Sprint, User)
│   └── vo          # Value Objects (StoryPoint)
├── repository      # Interfaces (Contratos de Persistência) e Impl em Memória
├── service         # Regras de Negócio e Casos de Uso
└── Main.java       # Ponto de entrada e Injeção de Dependência Manual

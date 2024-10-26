package com.uniasselvi.to_do_list_API.model;

/**
 * Enumeração que representa os diferentes status de uma tarefa.
 * As enumerações são úteis para restringir um conjunto de valores possíveis
 * que uma variável pode ter, garantindo mais segurança e legibilidade.
 */
public enum TaskStatus {
    TODO,   // Tarefa pendente a ser iniciada
    DOING,  // Tarefa em progresso
    DONE;   // Tarefa concluída
}

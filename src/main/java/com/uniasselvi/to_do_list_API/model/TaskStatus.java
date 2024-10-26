/*
Enumeração que representa os diferentes status de uma tarefa.
As enumerações restringem um conjunto de valores possíveis que uma variável pode ter,
garantindo mais segurança e legibilidade.
*/
package com.uniasselvi.to_do_list_API.model;






public enum TaskStatus {
    TODO,   // Tarefa pendente a ser iniciada
    DOING,  // Tarefa em progresso
    DONE;   // Tarefa concluída
}

package com.uniasselvi.to_do_list_API.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // Importação para ignorar propriedades desconhecidas durante a serialização
import jakarta.persistence.*; // Importação das anotações JPA
import lombok.AllArgsConstructor; // Importação para gerar construtor com todos os parâmetros
import lombok.Builder; // Importação para permitir a construção da classe de forma fluente
import lombok.Data; // Importação para gerar métodos getters, setters e outros automaticamente
import lombok.NoArgsConstructor; // Importação para gerar construtor sem parâmetros

import java.io.Serializable; // Importação para permitir que a classe seja serializável

/**
 * Classe que representa uma tarefa no sistema.
 * A classe implementa Serializable para permitir a conversão em byte-stream,
 * facilitando a transmissão e persistência de objetos.
 */
@Builder
@Data
@NoArgsConstructor // Gera um construtor sem parâmetros
@AllArgsConstructor // Gera um construtor com todos os parâmetros
@JsonIgnoreProperties(ignoreUnknown = true) // Ignora propriedades desconhecidas durante a serialização/deserialização
@Entity // Indica que a classe é uma entidade JPA
@Table(name = "tasks") // Define o nome da tabela no banco de dados
public class Task implements Serializable {

    @Id // Indica que este campo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o valor automaticamente (auto-incremento)
    private Long id; // Identificador único da tarefa

    @Column(nullable = false) // Define que este campo não pode ser nulo
    private String title; // Título da tarefa

    @Column(columnDefinition = "TEXT") // Define o tipo do banco de dados como TEXT para permitir longas descrições
    private String description; // Descrição detalhada da tarefa

    @Enumerated(EnumType.STRING) // Define que o valor do enum será armazenado como uma String no banco de dados
    @Column(nullable = false) // Define que este campo não pode ser nulo
    private TaskStatus status; // Status da tarefa (ex: TODO, DOING, DONE)

    @ManyToOne // Define um relacionamento muitos-para-um com a classe User
    @JoinColumn(name = "user_id", nullable = false) // Define a coluna que será usada para o relacionamento e que não pode ser nula
    private User user; // Usuário associado à tarefa
}

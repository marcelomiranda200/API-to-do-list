package com.uniasselvi.to_do_list_API.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties; // Importação para ignorar propriedades desconhecidas durante a serialização
import jakarta.persistence.*; // Importação das anotações JPA
import lombok.AllArgsConstructor; // Importação para gerar construtor com todos os parâmetros
import lombok.Builder; // Importação para permitir a construção da classe de forma fluente
import lombok.Data; // Importação para gerar métodos getters, setters e outros automaticamente
import lombok.NoArgsConstructor; // Importação para gerar construtor sem parâmetros

import java.io.Serializable; // Importação para permitir que a classe seja serializável
import java.time.LocalDateTime; // Importação para manipulação de datas e horas

/**
 * Classe que representa um usuário no sistema.
 * A classe implementa Serializable para permitir a conversão em byte-stream,
 * facilitando a transmissão e persistência de objetos.
 */
@Builder
@Data
@NoArgsConstructor // Gera um construtor sem parâmetros
@AllArgsConstructor // Gera um construtor com todos os parâmetros
@JsonIgnoreProperties(ignoreUnknown = true) // Ignora propriedades desconhecidas durante a serialização/deserialização
@Entity // Indica que a classe é uma entidade JPA
@Table(name = "users") // Define o nome da tabela no banco de dados
public class User implements Serializable {

    @Id // Indica que este campo é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o valor automaticamente (auto-incremento)
    private Long id; // Identificador único do usuário

    @Column(nullable = false) // Define que este campo não pode ser nulo
    private String name; // Nome do usuário

    @Column(nullable = false, unique = true) // Define que este campo não pode ser nulo e deve ser único
    private String email; // Email do usuário

    @Column(nullable = false) // Define que este campo não pode ser nulo
    private String password; // Senha do usuário

    @Column(name = "creation_date", nullable = false, updatable = false) // Define que este campo não pode ser nulo e não pode ser atualizado após a criação
    private LocalDateTime creationDate = LocalDateTime.now(); // Data e hora de criação do usuário, inicializada com a data atual
}

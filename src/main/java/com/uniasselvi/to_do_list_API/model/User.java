/*
 * Das linhas 11 a 19, temos:
 * Importação para ignorar propriedades desconhecidas durante a serialização
 * Importação das anotações JPA
 * Importação para gerar construtor com todos os parâmetros e sem parâmetros
 * Importação para permitir a construção da classe de forma fluente
 * Importação para gerar métodos getters, setters e outros automaticamente
 * Importação para permitir que a classe seja serializável
 * Importação para manipulação de datas e horas
 */
package com.uniasselvi.to_do_list_API.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDateTime;















/**
 * Das linhas 44 em diante, temos:
 * Classe que representa um usuário no sistema.
 * Implementa Serializable para facilitar transmissão e persistência de objetos.
 * Utiliza Lombok para geração de construtores e métodos automáticos.
 * Anotada como @Entity e @Table para mapeamento JPA.
 * Contém campos obrigatórios como nome, email (único) e senha.
 * Armazena a data de criação do usuário, não atualizável após a criação.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "creation_date", nullable = false, updatable = false)
    private LocalDateTime creationDate = LocalDateTime.now();
}

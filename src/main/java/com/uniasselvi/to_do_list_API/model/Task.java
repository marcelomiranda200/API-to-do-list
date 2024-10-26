/* Das linhas 6 a 13, temos a Importação para ignorar propriedades desconhecidas durante a serialização. Importação das
anotações JPA, Importação para gerar construtor com todos os parâmetros, Importação para permitir a construção da classe
de forma fluente, Importação para gerar métodos getters, setters e outros automaticamente, Importação para gerar
construtor sem parâmetros e a Importação para permitir que a classe seja serializável
*/
package com.uniasselvi.to_do_list_API.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;





















/**
 * Das linhas 41 em diante, temos a Classe que representa uma tarefa no sistema.
 * Implementa Serializable para facilitar transmissão e persistência de objetos.
 * Utiliza Lombok para geração de construtores e métodos automáticos.
 * Anotada como @Entity e @Table para mapeamento JPA.
 * Inclui relacionamento muitos-para-um com a classe User.
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}






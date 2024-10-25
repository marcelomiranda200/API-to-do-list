package br.com.uniasselvi.to_do_list.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "task_history")
public class TaskHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Task.Status status;

    @Column(name = "changed_at", updatable = false)
    private LocalDateTime changedAt;

    @PrePersist
    protected void onCreate() {
        changedAt = LocalDateTime.now();
    }

    // Métodos de conversão (opcional, se necessário para outras partes do código)
    @Transient
    public String getStatusAsString() {
        return status != null ? status.name() : null;
    }

    @Transient
    public void setStatusFromString(String status) {
        this.status = status != null ? Task.Status.valueOf(status) : null;
    }

    // Enum Status
    public enum Status {
        IN_PROGRESS,
        COMPLETED
    }
}

package isel.sisinf.model.entities;

import jakarta.persistence.*;
import lombok.Data;

/// /////////
@Data
@Entity
@Table(name = "STATION")
@NamedQuery(
        name = "Estacao.findByKey",
        query = "SELECT e FROM Estacao e WHERE e.id = :id"
)
public class Estacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 6, scale = 4, nullable = false)
    private Double latitude;

    @Column(precision = 6, scale = 4, nullable = false)
    private Double longitude;
}
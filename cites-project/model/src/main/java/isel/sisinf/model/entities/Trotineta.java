package isel.sisinf.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SCOOTER")
@NamedQuery(
        name = "Trotineta.findByKey",
        query = "SELECT t FROM Trotineta t WHERE t.id = :id"
)
public class Trotineta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, precision = 4, scale = 2)
    private Double weight;

    @Column(nullable = false, precision = 4, scale = 2)
    private Double maxvelocity;

    @Column(nullable = false)
    private Integer battery;

    @ManyToOne(optional = false)
    @JoinColumn(name = "model", referencedColumnName = "number")
    private Modelo modelo;
}
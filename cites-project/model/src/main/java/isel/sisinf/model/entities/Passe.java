package isel.sisinf.model.entities;

import jakarta.persistence.*;
import lombok.Data;

/////////////////
@Data
@Entity
@Table(name = "CARD")
@NamedQuery(
        name = "Passe.findByKey",
        query = "SELECT p FROM Passe p WHERE p.id = :id"
)
public class Passe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 4, scale = 2)
    private Double credit;

    @ManyToOne
    @JoinColumn(name = "typeofcard", referencedColumnName = "reference")
    private TipoDePasse typeofcard;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "person")
    private Utilizador client;
}
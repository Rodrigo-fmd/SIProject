package isel.sisinf.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DOCK")
@NamedQuery(
        name = "Doca.findByKey",
        query = "SELECT d FROM Doca d WHERE d.number = :number"
)
@NamedQuery(
        name = "Doca.findAll",
        query = "SELECT d FROM Doca d"
)
public class Doca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @ManyToOne(optional = false)
    @JoinColumn(name = "station", referencedColumnName = "id")
    private Estacao station;

    @Column(nullable = false, length = 30)
    private String state;

    @ManyToOne
    @JoinColumn(name = "scooter", referencedColumnName = "id")
    private Trotineta scooter;

    @Column
    private java.sql.Timestamp version;
}
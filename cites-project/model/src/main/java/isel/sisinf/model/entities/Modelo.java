package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IModel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SCOOTERMODEL")
@NamedQuery(
        name = "Modelo.findByKey",
        query = "SELECT m FROM Modelo m WHERE m.number = :number"
)
public class Modelo implements IModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @Column(nullable = false, length = 30)
    private String designation;

    @Column(nullable = false)
    private int autonomy;
}
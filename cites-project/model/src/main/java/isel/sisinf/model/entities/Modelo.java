package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IModel;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@NamedQuery(
        name = "Modelo.findByKey",
        query = "SELECT m FROM Modelo m WHERE m.id = :id"
)
public class Modelo implements IModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private int autonomiaFabrica;
}
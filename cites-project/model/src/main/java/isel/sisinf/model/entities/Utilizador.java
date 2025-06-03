package isel.sisinf.model.entities;

import jakarta.persistence.*;
import lombok.Data;

/////////////////////////
@Data
@Entity
@Table(name = "PERSON")
@NamedQuery(
        name = "Utilizador.findByKey",
        query = "SELECT u FROM Utilizador u WHERE u.id = :id"
)
public class Utilizador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40, unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private Integer taxnumber;

    @Column(length = 50, nullable = false)
    private String name;
}
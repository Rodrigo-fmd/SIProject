package isel.sisinf.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE")
@NamedQuery(
        name = "Funcionario.findByKey",
        query = "SELECT f FROM Funcionario f WHERE f.person.id = :personId"
)
public class Funcionario {
    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "person", referencedColumnName = "id")
    private Utilizador person;

    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;
}
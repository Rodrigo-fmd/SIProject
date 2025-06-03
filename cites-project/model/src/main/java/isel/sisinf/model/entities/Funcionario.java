package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IFuncionario;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEE")
@NamedQuery(
        name = "Funcionario.findByKey",
        query = "SELECT f FROM Funcionario f WHERE f.person.id = :personId"
)
public class Funcionario implements IFuncionario {
    @Id
    @Column(name = "person")
    private int person;

    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer number;

    @Override
    public void setNumber(int number) {
        this.number = number;
    }
}
package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IPessoa;
import jakarta.persistence.*;
import lombok.Data;

/////////////////////////
@Data
@Entity
@Table(name = "PERSON")
@NamedQuery(
        name = "Utilizador.findByKey",
        query = "SELECT u FROM Pessoa u WHERE u.id = :id"
)
public class Pessoa implements IPessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 40, unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private Integer taxnumber;

    @Column(length = 50, nullable = false)
    private String name;

    public void setTaxnumber(int taxnumber) {
        this.taxnumber = taxnumber;
    }

    public int getTaxnumber() {
        return this.taxnumber;
    }
}
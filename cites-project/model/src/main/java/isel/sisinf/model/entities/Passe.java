package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IPasse;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "CARD")
@NamedQuery(
        name = "Passe.findByKey",
        query = "SELECT p FROM Passe p WHERE p.id = :id"
)
public class Passe implements IPasse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 4, scale = 2)
    private BigDecimal credit;

    @ManyToOne
    @JoinColumn(name = "typeofcard", referencedColumnName = "reference")
    private TipoDePasse typeofcard;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "person")
    private Pessoa client;

    @Override
    public void setClient(Pessoa client) {
        this.client = client;
    }

    @Override
    public Pessoa getClient() {
        return this.client;
    }
}
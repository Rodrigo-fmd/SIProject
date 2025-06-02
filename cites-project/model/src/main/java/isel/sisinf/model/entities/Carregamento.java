package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.ICarregamento;
import isel.sisinf.model.interfaces.IPasse;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@NamedQuery(
        name = "Carregamento.findByKey",
        query = "SELECT c FROM Carregamento c WHERE c.id = :id"
)
public class Carregamento implements ICarregamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;

    @Column(unique = true, nullable = false)
    private Timestamp data;

    @Column(nullable = false)
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "passe_id", nullable = false)
    private Passe passe;

    @Override
    public IPasse getPasse() {
        return passe;
    }

    @Override
    public void setPasse(IPasse passe) {
        this.passe = (Passe) passe;
    }
}
package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IReferencia;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@NamedQuery(
        name = "Referencia.findByKey",
        query = "SELECT r FROM Referencia r WHERE r.id = :id"
)
public class Referencia implements IReferencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int nOfDays;
    @Column(nullable = false)
    private BigDecimal price;
}

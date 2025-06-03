package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.ITipoDePasse;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "TYPEOFCARD")
@NamedQuery(
        name = "TipoDePasse.findByKey",
        query = "SELECT t FROM TipoDePasse t WHERE t.reference = :reference"
)
public class TipoDePasse implements ITipoDePasse {
    @Id
    @Column(length = 10)
    private String reference;

    @Column(nullable = false)
    private int nodays;

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal price;
}
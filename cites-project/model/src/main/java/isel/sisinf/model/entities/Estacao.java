package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IEstacao;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "STATION")
@NamedQuery(
        name = "Estacao.findByKey",
        query = "SELECT e FROM Estacao e WHERE e.id = :id"
)
@NamedQuery(
        name = "Estacao.findAll",
        query = "SELECT e FROM Estacao e"
)
public class Estacao implements IEstacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(precision = 6, scale = 4, nullable = false)
    private BigDecimal latitude;

    @Column(precision = 6, scale = 4, nullable = false)
    private BigDecimal longitude;
}
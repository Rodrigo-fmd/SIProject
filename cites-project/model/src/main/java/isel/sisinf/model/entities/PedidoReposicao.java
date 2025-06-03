package isel.sisinf.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "REPLACEMENTORDER")
@IdClass(PedidoReposicaoId.class)
@NamedQuery(
        name = "PedidoReposicao.findByKey",
        query = "SELECT p FROM PedidoReposicao p WHERE p.dorder = :dorder AND p.station = :station"
)
public class PedidoReposicao {

    @Id
    @Column(nullable = false)
    private Timestamp dorder;

    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "station", referencedColumnName = "id")
    private Estacao station;

    @Column
    private Timestamp dreplacement;

    @Column(nullable = false)
    private int roccupation;
}
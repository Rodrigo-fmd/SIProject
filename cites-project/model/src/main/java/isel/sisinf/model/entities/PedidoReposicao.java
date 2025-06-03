package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IPedidoReposicao;
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
public class PedidoReposicao implements IPedidoReposicao {

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

    @Override
    public void setStation(Estacao station) {
        this.station = station;
    }

    @Override
    public Estacao getStation() {
        return this.station;
    }
}
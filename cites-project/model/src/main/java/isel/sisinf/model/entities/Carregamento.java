package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.ICarregamento;
import isel.sisinf.model.interfaces.IPasse;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "TOPUP")
@NamedQuery(
        name = "Carregamento.findByKey",
        query = "SELECT c FROM Carregamento c WHERE c.dttopup = :dttopup AND c.card.id = :cardId"
)
public class Carregamento implements ICarregamento {
    @Id
    @Column(name = "dttopup", nullable = false)
    private Timestamp dttopup;

    @ManyToOne
    @JoinColumn(name = "card", referencedColumnName = "id", nullable = false)
    private Passe card;

    @Column(nullable = false)
    private BigDecimal value;

    @Override
    public IPasse getCard() {
        return card;
    }

    @Override
    public void setCard(IPasse card) {
        this.card = (Passe) card;
    }
}
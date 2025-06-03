package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IViagem;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "TRAVEL")
@IdClass(ViagemPK.class)
@NamedQuery(
    name = "Viagem.findByKey",
    query = "SELECT v FROM Viagem v WHERE v.dinitial = :dinitial AND v.scooter.id = :scooter"
)
@NamedQuery(
        name = "Viagem.findAll",
        query = "SELECT v FROM Viagem v"
)
public class Viagem implements IViagem {
    @Id
    @Column(nullable = false)
    private Timestamp dinitial;

    @Id
    @ManyToOne
    @JoinColumn(name = "scooter", referencedColumnName = "id", nullable = false)
    private Trotineta scooter;

    @Column(length = 100)
    private String comment;

    private Integer evaluation;

    private Timestamp dfinal;

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "person", nullable = false)
    private Pessoa client;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Estacao stinitial;

    @ManyToOne
    @JoinColumn
    private Estacao stfinal;
}
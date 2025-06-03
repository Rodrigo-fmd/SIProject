package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IDoca;
import isel.sisinf.model.interfaces.IEstacao;
import isel.sisinf.model.interfaces.ITrotineta;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@NamedStoredProcedureQuery(
        name = "startTrip",
        procedureName = "startTrip",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "dockid", type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "clientid", type = Integer.class)
        }
)
@Data
@Entity
@Table(name = "DOCK")
@NamedQuery(
        name = "Doca.findByKey",
        query = "SELECT d FROM Doca d WHERE d.number = :number"
)
@NamedQuery(
        name = "Doca.findAll",
        query = "SELECT d FROM Doca d"
)
public class Doca implements IDoca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;

    @ManyToOne(optional = false)
    @JoinColumn(name = "station", referencedColumnName = "id")
    private Estacao station;

    @Column(nullable = false, length = 30)
    private String state;

    @ManyToOne
    @JoinColumn(name = "scooter", referencedColumnName = "id")
    private Trotineta scooter;

    @Column
    private Timestamp version;

    @Override
    public IEstacao getStation() {
        return station;
    }

    @Override
    public void setStation(IEstacao station) {
        this.station = (Estacao) station;
    }

    @Override
    public ITrotineta getScooter() {
        return scooter;
    }

    @Override
    public void setScooter(ITrotineta scooter) {
        this.scooter = (Trotineta) scooter;
    }
}
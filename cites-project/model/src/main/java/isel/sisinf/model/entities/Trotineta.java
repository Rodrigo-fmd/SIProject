package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.ITrotineta;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "SCOOTER")
@NamedQuery(
        name = "Trotineta.findByKey",
        query = "SELECT t FROM Trotineta t WHERE t.id = :id"
)
@NamedQuery(
        name = "Trotineta.findAll",
        query = "SELECT t FROM Trotineta t"
)
public class Trotineta implements ITrotineta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal weight;

    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal maxVelocity;
    @Column(nullable = false)
    private Integer battery;

    @ManyToOne(optional = false)
    @JoinColumn(name = "model", referencedColumnName = "number")
    private Modelo modelo;

    @Column(nullable = false)
    private Timestamp version;

    @Override
    public void setBattery(int battery) {
        this.battery = battery;
    }

    @Override
    public int getBattery() {
        return battery != null ? battery : 0;
    }

    @Override
    public Modelo getModel() {
        return modelo;
    }

    @Override
    public void setModel(isel.sisinf.model.interfaces.IModel model) {
        this.modelo = (Modelo) model;
    }
}
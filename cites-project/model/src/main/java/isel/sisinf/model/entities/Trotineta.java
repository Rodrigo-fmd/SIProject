package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IDoca;
import isel.sisinf.model.interfaces.ITrotineta;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@NamedQuery(
        name = "Trotineta.findByKey",
        query = "SELECT t FROM Trotineta t WHERE t.id = :id"
        )
public class Trotineta implements ITrotineta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int maxSpeed;

    @Column(nullable = false)
    private int autonomy;

    @Column(nullable = false)
    private int weight;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private String brand;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "doca_id")
    private Doca doca;

    @Override
    public Doca getDoca() {
        return doca;
    }

    @Override
    public void setDoca(IDoca doca) {
        this.doca = (Doca) doca;
    }

}

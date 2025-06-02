package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.IPasse;
import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

import isel.sisinf.model.interfaces.IReferencia;
import isel.sisinf.model.interfaces.IUtilizador;


@Data
@Entity
@NamedQuery(
        name="Passe.findByKey",
        query="SELECT p FROM Passe p WHERE p.id = :id"
        )
public class Passe implements IPasse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private Timestamp aquiredDate;

    @Column(nullable = false)
    private BigDecimal balance;

    @OneToOne
    @JoinColumn(name = "utilizador_nif", nullable = false)
    private Utilizador utilizador;

    @OneToOne
    @JoinColumn(name = "referencia_id", nullable = false)
    private Referencia referencia;

    @Override
    public IUtilizador getUtilizador() {
        return utilizador;
    }

    @Override
    public void setUtilizador(IUtilizador utilizador) {
        this.utilizador = (Utilizador) utilizador;
    }

    @Override
    public IReferencia getReferencia() {
        return referencia;
    }

    @Override
    public void setReferencia(IReferencia referencia) {
        this.referencia = (Referencia) referencia;
    }

}

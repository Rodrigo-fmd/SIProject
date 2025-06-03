package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.ICliente;
import jakarta.persistence.*;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "CLIENT")
@NamedQuery(
        name = "Cliente.findByKey",
        query = "SELECT c FROM Cliente c WHERE c.person = :personId"
)
@NamedQuery(
        name = "Cliente.findAll",
        query = "SELECT c FROM Cliente c"
)
public class Cliente implements ICliente {
    @Id
    @Column(name = "person")
    private int person;

    @Column(name = "dtregister", nullable = false)
    private Timestamp dtregister;

    @OneToOne
    @JoinColumn(name = "person", referencedColumnName = "id", insertable = false, updatable = false)
    private Pessoa personEntity;
}
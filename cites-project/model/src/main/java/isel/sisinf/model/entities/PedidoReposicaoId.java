package isel.sisinf.model.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Embeddable
public class PedidoReposicaoId implements Serializable {
    private Timestamp dorder;
    private int station;

    public PedidoReposicaoId() {}
}
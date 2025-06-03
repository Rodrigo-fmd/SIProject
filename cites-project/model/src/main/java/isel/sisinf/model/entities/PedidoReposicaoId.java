package isel.sisinf.model.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class PedidoReposicaoId implements Serializable {
    private Timestamp dorder;
    private int station;

    public PedidoReposicaoId() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoReposicaoId that = (PedidoReposicaoId) o;
        return station == that.station && dorder.equals(that.dorder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dorder, station);
    }
}
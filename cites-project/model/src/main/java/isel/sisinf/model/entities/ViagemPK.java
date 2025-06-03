package isel.sisinf.model.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class ViagemPK implements Serializable {
    private Timestamp dinitial;
    private int scooter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ViagemPK)) return false;
        ViagemPK that = (ViagemPK) o;
        return scooter == that.scooter &&
                Objects.equals(dinitial, that.dinitial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dinitial, scooter);
    }
}
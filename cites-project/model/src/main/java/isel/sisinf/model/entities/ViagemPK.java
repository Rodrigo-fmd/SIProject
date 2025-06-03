package isel.sisinf.model.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Embeddable
public class ViagemPK implements Serializable {
    private Timestamp dinitial;
    private int scooter;
}
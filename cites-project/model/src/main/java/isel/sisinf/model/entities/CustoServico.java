package isel.sisinf.model.entities;

import isel.sisinf.model.interfaces.ICustoServico;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "SERVICECOST")
@NamedQuery(
        name = "CustoServico.findByKey",
        query = "SELECT c FROM CustoServico c WHERE c.id = :id"
)
public class CustoServico implements ICustoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal usable;

    @Column(nullable = false, precision = 3, scale = 2)
    private BigDecimal unlock;
}
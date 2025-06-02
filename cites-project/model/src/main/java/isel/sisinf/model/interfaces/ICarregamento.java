package isel.sisinf.model.interfaces;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface ICarregamento {
    int getId();
    void setId(int id);

    Timestamp getData();
    void setData(Timestamp data);

    BigDecimal getValor();
    void setValor(BigDecimal valor);

    IPasse getPasse();
    void setPasse(IPasse passe);
}
package isel.sisinf.model.interfaces;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface IPasse {
    int getId();
    void setId(int id);

    Timestamp getAquiredDate();
    void setAquiredDate(Timestamp aquiredDate);

    BigDecimal getBalance();
    void setBalance(BigDecimal balance);

    IUtilizador getUtilizador();
    void setUtilizador(IUtilizador utilizador);

    IReferencia getReferencia();
    void setReferencia(IReferencia referencia);
}

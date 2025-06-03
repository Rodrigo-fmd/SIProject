package isel.sisinf.model.interfaces;

import isel.sisinf.model.entities.Pessoa;
import isel.sisinf.model.entities.TipoDePasse;

import java.math.BigDecimal;

public interface IPasse {
    int getId();
    void setId(int id);

    BigDecimal getCredit();
    void setCredit(BigDecimal credit);

    void setTypeofcard(TipoDePasse tipoDePasse);
    TipoDePasse getTypeofcard();

    void setClient(Pessoa client);
    Pessoa getClient();
}
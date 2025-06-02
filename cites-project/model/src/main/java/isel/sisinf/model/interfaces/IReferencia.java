package isel.sisinf.model.interfaces;

import isel.sisinf.model.entities.Referencia;

import java.math.BigDecimal;

public interface IReferencia {
    public int getId();
    public void setId(int id);

    public int getNOfDays();
    public void setNOfDays(int nOfDays);

    public BigDecimal getPrice();
    public void setPrice(BigDecimal price);
}

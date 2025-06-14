package isel.sisinf.model.interfaces;

import java.math.BigDecimal;

public interface ITipoDePasse {
    String getReference();
    void setReference(String reference);

    int getNodays();
    void setNodays(int nodays);

    BigDecimal getPrice();
    void setPrice(BigDecimal price);
}